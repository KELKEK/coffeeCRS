package com.shinhan.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil {
	public static Connection dbConnection() {
		Context initContext;
		Connection conn = null;
		try {
			initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection(); //Connection pooling(서버 시작시 미리 Connection을 만들어두고 관리)에서 Connection 1개 얻기
			//
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
	
	
	//DB연결
	public static Connection dbConnection2() {
		//DB연결
		//1, JDBC Driver load
		//2, Connection 생성
		//ip => 192.168.0.XX(ipconfig), localhost, 127.0.0.1 <- 다 같음
		String url = "jdbc:oracle:thin:@localhost:1521:xe";//Data Source Explorer -> Database Connection -> New Oracle -> 마우스 우클릭 ->properties
		String userid = "hr";
		String password = "hr";
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, userid, password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}
	
	//DB해체
	public static void dbDisconnect(Connection conn, Statement st, ResultSet rs) {
		// TODO Auto-generated method stub
		try {
			//닫는 순서도 있음
			if(rs!=null) rs.close();
			if(st!=null) st.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
