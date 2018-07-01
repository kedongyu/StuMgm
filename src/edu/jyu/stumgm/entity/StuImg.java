package edu.jyu.stumgm.entity;

public class StuImg {
	private int id;
	private String stuId;
	private String imgPath;
	public StuImg() {
		
	}
	
	public StuImg(int id, String stuId, String imgPath) {
		super();
		this.id = id;
		this.stuId = stuId;
		this.imgPath = imgPath;
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
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
}
