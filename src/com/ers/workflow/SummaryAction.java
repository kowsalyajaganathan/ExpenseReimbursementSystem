package com.ers.workflow;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.Logger;

import com.ers.dal.dao.EmployeeDAO;
import com.ers.dal.dao.SummaryDAO;
import com.ers.dal.dao.ViewDAOFactory;
import com.ers.valueobject.EmployeeVO;
import com.ers.valueobject.SummaryVO;
import com.ers.valueobject.VOFactory;


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
	EmployeeVO employeeVO = new EmployeeVO();
	final static Logger logger = Logger.getLogger(SummaryAction.class);
	
	
	/*
	 * (non-Javadoc)
	 * @see com.ers.workflow.DisplayActionFactory#getList(com.ers.valueobject.VOFactory)
	 */
	public ArrayList<ArrayList<SummaryVO>> getList(VOFactory vo){
		vo = (EmployeeVO)employeeVO;
		return getList(vo);
	}
    
	
	@SuppressWarnings("unchecked")
	public ArrayList<ArrayList<SummaryVO>> getList(EmployeeVO employeeVO){
		EmployeeDAO empDAO = new EmployeeDAO();
		SummaryVO summaryVO = new SummaryVO();
		ArrayList<SummaryVO> tempList  =null;
		ArrayList<ArrayList<SummaryVO>> summaryList = new ArrayList<ArrayList<SummaryVO>>();
		ArrayList<SummaryVO> submitterList = new ArrayList<SummaryVO>();
		ArrayList<SummaryVO> approverList = new ArrayList<SummaryVO>();
	    Iterator<SummaryVO> summaryIterator;
		try{
		    employeeVO = empDAO.performOperation(employeeVO);
		    summaryVO.setEmpId(employeeVO.getEmpId());
		    summaryVO.setApprover(employeeVO.isSupervisor());
			viewDAOFactory = getViewDAO(summaryVO);
			tempList = (ArrayList<SummaryVO>)viewDAOFactory.performOperation();
			if(tempList.size()>0){
				summaryIterator = tempList.iterator();
				while(summaryIterator.hasNext()){
					summaryVO = (SummaryVO)summaryIterator.next();
					if(summaryVO.getEmpId()== employeeVO.getEmpId()){
						submitterList.add(summaryVO);
					}else{
						approverList.add(summaryVO);
					}
				}			
				summaryList.add(submitterList);
				summaryList.add(approverList);
			}
	    }catch(Exception e){
    	logger.error("Exception"+e.getStackTrace());
	    }
		return summaryList;
	}
	public ViewDAOFactory getViewDAO(SummaryVO summaryVO ){
		viewDAOFactory = new SummaryDAO(summaryVO);
		return viewDAOFactory;
	}
	
}