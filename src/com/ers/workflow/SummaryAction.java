package com.ers.workflow;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.Logger;

import com.ers.dal.dao.EmployeeDAO;
import com.ers.dal.dao.SummaryDAO;
import com.ers.dal.dao.ViewDAOFactory;
import com.ers.valueobject.EmployeeVO;
import com.ers.valueobject.SummaryVO;


/**
 *SummaryAction.java
 *
 *Version:1.0
 *Date: 21-Mar-2016
 *Author:Kowsalya Jaganathan
 *
 *
 *This class is to retrieve summary of reimbursement submissions
 *FactoryMethod design pattern is being used
 *
 *
*/

public class SummaryAction implements DisplayActionFactory{
	ViewDAOFactory viewDAOFactory = null;
	SummaryVO summaryVO = new SummaryVO();
	final static Logger logger = Logger.getLogger(SummaryAction.class);
	

	public ArrayList<ArrayList<SummaryVO>> getList(EmployeeVO emp){
		EmployeeVO employeeVO = new EmployeeVO();
		EmployeeDAO empDAO = new EmployeeDAO();
		
		ArrayList<SummaryVO> tempList  =null;
		ArrayList<ArrayList<SummaryVO>> summaryList = new ArrayList<ArrayList<SummaryVO>>();
		ArrayList<SummaryVO> submitterList = new ArrayList<SummaryVO>();
		ArrayList<SummaryVO> approverList = new ArrayList<SummaryVO>();
	    Iterator summaryIterator;
	    
	    employeeVO.setEmpId(emp.getEmpId());
	    employeeVO = empDAO.performOperation(employeeVO);
	    summaryVO.setEmpId(emp.getEmpId());
	    summaryVO.setApprover(false);
		viewDAOFactory = getViewDAO(summaryVO);
		submitterList = (ArrayList<SummaryVO>)viewDAOFactory.performOperation();
		if(submitterList.size()>0){
			summaryList.add(submitterList);
		}
		if(employeeVO.isSupervisor()){
			summaryVO.setApprover(true);
			viewDAOFactory = getViewDAO(summaryVO);
			approverList = (ArrayList<SummaryVO>)viewDAOFactory.performOperation();
		}
		if(approverList.size()>0){
			summaryList.add(approverList);
		}
		logger.info("in log4j");
		
		return summaryList;
	}
	public ViewDAOFactory getViewDAO(SummaryVO summaryVO ){
		viewDAOFactory = new SummaryDAO(summaryVO);
		return viewDAOFactory;
	}
	
}