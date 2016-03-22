package com.ers.dal.dao;

import com.ers.valueobject.ReimbursementVO;

/**
 *UpdateDAO.java
 *
 *Version:1.0
 *Date: 21-Mar-2016
 *Author:Kowsalya Jaganathan
 *
 *This class is update details for each submitted reimbursement form
 * 
 *FactoryMethod design pattern is being used
 *
*/

public class UpdateDAO implements OperationDAOFactory{
	ReimbursementVO valueObject=null;
	
	public UpdateDAO(ReimbursementVO valueObject){
		this.valueObject = valueObject;
	}
	
	public boolean performOperation(){
		return true;
	}
}