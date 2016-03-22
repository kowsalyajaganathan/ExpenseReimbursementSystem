package com.ers.dal.dao;

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
	ReimbursementVO valueObject=null;
	
	public DeleteDAO(ReimbursementVO valueObject){
		this.valueObject = valueObject;
	}
	public boolean performOperation(){
		return true;
	}
}