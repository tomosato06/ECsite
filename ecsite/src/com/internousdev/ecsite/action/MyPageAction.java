package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.MyPageDAO;
import com.internousdev.ecsite.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;


public class MyPageAction extends ActionSupport implements SessionAware{
	
	private Map<String,Object> session;
	private MyPageDAO myPageDAO =new MyPageDAO();
	private ArrayList<MyPageDTO>myPageList =new ArrayList<MyPageDTO>();
	private String deleteFlg;
	private String message;
	
	public String execute() throws SQLException{
		
		if(!session.containsKey("login_user_id")){
			return ERROR;
		}
		//履歴を削除がされているか否か、チェックをしています。
		if(deleteFlg == null){
			String item_transaction_id =session.get("id").toString();
			String user_master_id =session.get("login_user_id").toString();
			
												    //DBから取得した履歴情報をmyPageListに格納
			myPageList =myPageDAO.getMyPageUserInfo(item_transaction_id, user_master_id);
			
			//商品履歴を削除する場合(deleteFlg=削除フラグ)
		}else if(deleteFlg.equals("1")){
			//deleteメッソドを呼び出して、履歴を削除処理を行います
			delete();
		}
		String result =SUCCESS;
		return result;
	}
	
	//履歴を削除を行うためメッソド
	public void delete() throws SQLException{
		
		String item_transaction_id =session.get("id").toString();
		String user_master_id =session.get("login_user_id").toString();
												
												//DBから削除した履歴情報の件数をresに格納
		int res=myPageDAO.buyItemHistoryDelete(item_transaction_id, user_master_id);
		
		if(res>0){
			myPageList =null;
			setMessage("商品情報を正しく削除しました。");
		}else if(res ==0){ //1件以上削除されたか否かで正常に削除処理がされたか判別しています。
			setMessage("商品情報の削除に失敗しました。");
			
		}
	}
	
	public void setDeleteFlg(String deleteFlg){
		this.deleteFlg =deleteFlg;
	}
	
	public ArrayList<MyPageDTO>getMyPageList(){
		return this.myPageList;
	}
	
	public String getMessage(){
		return this.message;
	}
	
	public void setMessage(String message){
		this.message=message;
	}
	
	public Map<String,Object>getSession(){
		return this.session;
	}
	
	@Override
	public void setSession(Map<String,Object>loginSessionMap){
		this.session=loginSessionMap;
	}		

}
