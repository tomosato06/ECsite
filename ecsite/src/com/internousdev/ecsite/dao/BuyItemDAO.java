package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.util.DBConnector;

public class BuyItemDAO {
	private DBConnector db =new DBConnector();
	private Connection con =db.getConnection();
	private BuyItemDTO buyItemDTO =new BuyItemDTO();
	
	public BuyItemDTO getBuyItemInfo(){
		
		//商品情報をすべて取得するSQL文を書く
		String sql="select id,item_name,item_price,item_stock from item_info_transaction";
		
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			//SQL文を実行します
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				//DBから取得した情報をDTOクラスに格納
				buyItemDTO.setId(rs.getInt("id"));
				buyItemDTO.setItemName(rs.getString("item_name"));
				buyItemDTO.setItemPrice(rs.getString("item_price"));
				buyItemDTO.setItemStock(rs.getString("item_stock"));
		}
	}catch(Exception e){
		//処理中に例外が発生した際に実行する処理です
		e.printStackTrace();
	}
	//ActionクラスにDTOクラスを返します
	return buyItemDTO;
	}
	public BuyItemDTO getBuyItemDTO(){
		return buyItemDTO;
	}
}
