package com.ers.reimbursementForm;

import org.apache.log4j.Logger;

import com.ers.common.ERSValidationException;

/**
 *CertificationReimbursementForm.java
 *
 *Version:1.0
 *Date: 21-Mar-2016
 *Author:Kowsalya Jaganathan
 *
 *This class is to process the certification reimbursement forms and to 
 *start the corresponding workflow.
 *FactoryMethod design pattern is being used
 *
*/

public class CertificationReimbursementForm extends ReimbursementFormFactory{
	final static Logger logger = Logger.getLogger(CertificationReimbursementForm.class);
	String certificationType;
	boolean isPass;
	float score;	
	
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
	public String getCertificationType() {
		return certificationType;
	}
	public void setCertificationType(String certificationType) {
		this.certificationType = certificationType;
	}
	public boolean isPass() {
		return isPass;
	}
	public void setPass(boolean isPass) {
		this.isPass = isPass;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
}