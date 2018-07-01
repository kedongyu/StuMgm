package edu.jyu.stumgm.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.jyu.stumgm.bo.StuImgBO;
import edu.jyu.stumgm.bo.StudentBO;
import edu.jyu.stumgm.entity.StuAdmin;
import edu.jyu.stumgm.entity.StuImg;
import edu.jyu.stumgm.entity.Student;

public class AdminAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StudentBO studentBO;
	private StuImgBO stuImgBO;

	public StuImgBO getStuImgBO() {
		return stuImgBO;
	}

	public void setStuImgBO(StuImgBO stuImgBO) {
		this.stuImgBO = stuImgBO;
	}

	public StudentBO getStudentBO() {
		return studentBO;
	}

	public void setStudentBO(StudentBO studentBO) {
		this.studentBO = studentBO;
	}

	private String stuId;
	private Student student;
	private StuImg stuImg;

	public StuImg getStuImg() {
		return stuImg;
	}

	public void setStuImg(StuImg stuImg) {
		this.stuImg = stuImg;
	}

	public String getStuId() {
		return stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getStudentInfo() {
		StuAdmin stuAdmin = (StuAdmin) ActionContext.getContext().getSession().get("admin");
		if (stuAdmin != null) {
			student = studentBO.getStudentByNumber(stuAdmin.getStuId());
			stuImg = stuImgBO.find(stuAdmin.getStuId());
		}
		return SUCCESS;
	}

	public String correctInfo() {
		StuAdmin stuAdmin = (StuAdmin) ActionContext.getContext().getSession().get("admin");
		if (stuAdmin != null) {
			student = studentBO.getStudentByNumber(stuAdmin.getStuId());
			stuImg = stuImgBO.find(stuAdmin.getStuId());
		}
		return SUCCESS;
	}

	public File stufile; 
	private String stufileFileName;// 上传的文件名。上传字段名称+FileName 注意大小写
	private String stufileContentType;// 上传文件的MIME类型。上传字段名称+ContentType 注意大小写

	public String correctImg() {
			// 获取要保存文件夹的物理路径(绝对路径)
			String realPath = ServletActionContext.getServletContext().getRealPath("/upload");
			File file = new File(realPath + "\\" + new Date().getTime());
			System.out.println(realPath + "\\" + new Date().getTime());
			

		if (stufile != null) {
			if (!file.exists())
				file.mkdirs();

			try {
				// 保存文件
				FileUtils.copyFile(stufile, new File(file, stufileFileName));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		StuAdmin stuAdmin = (StuAdmin) ActionContext.getContext().getSession().get("admin");

		if (stuAdmin != null) {
			stuImg = stuImgBO.find(stuAdmin.getStuId());
			String path = file.getAbsolutePath();
			stuImg.setImgPath(path.substring(path.indexOf("stuMgm") - 1) + "\\" + stufileFileName);
			if(stufile!=null)
				stuImgBO.correct(stuImg);
			studentBO.updateStudent(student);
		}
		return SUCCESS;
	}

	public File getStufile() {
		return stufile;
	}

	public void setStufile(File stufile) {
		this.stufile = stufile;
	}

	public String getStufileFileName() {
		return stufileFileName;
	}

	public void setStufileFileName(String stufileFileName) {
		this.stufileFileName = stufileFileName;
	}

	public String getStufileContentType() {
		return stufileContentType;
	}

	public void setStufileContentType(String stufileContentType) {
		this.stufileContentType = stufileContentType;
	}

}
