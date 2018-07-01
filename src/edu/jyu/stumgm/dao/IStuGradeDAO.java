package edu.jyu.stumgm.dao;

import java.util.List;

import edu.jyu.stumgm.entity.StuGrade;

public interface IStuGradeDAO {
	public void add(StuGrade stuGrade);
	public void delete(int csId);
	public void delete(String stuId);
	public void delete(String stuId,int csId);
	public void correct(StuGrade stuGrade);
	public List<StuGrade> findAll();
	public List<StuGrade> findByStuId(String stuId);
	public List<StuGrade> findByCourseId(int csId);
	public StuGrade findOne(String stuId,int csId);
}
