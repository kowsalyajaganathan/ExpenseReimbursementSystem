package com.ers.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *Util.java
 *
 *Version:1.0
 *Date: 21-Mar-2016
 *Author:Kowsalya Jaganathan
 *
 *This utility class has functions to help the application functionality
 * 
*/

public class Util{
	
	public java.sql.Date convertDate(java.util.Date date){
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		return sqlDate;
	}
	
	
	public String dateFormat(java.util.Date date){
		DateFormat df = new SimpleDateFormat("dd/MM/YYYY");
		String formattedDate = df.format(date);
		return formattedDate;
	}
	
}