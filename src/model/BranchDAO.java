package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class BranchDAO {

	private Connection getConn() throws ClassNotFoundException, SQLException {
		ResourceBundle rb = ResourceBundle.getBundle("db");
		Class.forName(rb.getString("driver"));
		Connection con = DriverManager.getConnection(rb.getString("url"),rb.getString("username"),rb.getString("password"));
		return con;
	}
	
	public void create(Branch branch) throws ClassNotFoundException, SQLException
	{
		Connection con = getConn();
		PreparedStatement st = con.prepareStatement("INSERT INTO Branch VALUES(?,?,?)");
		st.setString(1, branch.getBid());
		st.setString(2, branch.getBname());
		st.setString(3, branch.getBcity());
		int no=st.executeUpdate();
		System.out.println(no+" row(s) inserted");
	}

	
	
	public Branch read(String bid) throws ClassNotFoundException, SQLException
	{
		Connection con=getConn();
		PreparedStatement st = con.prepareStatement("SELECT * FROM Branch WHERE bid=?");
		st.setString(1, bid);
		ResultSet rs = st.executeQuery();
		//when i search a record based on primary key, i may get 0 or 1 record
		Branch branch=null;
		if(rs.next())
		{
			branch=new Branch(rs.getString(1), rs.getString(2), rs.getString(3));
		}
		return branch;
	}
	
	public List<Branch> read() throws ClassNotFoundException, SQLException
	{
		List<Branch> branchList=new ArrayList<Branch>();
		Connection con=getConn();
		PreparedStatement st = con.prepareStatement("SELECT * FROM Branch");
		ResultSet rs = st.executeQuery();
		while(rs.next())
		{
			Branch branch=new Branch(rs.getString(1), rs.getString(2), rs.getString(3));
			branchList.add(branch);
		}
		return branchList;
	}
	
	public void update(Branch branch) throws ClassNotFoundException, SQLException
	{
		Connection con = getConn();
		PreparedStatement st = con.prepareStatement("UPDATE Branch SET bname=?, bcity=? WHERE bid=?");
		st.setString(1, branch.getBname());
		st.setString(2, branch.getBcity());
		st.setString(3, branch.getBid());
		int no=st.executeUpdate();
		System.out.println(no+" row(s) updated");
}
	
	public void delete(String bid) throws ClassNotFoundException, SQLException
	{
		Connection con=getConn();
		PreparedStatement st = con.prepareStatement("DELETE FROM Branch WHERE bid=?");
		st.setString(1, bid);
		int no=st.executeUpdate();
		System.out.println(no+" row(s) deleted");
	}
	
}
