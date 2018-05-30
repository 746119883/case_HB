package com.jk.timing;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import com.jk.filing.entity.ZFLawCaseInfo;

public class Filing {
	DBOracle db1 = null;
	ResultSet ret = null;

	public List<ZFLawCaseInfo> getData() {

		List<ZFLawCaseInfo> zfLawCaseInfoList = new ArrayList<ZFLawCaseInfo>();

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT");
		sql.append("	t.id");
		sql.append(" ,t.seqnum");
		sql.append(" ,t.people");
		sql.append("	,t.regisdate");
		sql.append(" ,t.setupdate");
		sql.append(" ,t.endcasedate");
		sql.append(" ,eventid");
		sql.append(" FROM");
		sql.append(" zf_lawcaseinfo t");
		sql.append("	where");
		sql.append(" t.tradeid != 1");
		sql.append(" AND ");
		sql.append(" t.endcasedate IS NOT NULL");

		db1 = DBOracle.getDBOracle();// 创建DBHelper对象
		try {
			ret = db1.getConnection(sql.toString()).executeQuery();// 执行语句，得到结果集
			int i = 0;
			while (ret.next()) {
				ZFLawCaseInfo zfLawCaseInfo = new ZFLawCaseInfo();

				zfLawCaseInfo.setId(ret.getInt("id"));
				zfLawCaseInfo.setSeqnum(ret.getLong("seqnum"));
				zfLawCaseInfo.setPeople(ret.getString("people"));
				zfLawCaseInfo.setRegisdate(ret.getTimestamp("regisdate"));
				zfLawCaseInfo.setSetupdate(ret.getTimestamp("setupdate"));
				zfLawCaseInfo.setEndcasedate(ret.getTimestamp("endcasedate"));
				zfLawCaseInfo.setEventid(ret.getInt("eventid"));

				zfLawCaseInfoList.add(zfLawCaseInfo);

			}
			ret.close();
			db1.close();// 关闭连接
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return zfLawCaseInfoList;

	}
}
