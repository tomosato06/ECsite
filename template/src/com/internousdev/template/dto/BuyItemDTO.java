package com.internousdev.template.dto;

public class BuyItemDTO {
	
	//テーブルカラムに対応したフィールド変数を宣言
	private int id;
	private String itemName;
	private String itemPrice;
	
	//フィールド変数に対応したGetterとSetterを定義
	public String getItemName(){
		return itemName;
	}
	//格納
	public void setItemName(String itemName){
		this.itemName=itemName;
	}
	public String getItemPrice(){
		return itemPrice;
	}
	public void setItemPrice(String itemPrice){
		this.itemPrice=itemPrice;
	}
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	

}
