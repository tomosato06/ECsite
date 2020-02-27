package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
									//実装メソッドであるsetSession(Map session)にてActionフィールドへ格納する処理を実装する
public class BuyItemAction extends ActionSupport implements SessionAware{
	
	private Map<String,Object> session;
	private int count;
	private String pay;
	public String errorMassage;//在庫の有無メッセージ
	
	public String execute(){
		String result=SUCCESS;
		int itemStock = Integer.parseInt(session.get("item_stock").toString());
		if(count > itemStock){
			setErrorMassage("在庫が足りません。");
			return ERROR;
		}
		
		//格納してる（他にも取り出せるように格納）
		session.put("count",count);
		
					//オブジェクトになっているためtoStringは文字列へ変換+Integer.parseIntでint型にしている
		int intCount = Integer.parseInt(session.get("count").toString());
		int intPrice = Integer.parseInt(session.get("buyItem_price").toString());
		
		//Mapではputメソッドを使用
		//session格納("buyItem_price",intStock * intPrice)
		session.put("total_price",intCount * intPrice);
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
	
	//setStockで名前を書き換える[処理]を行う
	public void setCount(int count){
		this.count =count;
	}
	
	public void setPay(String pay){
		this.pay =pay;
	}
	public void setErrorMassage(String errorMassage){
		this.errorMassage =errorMassage;
	}
	//ActionクラスのsessionへStruts2が自動的にMapの型で格納
	public Map<String,Object>getSession(){
		return this.session;
	}
	@Override
	public void setSession(Map<String,Object>session){
		this.session=session;
	}	

}