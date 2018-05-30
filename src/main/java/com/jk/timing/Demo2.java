package com.jk.timing;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.List;

import com.jk.filing.entity.ZFLawCaseInfo;

public class Demo2 {

	static DBOracle db1 = null;
	static ResultSet ret = null;
	
	public static void main(String[] args) {
		
		Filing filing = new Filing();
		
		List<ZFLawCaseInfo> zfLawCaseInfoList = filing.getData();
		
		System.out.println(zfLawCaseInfoList.size());
		
		
//		StringBuffer sql = new StringBuffer();
//		sql.append("SELECT");
//		sql.append("	t.id");
//		sql.append(" ,t.seqnum");
//		sql.append(" ,t.people");
//		sql.append("	,t.regisdate");
//		sql.append(" ,t.setupdate");
//		sql.append(" ,t.endcasedate");
//		sql.append(" ,eventid");
//		sql.append(" FROM");
//		sql.append(" zf_lawcaseinfo t");
//		sql.append("	where");
//		sql.append(" t.tradeid != 1");
//		sql.append(" AND ");
//		sql.append(" t.endcasedate IS NOT NULL");
//		
//		db1 = DBOracle.getDBOracle();// 创建DBHelper对象
//		
//		try {
//			ret = db1.getConnection(sql.toString()).executeQuery();// 执行语句，得到结果集
//			int i = 0;
//			while (ret.next()) {
//				i++;
//				Timestamp regisdate = ret.getTimestamp("endcasedate");
//				
//				DateFormat df1 = DateFormat.getDateTimeInstance();//日期格式，精确到日
//		        System.out.println(regisdate);
//
//			} // 显示数据
//			ret.close();
//			db1.close();// 关闭连接
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		
	}
	
}
