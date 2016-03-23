package com.ers.common;

import java.sql.Connection;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.log4j.Logger;

/**
 *DbConnectionManager.java
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

public class DbConnectionManager{
	final static Logger logger = Logger.getLogger(DbConnectionManager.class);	
	private static Connection connection;
	
	
	public static Connection getConnection(){
		logger.debug("Entering:DbConnectionManager.getConnection");
		if(connection == null){
			
			Hashtable<String, String> h = new Hashtable<String, String>(7);
			h.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
			h.put(Context.PROVIDER_URL, "t3://localhost:7001");
			h.put(Context.SECURITY_PRINCIPAL, "weblogic");
			h.put(Context.SECURITY_CREDENTIALS, "weblogic123");
		    try {
		       InitialContext ctx = new InitialContext(h);
		       javax.sql.DataSource datasource = (javax.sql.DataSource) ctx.lookup("jdbc/ersdatasource");
		       connection = datasource.getConnection();
		       
		    } catch (NamingException e) {
		        logger.error("Exception "+e.getStackTrace());
		    } catch (Exception e){
		    	logger.error("Exception "+e.getStackTrace());
		    }	
		}
		logger.debug("Exiting:DbConnectionManager.getConnection");
		return connection;
	}
}