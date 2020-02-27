package com.internousdev.template.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
									//実装メソッドであるsetSession(Map session)にてActionフィールドへ格納する処理を実装する
public class BuyItemAction extends ActionSupport implements SessionAware{
	
	private int stock;
	private String pay;
	public Map<String,Object> session;
	private String result;
	
	public String execute(){
		result=SUCCESS;
		
		//格納してる（他にも取り出せるように格納）
		session.put("stock",stock);
		
					//オブジェクトになっているためtoStringは文字列へ変換+Integer.parseIntでint型にしている
		int intStock = Integer.parseInt(session.get("stock").toString ());
		int intPrice = Integer.parseInt(session.get("buyItem_price").toString ());
		
		//Mapではputメソッドを使用
		//session格納("buyItem_price",intStock * intPrice)
		session.put("buyItem_price",intStock * intPrice);
		String payment;
		
		if(pay.equals("1")){
			
			payment="現金払い";
			session.put("pay",payment);
		}else{
			payment="クレジットカード";
			session.put("pay",payment);
			
		}
		return result;
	}
	//getStockでフィールドの値の取得を呼び出し元に返す(Actionへ)
	public int getStock(){
		return stock;	
	}
	//setStockで名前を書き換える[処理]を行う
	public void setStock(int stock){
		this.stock =stock;
	}
	public String getPay(){
		return pay;
	}
	public void setPay(String pay){
		this.pay =pay;
	}
	//ActionクラスのsessionへStruts2が自動的にMapの型で格納
	public Map<String,Object>getSession(){
		return session;
	}
	@Override
	public void setSession(Map<String,Object>session){
		this.session=session;
	}		

}