package com.ers.dal.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.ers.common.DbConnectionManager;
import com.ers.util.Constants;
import com.ers.util.Util;
import com.ers.valueobject.ReimbursementVO;

/**
 *CreateDAO.java
 *
 *Version:1.0
 *Date: 21-Mar-2016
 *Author:Kowsalya Jaganathan
 *
 *This class is to perform creation operation in database for each reimbursement form
 *which is being submitted 
 *FactoryMethod design pattern is being used
 *
*/

public class CreateDAO implements OperationDAOFactory{
	final static Logger logger = Logger.getLogger(CreateDAO.class);
	ReimbursementVO valueObject=null;
	
	public CreateDAO(ReimbursementVO valueObject){
		this.valueObject = valueObject;
	}
	
	public boolean performOperation(){
		boolean isSuccess=false;
		Util util = new Util();
		UUID formId = UUID.randomUUID();
		String formType =valueObject.getReimbursementType();
		try(Connection connection = DbConnectionManager.getConnection();Statement statement=connection.createStatement()){
			StringBuilder sql = new StringBuilder();			
			sql.append("INSERT INTO REIMBURSEMENT_FORM_DETAILS (FORM_ID,SUBMITTER_ID, APPROVER_ID, TYPE, ")
			   .append("RECEIPT_NUM, AMOUNT, TO_DATE, FROM_DATE, STATUS, MODIFIED_DATE,");
			   if(Constants.FORM_CERTIFICATION.equals(formType)){
				   sql.append("CERT_TYPE,IS_PASS,SCORE");
			   }else if(Constants.FORM_TEAMEVENT.equals(formType)){
				   sql.append("ACTIVITY_TYPE");
			   }else if(Constants.FORM_TRAINING.equals(formType)){
				   sql.append("TRAINING_TYPE");
			   }else if(Constants.FORM_TEAMEVENT.equals(formType)){
				   sql.append("FROM_COUNTRY,FROM_CITY,TO_COUNTRY,TO_CITY) VALUES('");
			   }
			 sql.append(formId)
			   .append("','")
			   .append(valueObject.getSubmitterId())
			   .append("','")
			   .append(valueObject.getApproverId())
			   .append("','")
			   .append(valueObject.getActivityType())
			   .append("','")
			   .append(valueObject.getReceiptNum())
			   .append("','")
			   .append(valueObject.getAmount())
			   .append("','")
			   .append(util.dateFormat(valueObject.getToDate()))
			   .append("','")
			   .append(util.dateFormat(valueObject.getFromDate()))
			   .append("','")
			   .append(Constants.STATUS_CREATED)
			   .append("',CURRENT_TIMESTAMP");
			if(Constants.FORM_CERTIFICATION.equals(formType)){
			   sql.append(valueObject.getCertificationType())
			   .append("','");
			   if(valueObject.isPass()) {
				   sql.append('Y');
			   }else{
				   sql.append('N');
			   }
			   sql.append("','")
			      .append(valueObject.getScore());
			}else if(Constants.FORM_TEAMEVENT.equals(formType)){
				sql.append(valueObject.getActivityType())
				   .append("','");
			}else if(Constants.FORM_TRAINING.equals(formType)){
			 sql.append(valueObject.getTrainingType())
				.append("','");
			}else if(Constants.FORM_TEAMEVENT.equals(formType)){
			sql.append(valueObject.getFromCountry())
				.append("','")
			   .append(valueObject.getFromCity())
			   .append("','")
			   .append(valueObject.getToCountry())
			   .append("','")
			   .append(valueObject.getToCity())
			   .append("')");
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