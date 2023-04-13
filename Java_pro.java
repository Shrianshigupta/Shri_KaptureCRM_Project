
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

public class Java_pro 
{
    public static void main(String[] args) 
    {
    	try {
    		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        	System.out.println("Comma");
        	String connstr="jdbc:sqlserver://SHRIGUPTA-PC\\SQLEXPRESS;"+"databaseName=CallRecords; integratedSecurity=true";
        	Connection conn=DriverManager.getConnection(connstr);
        	Statement stmt=conn.createStatement();
        	String query ="select * from calls";
        	ResultSet rs=stmt.executeQuery(query);
        	while(rs.next()) {
        		System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
        		
        	}
        	String q2="SELECT Start_time,End_time, DATEDIFF(minute, Start_time, End_time) AS difference FROM calls";
        	ResultSet rs2=stmt.executeQuery(q2);
        	while(rs2.next()) {
        		System.out.println(rs2.getString(1)+" "+rs2.getString(2)+" "+rs2.getString(3));
        		
        	}
        	String q3="select DATEPART(HOUR, Start_time),DATEPART(HOUR, End_time),DATEDIFF(minute, Start_time, End_time) AS difference AS hours from calls";
        	ResultSet rs3=stmt.executeQuery(q3);
        	while(rs3.next()) {
        		System.out.println(rs3.getString(1)+" "+rs2.getString(2)+" "+rs2.getString(3));
        		
        	}
        	
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
}