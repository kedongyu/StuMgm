package edu.jyu.stumgm.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

import edu.jyu.stumgm.bo.StuAdminBO;
import edu.jyu.stumgm.bo.StuGradeBO;
import edu.jyu.stumgm.bo.StuImgBO;
import edu.jyu.stumgm.bo.StudentBO;
import edu.jyu.stumgm.entity.StuAdmin;
import edu.jyu.stumgm.entity.StuImg;
import edu.jyu.stumgm.entity.Student;

public class StudentAction extends ActionSupport {
	private static final long serialVersionUID = 2019471693629936441L;
	private Logger logger = Logger.getLogger(StudentAction.class);
	
	private String flag;
	private String stuid = "";
	private String stuids = "";
	private StudentBO studentBO;
	private StuAdminBO stuAdminBO;
	private StuGradeBO stuGradeBO;
	private StuImgBO stuImgBO;
	private Student student;
	
	
	public StuGradeBO getStuGradeBO() {
		return stuGradeBO;
	}

	public void setStuGradeBO(StuGradeBO stuGradeBO) {
		this.stuGradeBO = stuGradeBO;
	}

	public StuImgBO getStuImgBO() {
		return stuImgBO;
	}

	public void setStuImgBO(StuImgBO stuImgBO) {
		this.stuImgBO = stuImgBO;
	}

	public Student getStudent() {
		return student;
	}
	
	public StuAdminBO getStuAdminBO() {
		return stuAdminBO;
	}

	public void setStuAdminBO(StuAdminBO stuAdminBO) {
		this.stuAdminBO = stuAdminBO;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public void setStudentBO(StudentBO studentBO){
		this.studentBO = studentBO;
	}
	
	
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	public String getStuid(){
		return stuid;
	}
	

	public void setStuid(String stuid) {
		this.stuid = stuid;
	}

	public String getStuids() {
		return stuids;
	}

	public void setStuids(String stuids) {
		this.stuids = stuids;
	}

	public String add(){
		if(!"update".equals(flag)){
			stuid = studentBO.generateStuNumber();
			return "add";
		}
		System.out.println(student.getIdentityID());
		studentBO.addStudent(student);
		StuAdmin admin=new StuAdmin();
		admin.setStuId(student.getStuNumber());
		admin.setPassword(student.getIdentityID().substring(student.getIdentityID().length()-6, student.getIdentityID().length()));
		stuAdminBO.addAdmin(admin);
		StuImg stuImg=new StuImg();
		stuImg.setStuId(student.getStuNumber());
		stuImg.setImgPath("/stuMgm/html/pic/student.jpg ");
		stuImgBO.add(stuImg);
		return "list";
	}
	
	public String edit(){
		if (!"update".equals(flag)) {
			student = studentBO.getStudentByNumber(stuid);
			logger.info(student.toString());
			return "edit";			
		}
		studentBO.updateStudent(student);
		return "list";
	}
	
	
	public String delete(){
		if (!"".equals(stuids) && stuids != null){
			String[] data = stuids.split("[, ]");
			List<String> numbers = new ArrayList<String>();
			for(String s: data){
				numbers.add(s);
				System.out.println(s);
				stuAdminBO.delectAdmin(s);
				stuImgBO.delete(s);
				stuGradeBO.delete(s);
			}
			studentBO.deleteStudentsByNumber(numbers);
		}
		return "list";
	}

}