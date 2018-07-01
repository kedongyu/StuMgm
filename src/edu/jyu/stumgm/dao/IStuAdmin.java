package edu.jyu.stumgm.dao;

import edu.jyu.stumgm.entity.StuAdmin;

public interface IStuAdmin {
	public void addStuAdmin(StuAdmin admin);
	public void correctPassword(StuAdmin admin);
	public StuAdmin getStuAdmin(String  stuId);
	public void delectAdmin(String stuId);
}
