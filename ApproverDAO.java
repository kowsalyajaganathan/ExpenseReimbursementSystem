package com.ers.dal.dao;

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
	ApproveOrRejectVO valueObject=null;
	
	public ApproverDAO(ApproveOrRejectVO valueObject){
		this.valueObject = valueObject;
	}
	
	public boolean performOperation(){
		return true;
	}
}