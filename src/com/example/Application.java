package main.java.com.example;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

//import org.springframework.boot.SpringApplication;



public class Application {

    public static void main(String[] args) {
    	try {
    		Class.forName("cdata.jdbc.linkedin.LinkedInDriver");
    		
    		Connection conn = DriverManager.getConnection("jdbc:linkedin:InitiateOAuth=GETANDREFRESH;OAuthClientId=77r1kse4yc6g5t;OAuthClientSecret=mxawm85iLbTNMbVa;CallbackURL=http://127.0.0.1:33335");
    		//Connection conn = DriverManager.getConnection("jdbc:linkedin:InitiateOAuth=GETANDREFRESH;OAuthClientId=86y5bghlrs797t;OAuthClientSecret=QrRYa4MkdAlpWvQC;CallbackURL=http://127.0.0.1:33333;CompanyId=Softgreat");
	    	
	    	Statement stat = conn.createStatement();
	    	
	    	// boolean ret = stat.execute("UPDATE Positions SET Summary='test summary' WHERE id = '1184880030'");
	    	// boolean ret = stat.execute("SELECT * FROM Positions");
	    	boolean ret = stat.execute("SELECT * FROM Profile");
	    	
	    	// boolean ret = stat.execute("SELECT * FROM CompanyStatusUpdates WHERE CompanyId='18421614'");	    	
	    	
	    	// boolean ret = stat.execute("SELECT * FROM CompanyList");
	    	
	    	// boolean ret = stat.execute("SELECT * FROM CompanyDetails WHERE Id='18421614'");
	    	

	    	
	    	ResultSet rs=stat.getResultSet();
	    		    	
	    	while(rs.next()){
	    	  for(int i=1;i<=rs.getMetaData().getColumnCount();i++)
	    	  {
	    	    System.out.println(rs.getMetaData().getColumnName(i) +"="+rs.getString(i));
	    	  }
	    	}
	    	
	    	/*DatabaseMetaData table_meta = conn.getMetaData();
	    	ResultSet rst=table_meta.getTables(null, null, "%", null); 
	    	while(rst.next()){
		    	  for(int i=1;i<=rst.getMetaData().getColumnCount();i++)
		    	  {
		    		  	if (rst.getMetaData().getColumnName(i) == "TABLE_NAME") {
		    		  		System.out.println(rst.getMetaData().getColumnName(i) +"="+rst.getString(i));
		    		  	}		    	    
		    	  }
	    	}    	  	
	    	    	*/
	    	
			
	    	/*String query = "SELECT * FROM Profile"; //Equivalent to "SELECT * FROM CompanyStatusUpdates WHERE VisibilityCode='XXX' and Comment='YYY'"
	    	PreparedStatement pstmt = conn.prepareStatement(query);
	    	//pstmt.setString(1, "XXX");
	    	//pstmt.setString(2, "YYY");
	    	boolean ret = pstmt.execute();
	    	if (ret){
	    	  ResultSet rs=pstmt.getResultSet();
	    	  while(rs.next()){
	    	    for(int i=1;i<=rs.getMetaData().getColumnCount();i++)
	    	    {
	    	      System.out.println(rs.getMetaData().getColumnName(i) +"="+rs.getString(i));
	    	    }
	    	  }
	    	}*/
	    	
	    	/*Statement stat = conn.prepareStatement("SELECT * FROM People");
			boolean ret = stat.execute("SELECT * FROM People");
			ResultSet rs=stat.getResultSet();
			while(rs.next()){
			for(int i=1;i<=rs.getMetaData().getColumnCount();i++)
			{
			System.out.println(rs.getMetaData().getColumnName(i) +"="+rs.getString(i));
			}
			}*/
    	} catch(Exception e) {    	
    		e.printStackTrace();
    	}	
    	
    	System.out.println("Hello");

    }
}