package com.mypack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class MyDao {

	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
		return con;
	}

	public String saveUser(Registration reg) throws Exception {
		Connection con = getConnection();
		String query = "insert into registration(fullname, mobile_num, email, gender) values(?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, reg.getFullName());
		pst.setString(2, reg.getMobileNumber());
		pst.setString(3, reg.getEmail());
		pst.setString(4, reg.getGender());
		
		int result = pst.executeUpdate();
		
		return result > 0 ? "success" : "fail";

	}
	
	public List<Registration> getAllUsers() throws Exception {
		List<Registration> list = new ArrayList<Registration>();
		Connection con = getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from registration");
		while(rs.next()) {
			Registration reg = new Registration();
			reg.setId(rs.getInt(1));
			reg.setFullName(rs.getString(2));
			reg.setMobileNumber(rs.getString(3));
			reg.setEmail(rs.getString(4));
			reg.setGender(rs.getString(5));
			list.add(reg);
		}
		return list;
	}
}
