package com.jk.timing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class DBOracle {
	
	private DBOracle() {};
	
	private static final DBOracle DBORACLE = new DBOracle();
	
    private static Connection conn;
	public static PreparedStatement pst;
    
    public static DBOracle getDBOracle() {
    	
    	return DBORACLE;
    }
    
    public PreparedStatement getConnection(String sql) {  //建立返回值为Connection的方法    
        try {        //加载数据库驱动类    
            Class.forName("oracle.jdbc.driver.OracleDriver");    
            System.out.println("数据库驱动加载成功");  //返回加载驱动成功信息    
        }catch(ClassNotFoundException e){    
            e.printStackTrace();    
        }    
        try {    
        	conn=DriverManager.getConnection("jdbc:oracle:" + "thin:@192.68.74.106:1521:orcl","zfb","zfb");//通过访问数据库的URL获取数据库连接对象 ，这里后两个参数分别是数据库的用户名及密码   
            System.out.println("数据库连接成功");  //返回连接成功信息  
            pst = conn.prepareStatement(sql);// 准备执行语句
        }catch(SQLException e) {    
            e.printStackTrace();    
        }    
        return pst;//按方法要求返回一个Connection对象    
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
