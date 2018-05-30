package com.jk.filing.service;

import java.util.List;

import com.jk.filing.entity.ZFLawCaseInfo;

public interface FilingService {
	
	/**
	 * 获取本地数据库结案时间的最大时间
	 */
	public String getMaxEndcasedate();
	
	/**
	 * 获取服务器数据库的数据
	 */
	public List<ZFLawCaseInfo> getFiling(String getMaxEndcasedate);
	
	/**
	 * 获取服务器数据库的文件
	 */
	public String getFile(String id);
	
	/**
	 * 多条数据添加到本地数据库
	 */
	public int addZFLawCaseInfo(List<ZFLawCaseInfo> zfLawCaseInfoList);
	
	/**
	 * 获取本地数据库的所有数据
	 */
	public List<ZFLawCaseInfo> getZFLawCaseInfo();
	
	

}
