package com.ers.reimbursementForm;


/**
 *TravelReimbursementForm.java
 *
 *Version:1.0
 *Date: 21-Mar-2016
 *Author:Kowsalya Jaganathan
 *
 *This class is to process the travel event forms and to 
 *start the corresponding workflow.
 *FactoryMethod design pattern is being used
 *
*/

public class TravelReimbursementForm extends ReimbursementFormFactory{
	String fromCountry;
	String fromCity;
	String toCountry;
	String toCity;
	
    public boolean formValidation(ReimbursementFormFactory form){
		
		return true;
	}
    public  boolean rulesValidation(ReimbursementFormFactory form){
		boolean isValid = false;
		
		
		return isValid;
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