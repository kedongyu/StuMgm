package edu.jyu.stumgm.action;

import java.util.List;




import com.opensymphony.xwork2.ActionSupport;

import edu.jyu.stumgm.bo.GradeBO;
import edu.jyu.stumgm.entity.Grade;


public class GradeAdminAction extends ActionSupport {

	private GradeBO gradeBO;
	private List<Grade> gradelist;

	
	public GradeBO getGradeBO() {
		return gradeBO;
	}

	public void setGradeBO(GradeBO gradeBO) {
		this.gradeBO = gradeBO;
	}

	public List<Grade> getGradelist() {
		return gradelist;
	}

	public void setGradelist(List<Grade> gradelist) {
		this.gradelist = gradelist;
	}
	
	public String execute()
	{
		gradelist = gradeBO.getAllGrade();
		return SUCCESS;
	}
}