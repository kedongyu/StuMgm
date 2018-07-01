package edu.jyu.stumgm.action;

import com.opensymphony.xwork2.ActionSupport;

import edu.jyu.stumgm.bo.CourseBO;
import edu.jyu.stumgm.entity.Course;

public class AddCourseAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CourseBO courseBO;
	public AddCourseAction() {
		super();
	}
	public CourseBO getCourseBO() {
		return courseBO;
	}

	public void setCourseBO(CourseBO courseBO) {
		this.courseBO = courseBO;
	}
	
	private Course course;
	
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public String addCourse() {
		courseBO.addCourse(course);
		return SUCCESS;
	}
	
}
