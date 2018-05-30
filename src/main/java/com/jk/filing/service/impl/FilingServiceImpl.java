package com.jk.filing.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk.filing.dao.FilingDao;
import com.jk.filing.entity.ZFLawCaseInfo;
import com.jk.filing.service.FilingService;
import com.jk.timing.DBOracle;

@Service("filingService")
public class FilingServiceImpl implements FilingService {
	
	@Autowired
	private FilingDao filingdao;
	
	@Override
	public String getMaxEndcasedate() {
		
		return filingdao.getMAXEndcasedate();
	}
	
	@Override
	public List<ZFLawCaseInfo> getFiling(String getMaxEndcasedate) {
		
		try {

			if(getMaxEndcasedate !=null && !"".equals(getMaxEndcasedate)) {
			
			Date d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(getMaxEndcasedate);
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			getMaxEndcasedate = sdf.format(d);
				
			}
			
		} catch (ParseException e1) {
			
			e1.printStackTrace();
		}
		
		DBOracle db1 = null;
		ResultSet ret = null;

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
		sql.append(" AND");
		sql.append(" t.endcasedate IS NOT NULL");
		
		if(getMaxEndcasedate !=null && !"".equals(getMaxEndcasedate)) {
			
			sql.append(" AND");
			sql.append(" t.endcasedate");
			sql.append(" >");
			sql.append(" to_date");
			sql.append("(");
			sql.append("'"+getMaxEndcasedate+"'");
			sql.append(","); 
			sql.append("'yyyy-mm-dd hh24:mi:ss'");
			sql.append(")");
		}

		db1 = DBOracle.getDBOracle();// 创建DBHelper对象
		try {
			ret = db1.getConnection(sql.toString()).executeQuery();// 执行语句，得到结果集
			int sid = 0;
			while (ret.next()) {
				ZFLawCaseInfo zfLawCaseInfo = new ZFLawCaseInfo();
				
				zfLawCaseInfo.setSid(sid++);
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
	
	@Override
	public int addZFLawCaseInfo(List<ZFLawCaseInfo> zfLawCaseInfoList) {
		
		int result = filingdao.addZFLawCaseInfo(zfLawCaseInfoList);
		if(result > 0) {
			return result;
		}
		
		return 0;
	}

	@Override
	public List<ZFLawCaseInfo> getZFLawCaseInfo() {
		
		List<ZFLawCaseInfo> zfLawCaseInfoList = filingdao.getZFLawCaseInfo();
	
		int sid = 0;
		
		for(int i = 0;i < zfLawCaseInfoList.size();i++) {
			
			zfLawCaseInfoList.get(i).setSid(++sid);
			
		}
		
		return zfLawCaseInfoList;
	}

	@Override
	public String getFile(String id) {
		
		
		
		
		
		return null;
	}

	
}
