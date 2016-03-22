package com.ers.common;

import java.sql.Connection;

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
private static Connection connection;
	
	public static Connection getConnection(){
		if(connection == null){
			//connection 
			/*Context initContext = new InitialContext();
DataSource ds = (DataSource)initContext.lookup("myDB");
jndiConnection = ds.getConnection();
*/
			
			//or this one
			
			
			/* Hashtable<String, String> h = new Hashtable<String, String>(7);
h.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
h.put(Context.PROVIDER_URL, "t3://localhost:7001");//add ur url
h.put(Context.SECURITY_PRINCIPAL, "weblogic");//add username
h.put(Context.SECURITY_CREDENTIALS, "welcome1");//add password

    Bundle bundle;
    try {
        InitialContext ctx = new InitialContext(h);
       DataSource dataSource = ((DataSource) ctx.lookup("jdbc/ContextBindingDS"));
        bundle = (Bundle) ctx.lookup(BUNDLE_JNDI_NAME);


    } catch (NamingException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }catch (Exception e){
        e.printStackTrace();
    }*/
			
		}
		return connection;
	}
}