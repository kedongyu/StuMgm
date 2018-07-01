package edu.jyu.stumgm.dao;

import java.io.Serializable;
import java.util.List;

import edu.jyu.stumgm.entity.Course;

public interface ICourseDAO {
	
	public void saveOrUpdate(Course obj) ;
	
	public void save(Course obj);

	public Course get(Serializable id) ;
	
	public void update(Course obj) ;

	public void delete(Course obj);

	
	public void deleteByCourseId(int courseId);
	 
	public List<Course> findAll();
	
	public void deleteByCourseId(List<Integer> numbers);
	
	public Course findByCourseId(int courseId);
	
	public void deleteAll();
}
