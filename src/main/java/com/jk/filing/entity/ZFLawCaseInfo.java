package com.jk.filing.entity;

import java.sql.Timestamp;

public class ZFLawCaseInfo {

	private Integer sid;//序号
	
	private Integer id;// ID

	private Long seqnum;// 案件序号

	private String people;// 当事人

	private Timestamp regisdate;// 登记时间

	private Timestamp setupdate;// 立案时间

	private Timestamp endcasedate;// 结案时间

	private Integer eventid;// 案件类型

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getSeqnum() {
		return seqnum;
	}

	public void setSeqnum(Long seqnum) {
		this.seqnum = seqnum;
	}

	public String getPeople() {
		return people;
	}

	public void setPeople(String people) {
		this.people = people;
	}

	public Timestamp getRegisdate() {
		return regisdate;
	}

	public void setRegisdate(Timestamp regisdate) {
		this.regisdate = regisdate;
	}

	public Timestamp getSetupdate() {
		return setupdate;
	}

	public void setSetupdate(Timestamp setupdate) {
		this.setupdate = setupdate;
	}

	public Timestamp getEndcasedate() {
		return endcasedate;
	}

	public void setEndcasedate(Timestamp endcasedate) {
		this.endcasedate = endcasedate;
	}

	public Integer getEventid() {
		return eventid;
	}

	public void setEventid(Integer eventid) {
		this.eventid = eventid;
	}

}
