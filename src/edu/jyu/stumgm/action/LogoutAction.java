package edu.jyu.stumgm.action;

import java.util.Map;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;





public class LogoutAction extends ActionSupport {
	
	private Logger logger = Logger.getLogger(LogoutAction.class);

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}
	
	public String execute(){
	
		logger.info("logout");
		Map sessionMap=ActionContext.getContext().getSession();
		if(!sessionMap.isEmpty()){
			sessionMap.clear();
		}
		return SUCCESS;
	}
}