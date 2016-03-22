package com.ers.dal.dao;


/**
 *OperationDAOFactory.java
 *
 *Version:1.0
 *Date: 21-Mar-2016
 *Author:Kowsalya Jaganathan
 *
 *This interface is to produce different types of DAOs to perform database operations
 *for each reimbursement forms
 *FactoryMethod design pattern is being used
 *
*/

public interface OperationDAOFactory{
	
	public boolean performOperation();
}