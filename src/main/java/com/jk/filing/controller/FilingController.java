package com.jk.filing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jk.filing.entity.ZFLawCaseInfo;
import com.jk.filing.service.FilingService;

@Controller
@RequestMapping("/filing")
public class FilingController {
	
	@Autowired
	private FilingService filingService;
	
	//Filing页面
	private static final String FILING_URL = "filing/Filing";
	
	/**
	 * @功能 文件归档页面
	 */
	@RequestMapping("/goFiling")
	public String goFiling(Model model) {
		
		List<ZFLawCaseInfo> zfLawCaseInfoList = filingService.getZFLawCaseInfo();
		
		model.addAttribute("zfLawCaseInfoList",zfLawCaseInfoList);
		
		return FILING_URL;
	}
	
	@ResponseBody
	@RequestMapping(value="/getFiling",method=RequestMethod.POST,produces="text/html;charset=UTF-8;")
	public String doFiling() {
		
		String getMaxEndcasedate = filingService.getMaxEndcasedate();
		
		List<ZFLawCaseInfo> zfLawCaseInfoList= filingService.getFiling(getMaxEndcasedate);
		
		if(zfLawCaseInfoList != null && zfLawCaseInfoList.size() > 0) {
			
			int result = filingService.addZFLawCaseInfo(zfLawCaseInfoList);
			
			if(result > 0) { 
				System.out.println("数据成功添加"+result+"数据");
				return "数据成功添加"+result+"数据";
			};
		}
		
		return "没有数据可以拉取";
	}
	
	
	@RequestMapping("/getZFLawCaseInfo")
	public List<ZFLawCaseInfo> getZFLawCaseInfo(){
		
		 List<ZFLawCaseInfo> getZFLawCaseInfo = filingService.getZFLawCaseInfo();
		 
		
		return getZFLawCaseInfo;
	}
}
