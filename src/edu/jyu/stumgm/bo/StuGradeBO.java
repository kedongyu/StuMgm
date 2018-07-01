package edu.jyu.stumgm.bo;

import java.util.List;

import edu.jyu.stumgm.dao.IStuGradeDAO;
import edu.jyu.stumgm.entity.StuGrade;

public class StuGradeBO {
	private IStuGradeDAO iStuGradeDAO;
	public StuGradeBO() {
		
	}
	
	public IStuGradeDAO getiStuGradeDAO() {
		return iStuGradeDAO;
	}

	public void setiStuGradeDAO(IStuGradeDAO iStuGradeDAO) {
		this.iStuGradeDAO = iStuGradeDAO;
	}

	public void addOne(StuGrade stuGrade) {
		iStuGradeDAO.add(stuGrade);
	}
	public void deleteOne(StuGrade stuGrade) {
		iStuGradeDAO.delete(stuGrade.getStuNum(), stuGrade.getCsId());
	}
	public void delete(int csId) {
		iStuGradeDAO.delete(csId);
	}
	public void delete(String stuId) {
		iStuGradeDAO.delete(stuId);
	}
	public void correct(StuGrade stuGrade) {
		iStuGradeDAO.correct(stuGrade);
	}
	public List<StuGrade> findAll(){
		return iStuGradeDAO.findAll();
	}
	public List<StuGrade> findByCourseId(int csId){
		return iStuGradeDAO.findByCourseId(csId);
	}
	public List<StuGrade> findByStuId(String stuId){
		return iStuGradeDAO.findByStuId(stuId);
	}
	public StuGrade findOne(String stuId,int csId) {
		return iStuGradeDAO.findOne(stuId, csId);
	}
}
