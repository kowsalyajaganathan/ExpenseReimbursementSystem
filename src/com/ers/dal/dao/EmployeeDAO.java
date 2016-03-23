package com.ers.dal.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import org.apache.log4j.Logger;

import com.ers.common.DbConnectionManager;
import com.ers.servlet.LoginServlet;
import com.ers.valueobject.EmployeeVO;

/**
 *EmployeeDAO.java
 *
 *Version:1.0
 *Date: 21-Mar-2016
 *Author:Kowsalya Jaganathan
 *
 *This class is retrieve employee details 
 * 
 *
 *
*/

public class EmployeeDAO {
	 EmployeeVO valueObject=null;
     final static Logger logger = Logger.getLogger(EmployeeDAO.class);
    
	public EmployeeDAO(EmployeeVO valueObject){
		this.valueObject = valueObject;
	}
	public EmployeeVO performOperation(EmployeeVO valueObject){
		try(Connection connection = DbConnectionManager.getConnection();Statement statement=connection.createStatement()){
			String sql = "SELECT * FROM EMPLOYEE WHERE EMP_ID='";
			sql = sql+valueObject.getEmpId()+"'";
			logger.debug("SQL"+sql);
			ResultSet resultset = statement.executeQuery(sql);
			while(resultset.next()){
				valueObject.setName(resultset.getString("NAME"));
				valueObject.setEmpId(resultset.getInt("EMP_ID"));
			}
		}catch(Exception e){
			logger.error("Exception at EmployeeDAO::performOperation"+e.getStackTrace());
		}
		return valueObject;
	}
}