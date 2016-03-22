package com.ers.workflow;

import java.util.ArrayList;

import com.ers.dal.dao.ViewDAOFactory;
import com.ers.dal.dao.ViewDetailsDAO;
import com.ers.valueobject.EmployeeVO;
import com.ers.valueobject.ReimbursementVO;


/**
 *ViewDetailsAction.java
 *
 *Version:1.0
 *Date: 21-Mar-2016
 *Author:Kowsalya Jaganathan
 *
 *
 *This class is to retrieve details of reimbursement form
 *
 *
*/

public class ViewDetailsAction implements DisplayActionFactory{
	ViewDAOFactory viewDAOFactory = null;
	ReimbursementVO viewDetailsVO= new ReimbursementVO();
	

	public ArrayList<ReimbursementVO> getList(EmployeeVO emp){
		ArrayList<ReimbursementVO> reimbursementDetailsList  =null;
		viewDetailsVO.setEmpId(emp.getEmpId());
		viewDAOFactory = getViewDetailsDAO(viewDetailsVO);
		reimbursementDetailsList = (ArrayList<ReimbursementVO>)viewDAOFactory.performOperation();
		
		return reimbursementDetailsList;
	}
	public ViewDAOFactory getViewDetailsDAO(ReimbursementVO reimbursementVO ){
		viewDAOFactory = new ViewDetailsDAO(reimbursementVO);
		return viewDAOFactory;
	}
	
}