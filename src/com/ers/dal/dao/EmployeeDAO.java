package com.ers.dal.dao;

import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;

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
    
	/*public SummaryDAO(SummaryVO valueObject){
		this.valueObject = valueObject;
	}*/
	public EmployeeVO performOperation(EmployeeVO valueObject){
		valueObject = new EmployeeVO();
		try{
			valueObject.setName("Kowsalya");
			valueObject.setSupervisor(true);
		}catch(Exception e){
			logger.error("Exception at EmployeeDAO::performOperation"+e.getStackTrace());
		}
		return valueObject;
	}
}