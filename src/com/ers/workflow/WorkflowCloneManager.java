package com.ers.workflow;

import com.ers.reimbursementForm.ReimbursementFormFactory;
import com.ers.util.Constants;

/**
 *WorkflowCloneManager.java
 *
 *Version:1.0
 *Date: 21-Mar-2016
 *Author:Kowsalya Jaganathan
 *
 *This class serves as a manager to get a shallow copy of workflow object to 
 *cater to different types of reimbursement workflows.
 *prototype design pattern is being used.
 *
*/
public class WorkflowCloneManager{
    String  workflowType; 
   
	public WorkflowCloneManager createWorkflow(String type,WorkflowCloneManager workflow) throws CloneNotSupportedException{
		workflow = (WorkflowCloneManager)workflow.clone();
		workflow.workflowType =type;
		return workflow;
	}
	
	/*public WorkflowCloneManager initialize(String type,WorkflowCloneManager workflow){
		workflow = (WorkflowCloneManager)workflow.clone();
		this.WorkflowCloneManager(type,workflow);
		return workflow;
	}*/
	
	public boolean startWorkflow(ReimbursementFormFactory form){
		boolean isFieldValidationSuccess = false;
		boolean isRulesValidationSuccess = false;
		boolean isValid = false;
		if(workflowType.equals(Constants.ACTION_CREATE) || workflowType.equals(Constants.ACTION_UPDATE)){
			isFieldValidationSuccess = form.rulesValidation(form);
			if(isFieldValidationSuccess){
				isValid = true;
			}
		}else if(workflowType.equals(Constants.ACTION_APPROVE)){
			isRulesValidationSuccess = form.rulesValidation(form);
			if(isRulesValidationSuccess){
				isValid = true;
			}
		}
		
	    return isValid;
	}

}