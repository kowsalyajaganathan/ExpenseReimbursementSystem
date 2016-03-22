package com.ers.reimbursementForm;


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
	String activityType;
	

	public boolean formValidation(ReimbursementFormFactory form){
			
			return true;
		}
	public  boolean rulesValidation(ReimbursementFormFactory form){
		boolean isValid = false;
		
		
		return isValid;
	}
	public String getActivityType() {
		return activityType;
	}
	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}
	
}