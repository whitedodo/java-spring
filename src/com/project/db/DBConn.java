package com.project.db;

import java.sql.Connection;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class DBConn {

    public final static int ORACLE = 1;
    public final static int MYSQL = 2;
    public final static int MSSQL = 3;
    

	private String JDBC_DRIVER_NAME;
	private String DATABASE_URL;
	private String DATABASE_USER;
	private String DATABASE_PASSWORD;

	private static BasicDataSource ds;
    
    public DBConn(int DBMS) {
    	
    	switch ( DBMS ) {
    	
	    	case ORACLE:
	    		JDBC_DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	    	    DATABASE_URL = "jdbc:oracle:thin:@127.0.0.1:1521:ORCL";
	    	    DATABASE_USER = "c##rabbit";
	    	    DATABASE_PASSWORD = "1234";
	    	    
	    	    break;
	    	    
	    	case MYSQL:
	    		JDBC_DRIVER_NAME = "org.gjt.mm.mysql.Driver";
	    		DATABASE_URL = "jdbc:mysql://localhost:3306/whitedodo?" + 
										  "useUnicode=true&characterEncoding=utf-8&" + 
										  "verifyServerCertificate=false&useSSL=true";
	    		DATABASE_USER = "root";
	    		DATABASE_PASSWORD = "1234";
	    				
	    		break;
	    		
	    	case MSSQL:
	    		break;
	    		
	    	default:
	    		break;
    	
    	}
    }
    
    public Connection getConnection() {
    	
    	try {
			ds = new BasicDataSource();
			ds.setDriverClassName(this.JDBC_DRIVER_NAME);
			ds.setUsername(this.DATABASE_USER);
			ds.setPassword(this.DATABASE_PASSWORD);
			ds.setUrl(this.DATABASE_URL);
			
			ds.setMinIdle(5);
			ds.setMaxIdle(20);
			ds.setMaxOpenPreparedStatements(180);
			
			//Class.forName(Driver);
			//Connection conn = DriverManager.getConnection(DBURL, DBUser, DBPwd);
			
			return ds.getConnection();
		}
		catch(Exception e)
		{
			System.out.println (e.getMessage() );
			return null;
		}
    	
    }
    
}
