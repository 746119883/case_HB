package com.jk.timing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBMySQL {

	private DBMySQL() {
	};

	private static final DBMySQL DBMRSQL = new DBMySQL();
	private static Connection conn;
	public static PreparedStatement pst;

	public PreparedStatement getConnection(String sql) {
		try {

			String url = "jdbc:mysql://127.0.0.1/test";
			String name = "com.mysql.jdbc.Driver";
			String user = "root";
			String password = "123456";

			Class.forName(name);// 指定连接类型
			conn = DriverManager.getConnection(url, user, password);// 获取连接
			pst = conn.prepareStatement(sql);// 准备执行语句

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return pst;

	}

	public static DBMySQL getDBMySQL() {

		return DBMRSQL;
	}

	public void close() {
		try {
			conn.close();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
