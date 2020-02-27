package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemConfirmAction extends ActionSupport implements SessionAware{
	
	public Map<String,Object>session;
	private BuyItemCompleteDAO buyItemCompleteDAO =new BuyItemCompleteDAO();
	
	public String execute()throws SQLException{
		
		//セッションから取得した商品情報をDAOのbyuItemInfoメソッドに渡しています
		int count=buyItemCompleteDAO.buyItemInfo(
				session.get("id").toString(),
				session.get("total_price").toString(),
				session.get("count").toString(),
				session.get("login_user_id").toString(),
				session.get("pay").toString()); //BuyItemCompleteDAO.buyItemInfoの引数の変数名と異なっていても型が同じなら大丈夫
		if(count > 0){
			buyItemCompleteDAO.updateItemStock(Integer.parseInt(session.get("count").toString()),session.get("id").toString());
		}
		
		String result=SUCCESS;
		return result;
	}
	
	
	@Override
	public void setSession(Map<String,Object>session){
		this.session=session;
	}		

}
