package com.ers.dal.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.ers.common.DbConnectionManager;
import com.ers.valueobject.ApproveOrRejectVO;

/**
 *ApproverDAO.java
 *
 *Version:1.0
 *Date: 21-Mar-2016
 *Author:Kowsalya Jaganathan
 *
 *This class is to perform approval or rejection operation in database for 
 *each submitted reimbursement forms
 *FactoryMethod design pattern is being used
 *
*/

public class ApproverDAO implements OperationDAOFactory{
	final static Logger logger = Logger.getLogger(ApproverDAO.class);
	ApproveOrRejectVO valueObject=null;
	
	public ApproverDAO(ApproveOrRejectVO valueObject){
		this.valueObject = valueObject;
	}
	
	public boolean performOperation(){
		boolean isSuccess=false;
		try(Connection connection = DbConnectionManager.getConnection();Statement statement=connection.createStatement()){
			logger.debug("Entering : ApproverDAO.performOperation");			
			String sql = "UPDATE REIMBURSEMENT_FORM_DETAILS SET MODIFIED_DATE=CURRENT_TIMESTAMP, STATUS='"+valueObject.getStatusToBeSet() +"' WHERE FORM_ID='";
			sql = sql+valueObject.getReimbursementId()+"'";
			logger.debug("SQL"+sql);
			int result = statement.executeUpdate(sql);
			if(result>0)
				isSuccess=true;
			logger.debug("Exiting : ApproverDAO.performOperation");
		}catch(SQLException sqle){
			logger.error("Exception "+sqle.getStackTrace());		
		}catch(Exception e){
			logger.error("Exception "+e.getStackTrace());
		}
		return isSuccess;
	}
}