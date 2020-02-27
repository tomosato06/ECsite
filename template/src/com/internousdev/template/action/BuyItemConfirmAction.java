package com.internousdev.template.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.BuyItemCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemConfirmAction extends ActionSupport implements SessionAware{
	
	private Map<String,Object>session;
	public String execute(){
		BuyItemCompleteDAO buyItemCompleteDAO =new BuyItemCompleteDAO();
		
		//セッションから取得した商品情報をDAOのbyuItemInfoメソッドに渡しています
		buyItemCompleteDAO.buyItemInfo(
				session.get("id").toString (),
				session.get("login_user_id").toString (),
				session.get("buyItem_price").toString (),
				session.get("stock").toString (),
				session.get("pay").toString ()); //BuyItemCompleteDAO.buyItemInfoの引数の変数名と異なっていても型が同じなら大丈夫
		
		String result=SUCCESS;
		return result;
	}
	
	public Map<String,Object>getSession(){
		return session;
	}
	@Override
	public void setSession(Map<String,Object>session){
		this.session=session;
	}		

}
