package edu.jyu.stumgm.action;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import edu.jyu.stumgm.Common;
import edu.jyu.stumgm.bo.CourseBO;
import edu.jyu.stumgm.bo.StuAdminBO;
import edu.jyu.stumgm.bo.UserBO;
import edu.jyu.stumgm.entity.StuAdmin;
import edu.jyu.stumgm.entity.User;

public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = -8515183406496049654L;
	private Logger logger = Logger.getLogger(LoginAction.class);
	
	private String userName = "";
	private String password = "";
	private boolean loginError = false;
	private UserBO userBO;
	private CourseBO courseBO;
	private StuAdminBO stuAdminBO;
	
	
	public StuAdminBO getStuAdminBO() {
		return stuAdminBO;
	}

	public void setStuAdminBO(StuAdminBO stuAdminBO) {
		this.stuAdminBO = stuAdminBO;
	}

	public CourseBO getCourseBO() {
		return courseBO;
	}

	public void setCourseBO(CourseBO courseBO) {
		this.courseBO = courseBO;
	}

	public UserBO getUserBO() {
		return userBO;
	}

	public void setUserBO(UserBO userBO) {
		this.userBO = userBO;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isLoginError(){
		return loginError;
	}
	@Override
	public String execute(){
		logger.info("login");
		if(ActionContext.getContext().getSession().get("user") != null){
			return SUCCESS;
		}
		logger.info(userName+","+password);
		if ("".equals(userName) || "".equals(password)) {
			return SUCCESS;
		}
		User user = userBO.login(userName, password);

		logger.info("login: "+user);			
		Map<String,Object> session=ActionContext.getContext().getSession();

		if(user != null){
			session.put("user", user);
			//设置登陆有效时间，30秒不操作，将退出登陆
	        ServletActionContext.getRequest().getSession().setMaxInactiveInterval(60);
	        
			if (user.getRole().equals(Common.ADMIN_ROLE))
			{
				ActionContext.getContext().getSession().put("isAdmin", true);
			}
			
			return SUCCESS;
		}
		else {
			StuAdmin admin=stuAdminBO.getAdmin(userName);
			if(admin!=null&&admin.getPassword()!=null&&admin.getPassword().equals(password)) {
				session.put("admin", admin);
				ServletActionContext.getRequest().getSession().setMaxInactiveInterval(60);
		        
				ActionContext.getContext().getSession().put("isAdmin", true);
				
				System.out.println("login");
				return SUCCESS;
			}
		}
		loginError = true;
		return SUCCESS;
	}

}