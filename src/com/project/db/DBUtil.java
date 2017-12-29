package com.project.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	
	public static void close(ResultSet rs) {
		
		if ( rs != null )
		{
			try {
				rs.close();
			}
			catch(SQLException ex) {}
			
		} // end of if
		
	}
	
	public static void close(Statement stmt) {
		
		if ( stmt != null ) {
			
			try {
				stmt.close();
			}
			catch(SQLException ex) {}
			
		} // end of if
		
	}
	
	public static void close(PreparedStatement pstmt) {
		
		if ( pstmt != null )
		{
			try {
				pstmt.close();
			}
			catch(SQLException ex) {}
		
		} // end of if
		
	}
	
	public static void close(Connection conn) {
		
		if ( conn != null ) {
			
			try {
				conn.close();
			}
			catch(SQLException ex) {}
			
		} // end of if
		
	}
	
	public static void rollback(Connection conn) {
		
		if ( conn != null )
		{
			try {
				conn.rollback();
			}
			catch(SQLException ex) {}
			
		} // end of if
		
	}
	
}
