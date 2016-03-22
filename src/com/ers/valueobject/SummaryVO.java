package com.ers.valueobject;

import java.util.Date;

/**
 *CreateOrUpdateVO.java
 *
 *Version:1.0
 *Date: 21-Mar-2016
 *Author:Kowsalya Jaganathan
 *
 *This value object has the summary of reimbursement details 
 *
*/

public class SummaryVO{
	int empId;
	int approverEmpId;
	int reimbursementId ;
	String type;
	double amount;
	Date OperationDate;
	String Status ;
	boolean isApprover;
	

	public int getApproverEmpId() {
		return approverEmpId;
	}
	public void setApproverEmpId(int approverEmpId) {
		this.approverEmpId = approverEmpId;
	}
	public boolean isApprover() {
		return isApprover;
	}
	public void setApprover(boolean isApprover) {
		this.isApprover = isApprover;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getReimbursementId() {
		return reimbursementId;
	}
	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getOperationDate() {
		return OperationDate;
	}
	public void setOperationDate(Date operationDate) {
		OperationDate = operationDate;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
	
	
	
	
}