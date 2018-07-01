package edu.jyu.stumgm.bo;

import java.util.List;

import edu.jyu.stumgm.dao.ICourseDAO;
import edu.jyu.stumgm.entity.Course;

public class CourseBO {
	private ICourseDAO courseDAO;

	public CourseBO() {
		
	}
	public ICourseDAO getCourseDAO() {
		return courseDAO;
	}

	public void setCourseDAO(ICourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}
	
	public void addCourse(Course course) {
		courseDAO.save(course);
	}
	public void delectCourse(int id) {
		courseDAO.deleteByCourseId(id);
	}
	public void updateCourse(Course course) {
		courseDAO.update(course);
	}
	public List<Course> getCouseList(){
		return courseDAO.findAll();
	}
	public Course getCourseById(int id) {
		return courseDAO.findByCourseId(id);
	}
	 
}
