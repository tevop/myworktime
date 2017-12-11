package person.tevop.action;

import com.opensymphony.xwork2.ActionSupport;

import person.tevop.model.User;
import person.tevop.service.UserService;

public class LoginAction extends ActionSupport{

	private String name;
	private String pass;
	private UserService userService;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
//		User user = new User();
//		user.setName(name);
//		if (userService.exists(user)) {
//			return "loginSuccess";
//		}
//		return "loginFail";
		System.out.println("logging");
		return "loginSuccess";
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
	
	

}
