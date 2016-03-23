package com.ers.dal.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ers.common.DbConnectionManager;
import com.ers.valueobject.SummaryVO;

/**
 *SummaryDAO.java
 *
 *Version:1.0
 *Date: 21-Mar-2016
 *Author:Kowsalya Jaganathan
 *
 *This class is retrieve summary details about each reimbursement form
 * 
 *
 *
*/

public class SummaryDAO implements ViewDAOFactory{
	final static Logger logger = Logger.getLogger(SummaryDAO.class);
    SummaryVO valueObject=null;
	public SummaryDAO(SummaryVO valueObject){
		this.valueObject = valueObject;
	}
	public ArrayList<SummaryVO> performOperation(){
		ArrayList<SummaryVO> summaryList = new ArrayList<SummaryVO>();
		SummaryVO summaryVO = new SummaryVO();
		try(Connection connection = DbConnectionManager.getConnection();Statement statement=connection.createStatement()){
			String sql = "SELECT SUBMITTER_ID,APPROVER_ID,FORM_ID,TYPE,AMOUNT,MODIFIED_DATE,STATUS "
					+ "FROM REIMBURSEMENT_FORM_DETAILS WHERE SUBMITTER_ID='"
					+valueObject.getEmpId()+"' OR APPROVER_ID='";
			sql = sql+"'";
			logger.debug("SQL"+sql);
			ResultSet resultset = statement.executeQuery(sql);
			while(resultset.next()){
				summaryVO.setReimbursementId(resultset.getInt("FORM_ID"));
				summaryVO.setEmpId(resultset.getInt("SUBMITTER_ID"));
				summaryVO.setApproverEmpId(resultset.getInt("APPROVER_ID"));
				summaryVO.setType(resultset.getString("TYPE"));
				summaryVO.setAmount(resultset.getFloat("AMOUNT"));
				summaryVO.setOperationDate(resultset.getTimestamp("MODIFIED_DATE"));
				summaryVO.setStatus(resultset.getString("CERT_TYPE"));
				
				summaryList.add(summaryVO);
					
			}	
			/*valueObject.setReimbursementId(1);
			valueObject.setAmount(100.00);
			valueObject.setApprover(false);
			valueObject.setApproverEmpId(345);
			valueObject.setOperationDate(new Date());
			valueObject.setStatus("Submitted");
			valueObject.setType("Travel");
			
			summaryList.add(valueObject);*/
		}catch(Exception e){
			logger.error("Exception at SummaryDAO::performOperation"+e.getStackTrace());
		}
		return summaryList;
	}
}