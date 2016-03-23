package com.ers.dal.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ers.common.DbConnectionManager;
import com.ers.valueobject.ReimbursementVO;

/**
 *ViewDetailsDAO.java
 *
 *Version:1.0
 *Date: 21-Mar-2016
 *Author:Kowsalya Jaganathan
 *
 *This class is retrieve detailed info about each reimbursement form
 * 
 *FactoryMethod design pattern is being used
 *
*/

public class ViewDetailsDAO implements ViewDAOFactory{
	final static Logger logger = Logger.getLogger(ViewDetailsDAO.class);
	 ReimbursementVO valueObject=null;
		
	public ViewDetailsDAO(ReimbursementVO valueObject){
		this.valueObject = valueObject;
	}
	public ArrayList<ReimbursementVO> performOperation(){
		ArrayList<ReimbursementVO> reimbursementDetailsList = new ArrayList<ReimbursementVO>();
		ReimbursementVO reimbursementVO = new ReimbursementVO();
		try(Connection connection = DbConnectionManager.getConnection();Statement statement=connection.createStatement()){
			String sql = "SELECT * FROM REIMBURSEMENT_FORM_DETAILS WHERE FORM_ID='";
			sql = sql+valueObject.getReimbursementId()+"'";
			logger.debug("SQL"+sql);
			ResultSet resultset = statement.executeQuery(sql);
			while(resultset.next()){
				reimbursementVO.setActivityType(resultset.getString("ACTIVITY_TYPE"));
				reimbursementVO.setAmount(resultset.getFloat("AMOUNT"));
				reimbursementVO.setCertificationType(resultset.getString("CERT_TYPE"));
				reimbursementVO.setSubmitterId(resultset.getInt("SUBMITTER_ID"));
				reimbursementVO.setApproverId(resultset.getInt("APPROVER_ID"));
				reimbursementVO.setStatus(resultset.getString("CERT_TYPE"));
				reimbursementVO.setModifiedDate(resultset.getTimestamp("MODIFIED_DATE"));
				reimbursementVO.setFromCity(resultset.getString("FROM_CITY"));
				reimbursementVO.setFromCountry(resultset.getString("FROM_COUNTRY"));
				reimbursementVO.setFromDate(resultset.getTimestamp("FROM_DATE"));
				reimbursementVO.setPass(resultset.getBoolean("IS_PASS"));
				reimbursementVO.setReceiptNum(resultset.getInt("RECEIPT_NUM"));
				reimbursementVO.setReimbursementId(resultset.getInt("FORM_ID"));
				reimbursementVO.setReimbursementType(resultset.getString("TYPE"));
				reimbursementVO.setScore(resultset.getFloat("SCORE"));
				reimbursementVO.setToCity(resultset.getString("TO_CITY"));
				reimbursementVO.setToCountry(resultset.getString("TO_COUNTRY"));
				reimbursementVO.setToDate(resultset.getTimestamp("TO_DATE"));
				reimbursementVO.setTrainingType(resultset.getString("TRAINING_TYPE"));
			}
			reimbursementDetailsList.add(reimbursementVO);
			
				
		}catch(SQLException sqle){
			logger.error("Exception "+sqle.getStackTrace());	
		
		}catch(Exception e){
			logger.error("Exception "+e.getStackTrace());	
		}
		
		return reimbursementDetailsList;
	}
}