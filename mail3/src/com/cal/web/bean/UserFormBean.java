package com.cal.web.bean;

import java.util.HashMap;
import java.util.Map;

public class UserFormBean {
	private String email;
	private String title;
	private String essay;
	private Map<String, String> errors = new HashMap<String, String>();
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getEssay() {
		return essay;
	}
	public void setEssay(String essay) {
		this.essay = essay;
	}
	public Map<String, String> getErrors() {
		return errors;
	}
//	public void setErrors(Map<String, String> errors) {
//		this.errors = errors;
//	}
	public boolean vaildate(){
		if(email==null || "".equals(email.trim().toString())){
			errors.put("email", "亲，该表单不能为空!!!");
		}else{
			if(!email.matches("\\w+@\\w+(.\\w+)+")){
				errors.put("email", "亲，邮箱格式不正确，请请重新写吧!!!");
			}
		}
		
		if(title==null || "".equals(title.trim().toString())){
			errors.put("title", "亲，该表单不能为空!!!");
		}
		
		if(essay==null || "".equals(essay.trim().toString())){
			errors.put("essay", "亲，该表单不能为空!!!");
		}
		return errors.isEmpty();
	}
}
