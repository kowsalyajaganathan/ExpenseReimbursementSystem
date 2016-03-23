package com.ers.dal.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.ers.common.DbConnectionManager;
import com.ers.valueobject.ReimbursementVO;
import com.ers.util.Constants;
import com.ers.util.Util;

/**
 *UpdateDAO.java
 *
 *Version:1.0
 *Date: 21-Mar-2016
 *Author:Kowsalya Jaganathan
 *
 *This class is update details for each submitted reimbursement form
 * 
 *FactoryMethod design pattern is being used
 *
*/

public class UpdateDAO implements OperationDAOFactory{
	final static Logger logger = Logger.getLogger(UpdateDAO.class);
	ReimbursementVO valueObject=null;
	
	public UpdateDAO(ReimbursementVO valueObject){
		this.valueObject = valueObject;
	}
	
	public boolean performOperation(){
		boolean isSuccess=false;
		Util util = new Util();
		String formType =valueObject.getReimbursementType();
		try(Connection connection = DbConnectionManager.getConnection();Statement statement=connection.createStatement()){
			StringBuilder sql = new StringBuilder();			
			sql.append("UPDATE REIMBURSEMENT_FORM_DETAILS SET MODIFIED_DATE=CURRENT_TIMESTAMP,RECEIPT_NUM='")
			   .append(valueObject.getReceiptNum())
			   .append("', AMOUNT ='")
			   .append(valueObject.getAmount())
			   .append("', TO_DATE ='")
			   .append(util.dateFormat(valueObject.getToDate()))
			   .append("', FROM_DATE ='")
			   .append(util.dateFormat(valueObject.getFromDate()));
			if(Constants.FORM_CERTIFICATION.equals(formType)){
			   sql.append("', CERT_TYPE ='")
			   .append(valueObject.getCertificationType())
			   .append("', IS_PASS ='");
			   if(valueObject.isPass()) {
				   sql.append('Y');
			   }else{
				   sql.append('N');
			   }
			   sql.append("', SCORE ='")
			   .append(valueObject.getScore());
			}else if(Constants.FORM_TEAMEVENT.equals(formType)){
				sql.append("', ACTIVITY_TYPE ='")
			   .append(valueObject.getActivityType());
			}else if(Constants.FORM_TRAINING.equals(formType)){
				sql.append("', TRAINING_TYPE ='")
			   .append(valueObject.getTrainingType());
			}else if(Constants.FORM_TEAMEVENT.equals(formType)){
				sql.append("', FROM_COUNTRY ='")
			   .append(valueObject.getFromCountry())
			   .append("', FROM_CITY ='")
			   .append(valueObject.getFromCity())
			   .append("', TO_COUNTRY ='")
			   .append(valueObject.getToCountry())
			   .append("', TO_CITY ='")
			   .append(valueObject.getToCity())
			   .append("WHERE FORM_ID='")
			   .append(valueObject.getReimbursementId())
			   .append("'");
			}			   
			logger.debug("SQL"+sql);
			int result = statement.executeUpdate(sql.toString());
			if(result>0)
				isSuccess=true;
		}catch(SQLException sqle){
			logger.error("Exception "+sqle.getStackTrace());	
		
		}catch(Exception e){
			logger.error("Exception "+e.getStackTrace());	
		}
		return isSuccess;
	}
}