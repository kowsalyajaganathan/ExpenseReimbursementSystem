package com.ers.dal.dao;

import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;

import com.ers.valueobject.SummaryVO;
import com.ers.workflow.SummaryAction;

/**
 *SummaryDAO.java
 *
 *Version:1.0
 *Date: 21-Mar-2016
 *Author:Kowsalya Jaganathan
 *
 *This class is retrieve summary details about each reimbursement form
 * 
 *
 *
*/

public class SummaryDAO implements ViewDAOFactory{
    SummaryVO valueObject=null;
    final static Logger logger = Logger.getLogger(SummaryAction.class);
    
	public SummaryDAO(SummaryVO valueObject){
		this.valueObject = valueObject;
	}
	public ArrayList<SummaryVO> performOperation(){
		ArrayList<SummaryVO> summaryList = new ArrayList<SummaryVO>();
		ArrayList<SummaryVO> submitterList = new ArrayList<SummaryVO>();
		ArrayList<SummaryVO> approverList = new ArrayList<SummaryVO>();
		try{
			valueObject.setReimbursementId(1);
			valueObject.setAmount(100.00);
			valueObject.setApprover(false);
			valueObject.setApproverEmpId(345);
			valueObject.setOperationDate(new Date());
			valueObject.setStatus("Submitted");
			valueObject.setType("Travel");
			
			summaryList.add(valueObject);
		}catch(Exception e){
			logger.error("Exception at SummaryDAO::performOperation"+e.getStackTrace());
		}
		return summaryList;
	}
}