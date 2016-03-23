package com.ers.reimbursementForm;

import java.util.Date;

import org.apache.log4j.Logger;

import com.ers.common.ERSValidationException;
import com.ers.util.Constants;

/**
 *ReimbursementFormFactory.java
 *
 *Version:1.0
 *Date: 21-Mar-2016
 *Author:Kowsalya Jaganathan
 *
 *This interface serves as a factory to produce different types of reimbursement forms.
 *FactoryMethod design pattern is being used
 *
*/
public  class ReimbursementFormFactory{
	final static Logger logger = Logger.getLogger(ReimbursementFormFactory.class);
	int formId =0;
	String formType ="";
	Date toDate = new Date();
	Date fromDate= new Date();
	float amount =0.0f;
	String description ="";
	int receiptNumber=0;
	String action = "";
	
	ReimbursementFormFactory form = null;
	
	public static ReimbursementFormFactory getReimbursementForm(String type){
		ReimbursementFormFactory form = null;
		
		if(Constants.FORM_CERTIFICATION.equals(type)){
			form = new CertificationReimbursementForm();
		}else if(Constants.FORM_TRAINING.equals(type)){
			form = new TrainingReimbursementForm();
		}else if(Constants.FORM_TEAMEVENT.equals(type)){
			form = new TeamEventReimbursementForm();
		}else if(Constants.FORM_TRAVEL.equals(type)){
			form = new TravelReimbursementForm();
		}
		return form;
	}
	public  boolean formValidation(ReimbursementFormFactory form){
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
	public int getFormId() {
		return formId;
	}
	public void setFormId(int formId) {
		this.formId = formId;
	}
	public String getFormType() {
		return formType;
	}
	public void setFormType(String formType) {
		this.formType = formType;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getReceiptNumber() {
		return receiptNumber;
	}
	public void setReceiptNumber(int receiptNumber) {
		this.receiptNumber = receiptNumber;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	
	
}