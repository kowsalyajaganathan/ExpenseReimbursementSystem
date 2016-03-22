package com.ers.reimbursementForm;

import java.util.Date;

import com.ers.util.Constants;
import com.ers.workflow.WorkflowCloneManager;

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
	int formId =0;
	String formType ="";
	Date toDate = new Date();
	Date fromDate= new Date();
	double amount =0.0f;
	String description ="";
	int receiptNumber=0;
	String action = "";
	
	ReimbursementFormFactory form = null;
	WorkflowCloneManager workflowFactory = null;
	
	public ReimbursementFormFactory getReimbursementForm(String type){
		if(type.equals(Constants.FORM_CERTIFICATION)){
			form = new CertificationReimbursementForm();
		}else if(type.equals(Constants.FORM_TRAINING)){
			form = new TrainingReimbursementForm();
		}else if(type.equals(Constants.FORM_TEAMEVENT)){
			form = new TeamEventReimbursementForm();
		}else if(type.equals(Constants.FORM_TRAVEL)){
			form = new TravelReimbursementForm();
		}
		return form;
	}
	public  boolean formValidation(ReimbursementFormFactory form){
		boolean isValid = false;
		
		
		return isValid;
	}
	
	public  boolean rulesValidation(ReimbursementFormFactory form){
		boolean isValid = false;
		
		
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
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
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