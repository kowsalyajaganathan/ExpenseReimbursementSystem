package com.ers.reimbursementForm;

import org.apache.log4j.Logger;

import com.ers.workflow.ApproverAction;

/**
 *TeamEventReimbursementForm.java
 *
 *Version:1.0
 *Date: 21-Mar-2016
 *Author:Kowsalya Jaganathan
 *
 *This class is to process the certification team event forms and to 
 *start the corresponding workflow.
 *FactoryMethod design pattern is being used
 *
*/

public class TeamEventReimbursementForm extends ReimbursementFormFactory{
	final static Logger logger = Logger.getLogger(TeamEventReimbursementForm.class);
	String activityType;
	

	public boolean formValidation(ReimbursementFormFactory form){
		try{
			//The business  logic needs to be implemented. can throw ERSValidationException for specific scenarios
				throw new ERSValidationException("Validation Exception for Rule 1");
		}catch(ERSValidationException e){
			logger.debug("ERSValidationException"+e);
		}catch(Exception e){
			logger.debug("Exception"+e);
		}
		return true;
		}
	public  boolean rulesValidation(ReimbursementFormFactory form){
		boolean isValid = false;
		try{
			//The business  logic needs to be implemented. can throw ERSValidationException for specific scenarios
				throw new ERSValidationException("Validation Exception for Rule 1");
		}catch(ERSValidationException e){
			logger.debug("ERSValidationException"+e);
		}catch(Exception e){
			logger.debug("Exception"+e);
		}	
		return isValid;
	}
	public String getActivityType() {
		return activityType;
	}
	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}
	
}