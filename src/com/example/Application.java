package com.example;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Application {

    public static void main(String[] args) {
    	try {
    		Class.forName("cdata.jdbc.linkedin.LinkedInDriver");
    		    		
    		Connection conn = DriverManager.getConnection("jdbc:linkedin:InitiateOAuth=GETANDREFRESH;OAuthClientId=86y5bghlrs797t;OAuthClientSecret=QrRYa4MkdAlpWvQC;CallbackURL=http://127.0.0.1:33331");
	    	
	    	Statement stat = conn.createStatement();	    		    	

	    	boolean ret = stat.execute("SELECT * FROM Profile");
	    	
	    	// boolean ret = stat.execute("SELECT * FROM Positions");	    	
	    	// boolean ret = stat.execute("SELECT * FROM CompanyStatusUpdates WHERE CompanyId='18421614'");
	    	// boolean ret = stat.execute("SELECT * FROM CompanyList");
	    	// boolean ret = stat.execute("SELECT * FROM CompanyDetails WHERE Id='18421614'");
	    	// boolean ret = stat.execute("UPDATE Positions SET Summary='test summary' WHERE id = '1184880030'");
	    	
	    	ResultSet rs=stat.getResultSet();
	    		    	
	    	while(rs.next()){
	    	  for(int i=1;i<=rs.getMetaData().getColumnCount();i++)
	    	  {
	    	    System.out.println(rs.getMetaData().getColumnName(i) +"="+rs.getString(i));
	    	  }
	    	}
	    	
	    	System.out.println("All available Tables: ");
	    	
	    	DatabaseMetaData table_meta = conn.getMetaData();
	    	ResultSet rst=table_meta.getTables(null, null, "%", null); 
	    	while(rst.next()){
		    	  for(int i=1;i<=rst.getMetaData().getColumnCount();i++)
		    	  {
		    		  	if (rst.getMetaData().getColumnName(i) == "TABLE_NAME") {
		    		  		System.out.println(rst.getMetaData().getColumnName(i) +"="+rst.getString(i));
		    		  	}		    	    
		    	  }
	    	}   	
	    	
			
//	    	String query = "SELECT * FROM CompanyStatusUpdates WHERE VisibilityCode=? and Comment=?";
//	    	PreparedStatement pstmt = conn.prepareStatement(query);
//	    	pstmt.setString(1, "");
//	    	pstmt.setString(2, "");
//	    	boolean ret2 = pstmt.execute();
//	    	if (ret2){
//	    	  ResultSet rs2=pstmt.getResultSet();
//	    	  while(rs2.next()){
//	    	    for(int i=1;i<=rs2.getMetaData().getColumnCount();i++)
//	    	    {
//	    	      System.out.println(rs2.getMetaData().getColumnName(i) +"="+rs2.getString(i));
//	    	    }
//	    	  }
//	    	}    	
	    	
	    	
	    	conn.close();
    	} catch(Exception e) {    	
    		e.printStackTrace();
    	}

    }
}