package com.spring.henallux.modelAttribute;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class PasswordChangeForm {

	@NotEmpty
	@Size(min=8)
	private String oldPassword;
	
	@NotEmpty
	@Size(min=8)
	private String newPassword;
	
	@NotEmpty
	@Size(min=8)
	private String retypeNewPassword;
	
	
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getRetypeNewPassword() {
		return retypeNewPassword;
	}
	public void setRetypeNewPassword(String retypeNewPassword) {
		this.retypeNewPassword = retypeNewPassword;
	}
	
}
