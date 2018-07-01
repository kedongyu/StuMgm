package edu.jyu.stumgm.bo;

import edu.jyu.stumgm.dao.StuImgDAO;
import edu.jyu.stumgm.entity.StuImg;

public class StuImgBO {
	private StuImgDAO stuImgDAO;

	public StuImgDAO getStuImgDAO() {
		return stuImgDAO;
	}

	public void setStuImgDAO(StuImgDAO stuImgDAO) {
		this.stuImgDAO = stuImgDAO;
	}
	public StuImgBO() {
		
	}

	public StuImgBO(StuImgDAO stuImgDAO) {
		super();
		this.stuImgDAO = stuImgDAO;
	}
	public void add(StuImg stuImg) {
		stuImgDAO.add(stuImg);
	}
	public void correct(StuImg stuImg) {
		stuImgDAO.correct(stuImg);
	}
	public void delete(String stuId) {
		stuImgDAO.delete(stuId);
	}
	public StuImg find(String stuId) {
		return stuImgDAO.find(stuId);
	}
}
