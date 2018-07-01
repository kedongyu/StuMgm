package edu.jyu.stumgm.entity;

public class StuAdmin {
	private int id;
	private String stuId;
	private String password;
	public StuAdmin() {
		
	}
	public StuAdmin(int id, String stuId, String password) {
		super();
		this.id = id;
		this.stuId = stuId;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
