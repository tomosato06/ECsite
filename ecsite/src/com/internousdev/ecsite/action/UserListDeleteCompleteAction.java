package com.internousdev.ecsite.action;

import java.sql.SQLException;

import com.internousdev.ecsite.dao.UserListDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListDeleteCompleteAction extends ActionSupport{
	private String message;
	private String deleteFlg;
	

	public String execute() throws SQLException{
		
		String result =ERROR;
		
		if(deleteFlg ==null){
			
		}else if(deleteFlg.equals("1")){
			delete();
		}
		result =SUCCESS;
		return result;
	}	
		
	public String delete() throws SQLException{
		String result =ERROR;
		UserListDeleteCompleteDAO userDeleteListCompleteDAO =new UserListDeleteCompleteDAO();
		int res = userDeleteListCompleteDAO.deleteUserList();
		
		if(res > 0){
			setMessage("ユーザー情報を正しく削除しました。");
		}else{
			setMessage("ユーザー情報の削除に失敗しました。");
		}
		result =SUCCESS;
		return result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDeleteFlg() {
		return deleteFlg;
	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}
	
}
	