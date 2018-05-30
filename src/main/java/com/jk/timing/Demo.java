package com.jk.timing;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo {
	static String sql = null;
	static DBMySQL db1 = null;
	static ResultSet ret = null;

	public static void main(String[] args) {
		sql = "select *from customer";// SQL语句
		db1 = DBMySQL.getDBMySQL();// 创建DBHelper对象

		try {
			ret = db1.getConnection(sql).executeQuery();// 执行语句，得到结果集
			while (ret.next()) {
				String uid = ret.getString(2);
				
				System.out.println(uid);
			} // 显示数据
			ret.close();
			db1.close();// 关闭连接
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
