package edu.jyu.stumgm.action;


import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.jyu.stumgm.bo.CourseBO;
import edu.jyu.stumgm.bo.StuGradeBO;
import edu.jyu.stumgm.entity.Course;

public class CourseListAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CourseBO courseBO;
	private StuGradeBO stuGradeBO;
	
	public StuGradeBO getStuGradeBO() {
		return stuGradeBO;
	}
	public void setStuGradeBO(StuGradeBO stuGradeBO) {
		this.stuGradeBO = stuGradeBO;
	}
	public CourseBO getCourseBO() {
		return courseBO;
	}
	public void setCourseBO(CourseBO courseBO) {
		this.courseBO = courseBO;
	}
	public CourseListAction() {
		super();
	}
	@SuppressWarnings("unchecked")
	public String getList() {
		List<Course> list=courseBO.getCouseList();
		Map<String,Object> request=(Map<String,Object>)ActionContext.getContext().get("request");
		request.put("courseList", list);
		return SUCCESS;
	}
	private String courses;

	
	public String getCourses() {
		return courses;
	}
	public void setCourses(String courses) {
		this.courses = courses;
	}
	public String deleteCourse() {
		System.out.println(courses);
		if (!"".equals(courses) && courses != null){
			String[] data = courses.split("[, ]");
			for(String s: data){
				courseBO.delectCourse(Integer.valueOf(s));
				stuGradeBO.delete(Integer.valueOf(s));
			}
		}
		//courseBO.delectCourse(courseId);
		return SUCCESS;
	}
	private Course course;
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public String updateCourse() {
		System.out.println(course.getId()+course.getName()+course.getCredit());
		courseBO.updateCourse(course);
		return SUCCESS;
	}
	private String courseId;
	
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseById() {
		course=courseBO.getCourseById(Integer.valueOf(courseId));
		return SUCCESS;
	}
}
