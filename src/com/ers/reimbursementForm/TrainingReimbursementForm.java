package com.ers.reimbursementForm;


/**
 *TrainingReimbursementForm.java
 *
 *Version:1.0
 *Date: 21-Mar-2016
 *Author:Kowsalya Jaganathan
 *
 *This class is to process the training team event forms and to 
 *start the corresponding workflow.
 *FactoryMethod design pattern is being used
 *
*/

public class TrainingReimbursementForm extends ReimbursementFormFactory{
	String trainingType;
	
	
	public boolean formValidation(ReimbursementFormFactory form){
		
		return true;
	}
	public  boolean rulesValidation(ReimbursementFormFactory form){
		boolean isValid = false;
		
		
		return isValid;
	}
	public String getTrainingType() {
		return trainingType;
	}
	public void setTrainingType(String trainingType) {
		this.trainingType = trainingType;
	}
	
}