package com.ers.dal.dao;

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
	ReimbursementVO valueObject=null;
	
	public CreateDAO(ReimbursementVO valueObject){
		this.valueObject = valueObject;
	}
	
	public boolean performOperation(){
		return true;
	}
}