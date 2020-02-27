package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.internousdev.template.util.DBConnector;
import com.internousdev.template.util.DateUtil;

public class BuyItemCompleteDAO {
	
	public void buyItemInfo(String item_transaction_id,String user_master_id,String total_price,String total_count,String pay){
		
		//DBにインスタンス化とDB接続
		DBConnector dbConnector =new DBConnector();
		Connection connection =dbConnector.getConnection();
		DateUtil dateUtil=new DateUtil();
		
		String sql="insert into user_buy_item_transaction(item_transaction_id,total_price,total_count,user_master_id,pay,insert_date)values(?,?,?,?,?,?)";
		
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			//定義したSQL文の1の?にActionから送られたものをそれぞれに入る
			preparedStatement.setString(1,item_transaction_id);
			preparedStatement.setString(2,total_price);
			preparedStatement.setString(3,total_count);
			preparedStatement.setString(4,user_master_id);
			preparedStatement.setString(5,pay);
			preparedStatement.setString(6,dateUtil.getDate());
			
			//executeQueryでDBから何らかの結果が返ってくる
			preparedStatement.execute();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
			connection.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
				
	}
	
}
