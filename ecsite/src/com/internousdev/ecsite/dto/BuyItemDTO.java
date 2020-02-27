package com.internousdev.ecsite.dto;

public class BuyItemDTO {
	
	//テーブルカラムに対応したフィールド変数を宣言
	private int id;
	private String itemName;
	private String itemPrice;
	private String itemStock;
	
	//フィールド変数に対応したGetterとSetterを定義
	
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
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
	public String getItemStock() {
		return itemStock;
	}
	public void setItemStock(String itemStock) {
		this.itemStock = itemStock;
	}

}
