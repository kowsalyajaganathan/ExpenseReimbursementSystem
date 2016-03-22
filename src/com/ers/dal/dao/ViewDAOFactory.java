package com.ers.dal.dao;

import java.util.ArrayList;

/**
 *ViewDAOFactory.java
 *
 *Version:1.0
 *Date: 21-Mar-2016
 *Author:Kowsalya Jaganathan
 *
 *This interface is to produce different types of DAOs to retrieve data from database 
 *FactoryMethod design pattern is being used
 *
*/

public interface ViewDAOFactory{
	
	public ArrayList<?> performOperation();
}