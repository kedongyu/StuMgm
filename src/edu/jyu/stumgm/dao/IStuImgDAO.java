package edu.jyu.stumgm.dao;

import edu.jyu.stumgm.entity.StuImg;

public interface IStuImgDAO {
	public void add(StuImg stuImg);
	public void correct(StuImg stuImg);
	public void delete(String stuId);
	public StuImg find(String stuId);
}
