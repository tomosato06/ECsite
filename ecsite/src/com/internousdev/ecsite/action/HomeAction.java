package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware{
	public Map<String,Object>session;
	
	public String execute(){
		//ログインしていない場合
		String result ="login";
		
		//ログイン済み判定を行います。一度ログインしている場合はログイン確認画面ではなく商品画面へ飛ぶ	
		if(session.containsKey("login_user_id")){
			BuyItemDAO buyItemDAO = new BuyItemDAO();
			BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();
			
			//DBから取得した商品情報をセッションに格納します
			session.put("id", buyItemDTO.getId());
			session.put("buyItem_name", buyItemDTO.getItemName());
			session.put("buyItem_price", buyItemDTO.getItemPrice());
			session.put("item_stock", buyItemDTO.getItemStock());
			
			//ログイン状態の場合
			result =SUCCESS;
		}
		
		//executeメッソドの戻り値として、ログイン状態の場合は[SUCCESS]
		//ログインしてない場合は["login"]を返します
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
