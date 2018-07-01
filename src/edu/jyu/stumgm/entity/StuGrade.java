package edu.jyu.stumgm.entity;

import java.io.Serializable;


public class StuGrade implements Serializable{
    private static final long serialVersionUID = 1L;
	private String stuNum;
	private int csId;
	private short grade;
	public StuGrade() {
		
	}
	
	public StuGrade(String stuNum, int csId, short grade) {
		super();
		this.stuNum = stuNum;
		this.csId = csId;
		this.grade = grade;
	}

	public String getStuNum() {
		return stuNum;
	}
	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}
	public int getCsId() {
		return csId;
	}
	public void setCsId(int csId) {
		this.csId = csId;
	}
	public short getGrade() {
		return grade;
	}
	public void setGrade(short grade) {
		this.grade = grade;
	}
	
	
	
}
