package person.tevop.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import person.tevop.model.Content;
import person.tevop.model.User;
import person.tevop.service.UserService;

public class LoginAction extends MyAction{

	private String name;
	private String pass;
	private UserService userService;
//	private String errorMessage;
//	private List<User> users = new ArrayList<User>();
	private List<Content> contents = new ArrayList<Content>();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		List<User> list = (List<User>)userService.getHibernateTemplate().find("from User u where u.name=?", name);
		if (list == null || list.size() == 0) {
			setErrorMessage("没有这个用户");
			return "fail";
		}
		if (!checkPass(list.get(0).getPass())) {
			setErrorMessage("密码错误");
			return "fail";
		}
		prepareRecords(list);
		ActionContext.getContext().getSession().put("userName", name);
		return "success";
	}
	
	private boolean checkPass(String realPass) {
		if (!pass.equals(realPass)) {
			return false;
		}
		return true;
	}

	private void prepareRecords(List<User> list) {

		Set<Content> all = null;
		for (User user: list) {
			all = user.getContents();
			for(Content one : all) {
				if (isSameDay(one.getDate(), one.getComment())) {
					contents.add(one);
				}
			}
		}
	}
	
	private boolean isSameDay(Date date, String comment) {
		Date today = new Date();
	    Calendar calDateA = Calendar.getInstance();  
	    calDateA.setTime(date);  
	  
	    Calendar calDateB = Calendar.getInstance();  
	    calDateB.setTime(today);  
		System.out.println("today is: " + calDateB.get(Calendar.YEAR) + ","
				+ calDateB.get(Calendar.MONTH) +", " + calDateB  
                .get(Calendar.DAY_OF_MONTH));
		System.out.println("day is: " + calDateA.get(Calendar.YEAR) + ","
				+ calDateA.get(Calendar.MONTH) +", " + calDateA  
                .get(Calendar.DAY_OF_MONTH) + ", comment is: " + comment);
	  
	    return calDateA.get(Calendar.YEAR) == calDateB.get(Calendar.YEAR)  
	            && calDateA.get(Calendar.MONTH) == calDateB.get(Calendar.MONTH)  
	            && calDateA.get(Calendar.DAY_OF_MONTH) == calDateB  
	                    .get(Calendar.DAY_OF_MONTH);  
	} 

	@Override
	public void validate() {
		System.out.println("name is: " + name);
		List<User> list = (List<User>)userService.getHibernateTemplate().find("from User u where u.name=?", name);
		if (list == null || list.size() == 0) {
			String errorMessage = "没有这个用户";
			setErrorMessage(errorMessage);
			addFieldError("errorMessage", errorMessage);
		}
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

//	public String getErrorMessage() {
//		return errorMessage;
//	}
//
//	public void setErrorMessage(String errorMessage) {
//		this.errorMessage = errorMessage;
//	}



	public List<Content> getContents() {
		return contents;
	}



	public void setContents(List<Content> contents) {
		this.contents = contents;
	}
	
	
}
