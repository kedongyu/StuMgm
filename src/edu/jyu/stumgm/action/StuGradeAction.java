package edu.jyu.stumgm.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.jyu.stumgm.bo.CourseBO;
import edu.jyu.stumgm.bo.StuGradeBO;
import edu.jyu.stumgm.bo.StuImgBO;
import edu.jyu.stumgm.bo.StudentBO;
import edu.jyu.stumgm.entity.Course;
import edu.jyu.stumgm.entity.StuAdmin;
import edu.jyu.stumgm.entity.StuGrade;
import edu.jyu.stumgm.entity.StuImg;
import edu.jyu.stumgm.entity.Student;

public class StuGradeAction extends ActionSupport {
	private StuGradeBO stuGradeBO;
	private StudentBO studentBO;
	private CourseBO courseBO;
	private StuImgBO stuImgBO;
	public StuGradeAction() {

	}

	public CourseBO getCourseBO() {
		return courseBO;
	}

	public void setCourseBO(CourseBO courseBO) {
		this.courseBO = courseBO;
	}

	public StuGradeBO getStuGradeBO() {
		return stuGradeBO;
	}

	public void setStuGradeBO(StuGradeBO stuGradeBO) {
		this.stuGradeBO = stuGradeBO;
	}

	public StudentBO getStudentBO() {
		return studentBO;
	}

	public void setStudentBO(StudentBO studentBO) {
		this.studentBO = studentBO;
	}

	private int courseId;
	private List<Student> stuList;

	public String getCourseList() {
		List<StuGrade> stuGrades = stuGradeBO.findByCourseId(courseId);
		List<Student> list = new ArrayList<Student>();
		if (stuGrades != null) {
			for (StuGrade stuGrade : stuGrades) {
				list.add(studentBO.getStudentByNumber(stuGrade.getStuNum()));
			}
			stuList = list;
		}
		return SUCCESS;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public List<Student> getStuList() {
		return stuList;
	}

	public void setStuList(List<Student> stuList) {
		this.stuList = stuList;
	}

	private List<Course> csList;
	public String selectCourses() {
		csList=courseBO.getCouseList();
		return SUCCESS;
	}

	public List<Course> getCsList() {
		return csList;
	}

	public void setCsList(List<Course> csList) {
		this.csList = csList;
	}


	public String studyCourse() {
		StuAdmin admin=(StuAdmin)ActionContext.getContext().getSession().get("admin");
		StuGrade stuGrade=new StuGrade();
		stuGrade.setCsId(courseId);
		stuGrade.setStuNum(admin.getStuId());
		stuGrade.setGrade((short)-1);
		stuGradeBO.addOne(stuGrade);
		System.out.println(stuGrade.getCsId()+stuGrade.getGrade()+stuGrade.getStuNum());
		return SUCCESS;
	}
	public String myCourse() {
		StuAdmin admin=(StuAdmin)ActionContext.getContext().getSession().get("admin");
		List<StuGrade> list=stuGradeBO.findByStuId(admin.getStuId());
		csList=new ArrayList<>();
		if(list!=null) {
			for(StuGrade stuGrade:list) {
				Course course=courseBO.getCourseById(stuGrade.getCsId());
				if(course!=null) {
					course.setId(stuGrade.getGrade());
					csList.add(course);
				}
			}
		}
		return SUCCESS;
	}
	private String stuId;
	private int csId;
	private Student student;
	private StuImg stuImg;
	private StuGrade stuGrade;
	public String getStudentInfo() {
		student = studentBO.getStudentByNumber(stuId);
		stuImg = stuImgBO.find(stuId);		
		stuGrade=stuGradeBO.findOne(stuId, csId);
		return SUCCESS;
	}

	public StuImgBO getStuImgBO() {
		return stuImgBO;
	}

	public void setStuImgBO(StuImgBO stuImgBO) {
		this.stuImgBO = stuImgBO;
	}

	public String getStuId() {
		return stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	public int getCsId() {
		return csId;
	}

	public void setCsId(int csId) {
		this.csId = csId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public StuImg getStuImg() {
		return stuImg;
	}

	public void setStuImg(StuImg stuImg) {
		this.stuImg = stuImg;
	}

	public StuGrade getStuGrade() {
		return stuGrade;
	}

	public void setStuGrade(StuGrade stuGrade) {
		this.stuGrade = stuGrade;
	}
	public String saveStuGrade() {
		System.out.println(stuGrade.getCsId()+" "+stuGrade.getGrade()+" "+stuGrade.getStuNum());
		stuGradeBO.correct(stuGrade);
		return SUCCESS;
	}
	public String findCsGrade() {
		List<StuGrade> list=stuGradeBO.findByCourseId(csId);
		stuList=new ArrayList<>();
		if(list!=null) {
			for(StuGrade sG:list) {
				Student student=studentBO.getStudentByNumber(sG.getStuNum());
				student.setPostID(String.valueOf(sG.getGrade()));
				stuList.add(student);
			}
		}
		return SUCCESS;
	}
}
