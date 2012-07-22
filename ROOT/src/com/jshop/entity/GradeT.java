package com.jshop.entity;

// Generated 2012-7-22 13:51:26 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * GradeT generated by hbm2java
 */
public class GradeT implements java.io.Serializable {

	private String gradeid;
	private String gradevalue;
	private String gradename;
	private double needcost;
	private double discount;
	private Date createtime;
	private String creatorid;

	public GradeT() {
	}

	public GradeT(String gradeid, String gradename, double needcost,
			double discount, Date createtime, String creatorid) {
		this.gradeid = gradeid;
		this.gradename = gradename;
		this.needcost = needcost;
		this.discount = discount;
		this.createtime = createtime;
		this.creatorid = creatorid;
	}

	public GradeT(String gradeid, String gradevalue, String gradename,
			double needcost, double discount, Date createtime, String creatorid) {
		this.gradeid = gradeid;
		this.gradevalue = gradevalue;
		this.gradename = gradename;
		this.needcost = needcost;
		this.discount = discount;
		this.createtime = createtime;
		this.creatorid = creatorid;
	}

	public String getGradeid() {
		return this.gradeid;
	}

	public void setGradeid(String gradeid) {
		this.gradeid = gradeid;
	}

	public String getGradevalue() {
		return this.gradevalue;
	}

	public void setGradevalue(String gradevalue) {
		this.gradevalue = gradevalue;
	}

	public String getGradename() {
		return this.gradename;
	}

	public void setGradename(String gradename) {
		this.gradename = gradename;
	}

	public double getNeedcost() {
		return this.needcost;
	}

	public void setNeedcost(double needcost) {
		this.needcost = needcost;
	}

	public double getDiscount() {
		return this.discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getCreatorid() {
		return this.creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}

}
