package com.ers.workflow;

import com.ers.valueobject.EmployeeVO;
import com.ers.reimbursementForm.ReimbursementFormFactory;

/**
 *CURDActionFactory.java
 *
 *Version:1.0
 *Date: 21-Mar-2016
 *Author:Kowsalya Jaganathan
 *
 *This interface is to produce different types of action categories 
 *FactoryMethod design pattern is being used
 *
*/

public interface CRUDActionFactory{
	WorkflowCloneManager workflow = new WorkflowCloneManager();
	
	public boolean createWorkflowObject(String actionType,ReimbursementFormFactory form,EmployeeVO e);
		
}