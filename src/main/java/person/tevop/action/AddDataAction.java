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

public class AddDataAction extends MyAction {
//	private String userName;
	private Date date;
	private float cost;
	private String comment;
	private UserService userService;

	private List<Content> contents = new ArrayList<Content>();
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		String userName = (String)ActionContext.getContext()
				.getSession().get("userName");
		System.out.println("adding。。。comment is: " + comment);
		System.out.println("userName is: " + userName);
		User user = userService.getUser(userName);
		System.out.println("user is:" + user);
		if (user == null) {
			setErrorMessage("没有找到此用户：" + userName);
			return "fail";
		}
		System.out.println("user's name is: " +user.getName());
		Content content = new Content();
		content.setComment(comment);
		content.setCost(cost);
		content.setUser(user); 
		content.setDate(new Date());
		user.getContents().add(content);
//		user.setContents(contents);
		userService.save(content);
		List<User> all = (List<User>)userService.getHibernateTemplate().find("from User u where u.name=?", user.getName());
		prepareRecords(all);
		return "success";
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	

	@Override
	public void validate() {
		// TODO Auto-generated method stub
		super.validate();
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<Content> getContents() {
		return contents;
	}

	public void setContents(List<Content> contents) {
		this.contents = contents;
	}
	
	

}
