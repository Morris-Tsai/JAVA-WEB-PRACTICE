//Import required packages
import java.sql.*;

public class FirstExample {
	//JDBC driver name and database URL
	static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
	static final String DB_URL="jdbc:mysql://localhost:3306/demo?useSSL=false&serverTimezone=CST";
	
    //Database credentials
	static final String USER="root";
	static final String PASS="10219873";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn =null;
		Statement stmt=null;
		try {
			//STEP2:Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			//STEP3:Open a connection
			System.out.println("Connection to database....");
			conn=DriverManager.getConnection(DB_URL,USER,PASS);
			//STEP4:Execute a query
			System.out.println("Creating statement...");
			stmt=conn.createStatement();
			String sql;
			sql="SELECT * FROM users";
			ResultSet rs =stmt.executeQuery(sql);
			//STEP5:Extract data from result set
			while(rs.next()) {
				//Retrieve by  column name
				int id =rs.getInt("id");
				String name =rs.getString("name");
				String email =rs.getString("email");
				String country =rs.getString("country");
				//Display values
				System.out.print("id:"+id);
				System.out.print("name:"+name);
				System.out.print("email:"+email);
				System.out.println("country:"+country);
			}
			//STEP6:Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException se) {
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e) {
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally {
			//finally block used to close resources
			try {
				if(stmt!=null)
				  stmt.close();	
			}catch(SQLException se2) {
				}//nothing we can do
			try {
				if(conn!=null)
				  conn.close();	
			}catch(SQLException se) {
				se.printStackTrace();
				}//end finally try
		}//end try
        System.out.println("Goodbye!");
	}//end main

}//end FirstExample
