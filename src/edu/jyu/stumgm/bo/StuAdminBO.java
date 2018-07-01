package edu.jyu.stumgm.bo;

import edu.jyu.stumgm.dao.StuAdminDAO;
import edu.jyu.stumgm.entity.StuAdmin;

public class StuAdminBO {
	private StuAdminDAO stuAdminDAO;

	public StuAdminDAO getStuAdminDAO() {
		return stuAdminDAO;
	}

	public void setStuAdminDAO(StuAdminDAO stuAdminDAO) {
		this.stuAdminDAO = stuAdminDAO;
	}
	public StuAdminBO() {
		
	}
	public void addAdmin(StuAdmin admin) {
		stuAdminDAO.addStuAdmin(admin);
	}
	public void correctAdmin(StuAdmin admin) {
		stuAdminDAO.correctPassword(admin);
	}
	public StuAdmin getAdmin(String stuId) {
		return stuAdminDAO.getStuAdmin(stuId);
	}
	public void delectAdmin(String stuId) {
		stuAdminDAO.delectAdmin(stuId);
	}
}
