package com.ers.workflow;

import com.ers.workflow.CRUDActionFactory;

import org.apache.log4j.Logger;

import com.ers.dal.dao.CreateDAO;
import com.ers.dal.dao.DeleteDAO;
import com.ers.dal.dao.OperationDAOFactory;
import com.ers.dal.dao.UpdateDAO;
import com.ers.reimbursementForm.CertificationReimbursementForm;
import com.ers.reimbursementForm.ReimbursementFormFactory;
import com.ers.reimbursementForm.TeamEventReimbursementForm;
import com.ers.reimbursementForm.TrainingReimbursementForm;
import com.ers.reimbursementForm.TravelReimbursementForm;
import com.ers.util.Constants;
import com.ers.valueobject.ReimbursementVO;
import com.ers.valueobject.EmployeeVO;


/**
 *SubmitterAction.java
 *
 *Version:1.0
 *Date: 21-Mar-2016
 *Author:Kowsalya Jaganathan
 *
 *
 *This class is to perform different types of employee actions like creation,deletion and
 * updation
 *FactoryMethod design pattern is being used
 *
 *
*/

public class SubmitterAction implements CRUDActionFactory{
	final static Logger logger = Logger.getLogger(SubmitterAction.class);
	OperationDAOFactory operationDAOFactory = null;
	ReimbursementVO createOrUpdateVO = new ReimbursementVO();
	String actionType;
	
	public boolean createWorkflowObject(String actionType,ReimbursementFormFactory form,EmployeeVO empVO) {
		boolean isWorkflowSuccess = false;
		try{
			this.actionType = actionType;
			
			if(actionType.equals(Constants.ACTION_DELETE)){
				ReimbursementVO deleteVO = new ReimbursementVO();
				deleteVO.setSubmitterId(empVO.getEmpId());
				deleteVO.setReimbursementId(form.getFormId());
				operationDAOFactory = getOperationDAO(deleteVO);
				isWorkflowSuccess = operationDAOFactory.performOperation();
			}else{
				WorkflowCloneManager employeeworkflow= workflow.createWorkflow(actionType,workflow);
				isWorkflowSuccess = startWorkflow(employeeworkflow,form,empVO);
			}
		}catch(CloneNotSupportedException ce){
			logger.error("Exception"+ce.getStackTrace());
		}
		return isWorkflowSuccess;
	}
	
	public boolean startWorkflow(WorkflowCloneManager employeeworkflow,ReimbursementFormFactory form,EmployeeVO emp){
		boolean isSuccess = false;
		boolean isWorkFlowSuccess = false;
		try{
			isWorkFlowSuccess = employeeworkflow.startWorkflow(form);
			if(!isWorkFlowSuccess){
				isSuccess = false;
			}else{
				setValueObject(form,emp);
				operationDAOFactory = getOperationDAO(createOrUpdateVO);
				isSuccess = operationDAOFactory.performOperation();
			}
		}catch(Exception e){
			logger.error("Exception"+e.getStackTrace());
		}
		
		return isSuccess;
	}
	public OperationDAOFactory getOperationDAO(ReimbursementVO createOrUpdateVO ){
		if(this.actionType.equals(Constants.ACTION_CREATE)){
		    operationDAOFactory = new CreateDAO(createOrUpdateVO);
		}else if(this.actionType.equals(Constants.ACTION_UPDATE)){
			operationDAOFactory = new UpdateDAO(createOrUpdateVO);
		}else if(this.actionType.equals(Constants.ACTION_DELETE)){
			operationDAOFactory = new DeleteDAO(createOrUpdateVO);
		}
		return operationDAOFactory;
	}
	
	public void setValueObject(ReimbursementFormFactory form,EmployeeVO empVo){
		try{
			this.createOrUpdateVO.setSubmitterId(empVo.getEmpId());
			this.createOrUpdateVO.setReimbursementId(form.getFormId());
			this.createOrUpdateVO.setReimbursementType(form.getFormType());
			this.createOrUpdateVO.setAmount(form.getAmount());
			this.createOrUpdateVO.setFromDate(form.getFromDate());
			this.createOrUpdateVO.setReceiptNum(form.getReceiptNumber());
			this.createOrUpdateVO.setToDate(form.getToDate());
	
			
			if(form.getFormType().equals(Constants.FORM_CERTIFICATION)){
				CertificationReimbursementForm certForm = (CertificationReimbursementForm)form;
				this.createOrUpdateVO.setCertificationType(certForm.getCertificationType());
				this.createOrUpdateVO.setPass(certForm.isPass());		
				this.createOrUpdateVO.setScore(certForm.getScore());
				
			}else if(this.actionType.equals(Constants.FORM_TEAMEVENT)){
				TeamEventReimbursementForm teamEventForm = (TeamEventReimbursementForm)form;			
				this.createOrUpdateVO.setActivityType(teamEventForm.getActivityType());			
				
			}else if(this.actionType.equals(Constants.FORM_TRAINING)){
				TrainingReimbursementForm trainingForm = (TrainingReimbursementForm)form;	
				this.createOrUpdateVO.setTrainingType(trainingForm.getTrainingType());
				
			}else if(this.actionType.equals(Constants.FORM_TRAVEL)){
				TravelReimbursementForm travelForm = (TravelReimbursementForm)form;	
				
				this.createOrUpdateVO.setFromCity(travelForm.getFromCity());
				this.createOrUpdateVO.setFromCountry(travelForm.getFromCountry());
				this.createOrUpdateVO.setToCity(travelForm.getToCity());
				this.createOrUpdateVO.setToCountry(travelForm.getToCountry());
			}
		}catch(Exception e){
			logger.error("Exception"+e.getStackTrace());
		}
	}
	
}