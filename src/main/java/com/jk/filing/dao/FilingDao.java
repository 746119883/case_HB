package com.jk.filing.dao;

import java.util.List;

import com.jk.filing.entity.ZFLawCaseInfo;

public interface FilingDao {

	/**
	 * 多条数据添加到本地数据库
	 */
	public int addZFLawCaseInfo(List<ZFLawCaseInfo> zfLawCaseInfoList);
	
	/**
	 * 获取本地数据库结案时间的最大时间
	 */
	public String getMAXEndcasedate();
	
	/**
	 * 获取本地数据库的所有数据
	 */ 
	public List<ZFLawCaseInfo> getZFLawCaseInfo();
	
}
