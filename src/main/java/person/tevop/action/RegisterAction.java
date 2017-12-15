package person.tevop.action;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;

import person.tevop.model.User;
import person.tevop.service.UserService;

public class RegisterAction extends MyAction{

	private String name;
	private String pass;
	private String repass;
	private UserService userSrevice;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
//		if (!pass.equals(repass)) {
//			return "passNotSame";
//		}
		User user = new User();
		user.setName(name);
		user.setPass(pass);
		if (userSrevice.save(user))
		{
			return "registerSuccess";
		}
		setErrorMessage("注册用户失败");
		return "ail";
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

	public String getRepass() {
		return repass;
	}

	public void setRepass(String repass) {
		this.repass = repass;
	}

	public UserService getUserSrevice() {
		return userSrevice;
	}

	@Resource
	public void setUserSrevice(UserService userSrevice) {
		this.userSrevice = userSrevice;
	}

	@Override
	public void validate() {
		if (!pass.equals(repass)) {
			addFieldError("errorMessage", "密码必须相同");
			return; 
		}
		if (userSrevice.exists(name)) {
			addFieldError("errorMessage", "此用户已经存在");
			return; 
		}
	}
}
