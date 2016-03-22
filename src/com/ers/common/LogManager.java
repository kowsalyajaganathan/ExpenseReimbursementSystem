package com.ers.common;

import org.apache.log4j.Logger;

import com.ers.workflow.SummaryAction;

/**
 *LogManager.java
 *
 *Version:1.0
 *Date: 21-Mar-2016
 *Author:Kowsalya Jaganathan
 *
 *This class is manage application's logging mechanism
 * 
 *Singleton design pattern is being used
 *
*/

public class LogManager{
	private static LogManager instance;
	private static Logger logger;
	
	public static Logger getInstance(Class c){
		if(logger == null){
		//instance = new LogManager();
			logger = Logger.getLogger(c);
		}
		return logger;
	}
	
	
}