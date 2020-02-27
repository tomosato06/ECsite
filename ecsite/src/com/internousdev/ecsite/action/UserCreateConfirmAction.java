package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserCreateConfirmDAO;
import com.opensymphony.xwork2.ActionSupport;


public class UserCreateConfirmAction extends ActionSupport implements SessionAware{
	
	private String loginUserId;
	private String loginPassword;
	private String userName;
	private Map<String,Object>session;
	private String errorMessage;
	
	public String execute(){
		
		String result =SUCCESS;
		//未入力項目の有無を確認
		if(!(loginUserId.equals(""))
				&&!(loginPassword.equals(""))
				&&!(userName.equals(""))){
			
			//ユーザー登録する際にログインID存在チェックを追加
			UserCreateConfirmDAO userCreateConfirmDAO =new UserCreateConfirmDAO();
			if(!userCreateConfirmDAO.isExistUser(loginUserId)){
					session.put("loginUserId",loginUserId);
					session.put("loginPassword",loginPassword);
					session.put("userName",userName);	
			}else{
				setErrorMessage("すでに登録されているログインIDです。");
				result =ERROR;
			}
		}else{
			setErrorMessage("未入力の項目があります。");
			result =ERROR;
		}
		return result;
	}
	//Actionに返す
	public String getLoginUserId(){
		return loginUserId;	
	}
	//格納
	public void setLoginUserId(String loginUserId){
		this.loginUserId =loginUserId;
	}
	public String getLoginPassword(){
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword){
		this.loginPassword =loginPassword;
	}
	public String getUserName(){
		return userName;	
	}
	public void setUserName(String userName){
		this.userName =userName;
	}
	@Override
	public void setSession(Map<String,Object>session){
		this.session=session;
	}		
	public String getErrorMessage(){
		return errorMessage;	
	}
	public void setErrorMessage(String errorMessage){
		this.errorMessage =errorMessage;
	}

}
