package com.ers.common;

/**
 *ERSValidationException.java
 *
 *Version:1.0
 *Date: 21-Mar-2016
 *Author:Kowsalya Jaganathan
 *
 *This class is create a custom Exception for the reimbursement form validation
 * 
 *Singleton design pattern is being used
 *
*/

public class ERSValidationException extends Exception{
	
	public ERSValidationException(String message){
		super(message);
	}
	public ERSValidationException(Throwable t){
		super(t);
	}	
	public ERSValidationException(String message,Throwable t){
		super(message,t);
	}
	
	
	

}