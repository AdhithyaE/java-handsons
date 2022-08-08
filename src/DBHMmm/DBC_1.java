package DBHMmm;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.lang.ClassNotFoundException;
public class DBC_1 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		//load the driver
		//ResourceBundle rb = ResourceBundle.getBundle("db");
		//if suppose the class name is found in a string in "", then how to create object of that class?
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/db1";
		String uid="root";
		String pwd="1234";							//"";
	//	Driver driver=new com.mysql.jdbc.Driver();
		//get connection
		//oracle url
		//jdbc:oracle:thin:@localhost:1521:XE
		Connection con = DriverManager.getConnection(url,uid,pwd);
		//create Statement		(statement is an object representation of sql statement)
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM EMPLOYEE");
		System.out.format("%-20s\t%-20s\t%-20s\t%-20s\n", "Employee Id", "First Name","Last Name","Department id");
		while(rs.next())
		{
			System.out.format("%-20s\t%-20s\t%-20s\t%-20s\n", rs.getInt(1), rs.getString(2),rs.getString(3),rs.getInt(4));
		}
	}

}
