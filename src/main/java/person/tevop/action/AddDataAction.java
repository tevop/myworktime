package person.tevop.action;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;

import person.tevop.model.Content;
import person.tevop.model.User;
import person.tevop.service.UserService;

public class AddDataAction extends ActionSupport {
	private Date date;
	private float cost;
	private String comment;
	private UserService userService;
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		System.out.println("adding");
		User user = userService.getUser("user297");
		System.out.println("user is:" + user);
//		Set<Content> contents = null;
		if (user == null) {
			user = new User();
			user.setName("user299");
			user.setPass("123");
		} 
//		else {
//			user = (User)userService.getHibernateTemplate().load(User.class, user.getId()); 
//			contents = user.getContents();
////			user.setContents(null);
//			userService.getHibernateTemplate().delete(user);
//		}
//		user.setContents(contents);
		// userService.save(user);

		// Set<Content> contents = user.getContents();
		Content content = new Content();
		content.setComment(comment);
		content.setCost(cost);
		content.setDate(new Date());
		user.getContents().add(content);
//		user.setContents(contents);
		userService.save(user);
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

}
