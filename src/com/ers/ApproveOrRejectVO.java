package com.ers.valueobject;

/**
 *CreateOrUpdateVO.java
 *
 *Version:1.0
 *Date: 21-Mar-2016
 *Author:Kowsalya Jaganathan
 *
 *This value object has reimbursement details to be created or updated in the database
 *
*/

public class ApproveOrRejectVO{
	int reimbursementId ;
	String statusToBeSet;
	
	public String getStatusToBeSet() {
		return statusToBeSet;
	}
	public void setStatusToBeSet(String statusToBeSet) {
		this.statusToBeSet = statusToBeSet;
	}
	public int getReimbursementId() {
		return reimbursementId;
	}
	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}
	
	
	
	
}