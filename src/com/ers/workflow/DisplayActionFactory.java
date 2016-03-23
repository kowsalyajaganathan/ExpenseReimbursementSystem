package com.ers.workflow;

import java.util.ArrayList;

import com.ers.valueobject.VOFactory;

/**
 *DisplayActionFactory.java
 *
 *Version:1.0
 *Date: 21-Mar-2016
 *Author:Kowsalya Jaganathan
 *
 *This interface is to produce different types of action categories 
 *FactoryMethod design pattern is being used
 *
*/

public interface DisplayActionFactory{
	public ArrayList<?> getList( VOFactory vo);
}