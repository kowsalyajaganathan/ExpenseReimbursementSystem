package com.ers.reimbursementForm;


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
	String certificationType;
	boolean isPass;
	double score;	
	
	public boolean formValidation(ReimbursementFormFactory form){
		
		return true;
	}
	public  boolean rulesValidation(ReimbursementFormFactory form){
		boolean isValid = false;
		
		
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
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
}