package com.ers.workflow;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ers.dal.dao.ViewDAOFactory;
import com.ers.dal.dao.ViewDetailsDAO;
import com.ers.valueobject.EmployeeVO;
import com.ers.valueobject.ReimbursementVO;
import com.ers.valueobject.VOFactory;


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
	final static Logger logger = Logger.getLogger(ViewDetailsAction.class);
	ViewDAOFactory viewDAOFactory = null;
	ReimbursementVO viewDetailsVO= new ReimbursementVO();
	EmployeeVO employeeVO ;
	
	public ArrayList<ReimbursementVO> getList(VOFactory VO){
		employeeVO = (EmployeeVO)VO;
		return getList(employeeVO);
	}

	public ArrayList<ReimbursementVO> getList(EmployeeVO emp){
		ArrayList<ReimbursementVO> reimbursementDetailsList  =null;
		try{
			viewDetailsVO.setSubmitterId(emp.getEmpId());
			viewDAOFactory = getViewDetailsDAO(viewDetailsVO);
			reimbursementDetailsList = (ArrayList<ReimbursementVO>)viewDAOFactory.performOperation();
		}catch(Exception e){
			logger.error("Exception"+e.getStackTrace());
		}
		return reimbursementDetailsList;
	}
	public ViewDAOFactory getViewDetailsDAO(ReimbursementVO reimbursementVO ){
		viewDAOFactory = new ViewDetailsDAO(reimbursementVO);
		return viewDAOFactory;
	}
	
}