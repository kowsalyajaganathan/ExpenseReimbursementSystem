package com.ers.dal.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.ers.common.DbConnectionManager;
import com.ers.valueobject.ReimbursementVO;

/**
 *DeleteDAO.java
 *
 *Version:1.0
 *Date: 21-Mar-2016
 *Author:Kowsalya Jaganathan
 *
 *This class is to perform deletion operation in database for each submitted 
 *reimbursement form
 * 
 *FactoryMethod design pattern is being used
 *
*/

public class DeleteDAO implements OperationDAOFactory{
	final static Logger logger = Logger.getLogger(DeleteDAO.class);
	ReimbursementVO valueObject=null;
	
	public DeleteDAO(ReimbursementVO valueObject){
		this.valueObject = valueObject;
	}
	public boolean performOperation(){
		boolean isSuccess=false;
		try(Connection connection = DbConnectionManager.getConnection();Statement statement=connection.createStatement()){
			String sql = "DELETE FROM REIMBURSEMENT_FORM_DETAILS WHERE FORM_ID='";
			sql = sql+valueObject.getReimbursementId()+"'";
			logger.debug("SQL"+sql);
			int result = statement.executeUpdate(sql);
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