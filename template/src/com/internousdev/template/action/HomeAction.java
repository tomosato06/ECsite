package com.internousdev.template.action;

import com.opensymphony.xwork2.ActionSupport;

//ActionSupportというStruts2が提供するクラスを継承する
public class HomeAction extends ActionSupport {
	public String execute(){
		//成功コードを返す
		return SUCCESS;
	} 
}
