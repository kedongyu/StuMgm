package edu.jyu.stumgm.dao;


import edu.jyu.stumgm.entity.User;

public interface IUserDAO {
	
	public Boolean exist(String name, String psw);
	public User getByName(String name);
	public void saveOrUpdate(User user);
	public void deleteByName(String name);
}