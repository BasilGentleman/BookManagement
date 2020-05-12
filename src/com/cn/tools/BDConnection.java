package com.cn.tools;
import java.sql.*;
/**
 * jdbc连接封装类
 * @author mac
 *
 */
public class BDConnection {
	
private static	String driverName = null;
private static	String url = null;
private static	String username = null;
private static	String password = null;
private static  Statement stmt = null;
private static	ResultSet rs = null;
private static  Connection con =null;
	
	


public static Connection getConnection(){
	try {
		driverName="com.mysql.cj.jdbc.Driver";
		Class.forName(driverName);
		url="jdbc:mysql://localhost:3306/Book?serverTimezone=UTC&useSSL=false&useUnicode=true&characterEncoding=UTF-8";
		username = "root";
	    password = "12345678";
//	    password = "root";
		con = DriverManager.getConnection(url, username, password);
		
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
			}finally {
				return con;
			}
	}

public static void close(){
	try {
		if(rs != null){
			rs.close();
		}
		if(stmt != null){
			stmt.close();
		}
		if(con != null){
			con.close();
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}


}
