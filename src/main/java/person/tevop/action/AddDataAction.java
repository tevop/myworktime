package person.tevop.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import person.tevop.model.Content;
import person.tevop.model.User;
import person.tevop.service.UserService;

public class AddDataAction extends ActionSupport {
	private String userName;
	private Date date;
	private float cost;
	private String comment;
	private UserService userService;
	
	private List<User> users = new ArrayList<User>();
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		System.out.println("adding¡£¡£¡£comment is: " + comment);
		System.out.println("userName is: " + userName);
		User user = userService.getUser(userName);
		System.out.println("user is:" + user);
		if (user == null) {
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
		setUsers(all);
		return "success";
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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
