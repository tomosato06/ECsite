package com.internousdev.ecsite.action;
import com.opensymphony.xwork2.ActionSupport;

public class ItemDeleteConfirmAction extends ActionSupport{
	private String id;
	public String execute(){
		return SUCCESS;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
