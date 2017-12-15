package person.tevop.action;

import com.opensymphony.xwork2.ActionSupport;

public abstract class MyAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorMessage;
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
