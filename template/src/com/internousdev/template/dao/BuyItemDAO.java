package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.template.dto.BuyItemDTO;
import com.internousdev.template.util.DBConnector;

public class BuyItemDAO {
	
	public BuyItemDTO getBuyItemInfo(){
		
		//DBにインスタンス化とDB接続
		DBConnector dbConnector =new DBConnector();
		Connection connection =dbConnector.getConnection();
		BuyItemDTO buyItemDTO =new BuyItemDTO();
		
		//sql文を書く
		String sql="select id,item_name,item_price from item_info_transaction";
		
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			//ResultSetインターフェイスのオブジェクトとして取得	
			//executeQueryでDBから何らかの結果が返ってくる
			ResultSet resultSet = preparedStatement.executeQuery();
			
			//buyItemDTOのsetに格納する
			if(resultSet.next()){
				buyItemDTO.setId(resultSet.getInt("id"));
				buyItemDTO.setItemName(resultSet.getString("item_name"));
				buyItemDTO.setItemPrice(resultSet.getString("item_price"));
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	return buyItemDTO;
	}
}
