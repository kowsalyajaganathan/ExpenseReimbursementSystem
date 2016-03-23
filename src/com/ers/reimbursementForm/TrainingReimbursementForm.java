package com.ers.reimbursementForm;

import org.apache.log4j.Logger;

import com.ers.common.ERSValidationException;

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
	final static Logger logger = Logger.getLogger(TrainingReimbursementForm.class);
	String trainingType;
	
	
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
	public String getTrainingType() {
		return trainingType;
	}
	public void setTrainingType(String trainingType) {
		this.trainingType = trainingType;
	}
	
}