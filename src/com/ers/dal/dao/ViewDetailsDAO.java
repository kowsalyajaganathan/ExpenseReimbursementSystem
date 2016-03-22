package com.ers.dal.dao;

import java.util.ArrayList;

import com.ers.valueobject.ReimbursementVO;

/**
 *ViewDetailsDAO.java
 *
 *Version:1.0
 *Date: 21-Mar-2016
 *Author:Kowsalya Jaganathan
 *
 *This class is retrieve detailed info about each reimbursement form
 * 
 *FactoryMethod design pattern is being used
 *
*/

public class ViewDetailsDAO implements ViewDAOFactory{
	 ReimbursementVO valueObject=null;
		
	public ViewDetailsDAO(ReimbursementVO valueObject){
		this.valueObject = valueObject;
	}
	public ArrayList<ReimbursementVO> performOperation(){
		ArrayList<ReimbursementVO> reimbursementDetailsList = null;
		return reimbursementDetailsList;
	}
}