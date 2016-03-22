package com.ers.workflow;

import com.ers.workflow.CRUDActionFactory;
import com.ers.dal.dao.ApproverDAO;
import com.ers.dal.dao.OperationDAOFactory;
import com.ers.valueobject.ApproveOrRejectVO;
import com.ers.valueobject.EmployeeVO;
import com.ers.reimbursementForm.ReimbursementFormFactory;


/**
 *ApproverAction.java
 *
 *Version:1.0
 *Date: 21-Mar-2016
 *Author:Kowsalya Jaganathan
 *
 *This class is to perform different types of approver 
 *actions like approval and rejection 
 *FactoryMethod design pattern is being used
 *
*/

public class ApproverAction implements CRUDActionFactory{
	ReimbursementFormFactory reimbursementForm = null;
	OperationDAOFactory operationDAOFactory = null;
	WorkflowCloneManager workflow = new WorkflowCloneManager();
	ApproveOrRejectVO approveOrRejectVO = new ApproveOrRejectVO();
	String actionType;
	
	public WorkflowCloneManager createWorkflowObject(String actionType,WorkflowCloneManager workflow) throws CloneNotSupportedException{
		WorkflowCloneManager Approveworkflow= workflow.createWorkflow(actionType,workflow);
		this.actionType = actionType;
		return Approveworkflow;
	}
	
	public boolean startWorkflow(WorkflowCloneManager Approveworkflow,ReimbursementFormFactory form,EmployeeVO emp){
		boolean isSuccess = false;
		boolean isWorkFlowSuccess = false;
		reimbursementForm = form;
		isWorkFlowSuccess = Approveworkflow.startWorkflow(form);
		if(!isWorkFlowSuccess){
			isSuccess = false;
		}else{
			approveOrRejectVO.setReimbursementId(form.getFormId());
			approveOrRejectVO.setStatusToBeSet(this.actionType);
			operationDAOFactory = getOperationDAO(approveOrRejectVO);
			isSuccess = operationDAOFactory.performOperation();
		}
		
		return isSuccess;
	}
	public OperationDAOFactory getOperationDAO(ApproveOrRejectVO approveOrRejectVO ){
		operationDAOFactory = new ApproverDAO(approveOrRejectVO);
		return operationDAOFactory;
	}
	
	
}
