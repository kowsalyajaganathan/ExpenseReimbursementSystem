package com.ers.valueobject;

import java.util.Date;

/**
 *CreateOrUpdateVO.java
 *
 *Version:1.0
 *Date: 21-Mar-2016
 *Author:Kowsalya Jaganathan
 *
 *This value object has reimbursement details to perform create update delete operations in the database
 *
*/

public class ReimbursementVO{
	int submitterId;
	int approverId;
	
	
	int reimbursementId ;
	String reimbursementType;
	float amount;
	Date toDate;
	Date fromDate;
	int receiptNum;
	String Status ;
	String certificationType;
	boolean isPass;
	float score;
	String activityType;
	String trainingType;
	String fromCountry;
	String fromCity;
	String toCountry;
	String toCity;
	Date modifiedDate;
	
	
	public int getSubmitterId() {
		return submitterId;
	}
	public void setSubmitterId(int submitterId) {
		this.submitterId = submitterId;
	}
	public int getApproverId() {
		return approverId;
	}
	public void setApproverId(int approverId) {
		this.approverId = approverId;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public int getReimbursementId() {
		return reimbursementId;
	}
	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}
	public String getReimbursementType() {
		return reimbursementType;
	}
	public void setReimbursementType(String type) {
		this.reimbursementType = type;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
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
	public int getReceiptNum() {
		return receiptNum;
	}
	public void setReceiptNum(int receiptNum) {
		this.receiptNum = receiptNum;
	}
	/*public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}*/
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
	public void setScore(float score) {
		this.score = score;
	}
	public String getActivityType() {
		return activityType;
	}
	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}
	public String getTrainingType() {
		return trainingType;
	}
	public void setTrainingType(String trainingType) {
		this.trainingType = trainingType;
	}
	public String getFromCountry() {
		return fromCountry;
	}
	public void setFromCountry(String fromCountry) {
		this.fromCountry = fromCountry;
	}
	public String getFromCity() {
		return fromCity;
	}
	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}
	public String getToCountry() {
		return toCountry;
	}
	public void setToCountry(String toCountry) {
		this.toCountry = toCountry;
	}
	public String getToCity() {
		return toCity;
	}
	public void setToCity(String toCity) {
		this.toCity = toCity;
	}
	
	
	
	
	
}