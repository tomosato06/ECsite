package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.template.dto.MyPageDTO;
import com.internousdev.template.util.DBConnector;

public class MyPageDAO {
	
	public MyPageDTO getMyPageUserInfo(String item_transaction_id,String user_master_id){
		
		//DBにインスタンス化とDB接続
		DBConnector dbConnector =new DBConnector();
		Connection connection =dbConnector.getConnection();
		MyPageDTO myPageDTO =new MyPageDTO();
		
		//iitはitem_info_transaction テーブルを再定義したもの
		//ubitはuser_buy_item_transaction テーブルを再定義したもの
		//テーブル結合をしています。（MYSQLコマンドプロンプト）
		String sql="select iit.item_name,ubit.total_price,ubit.total_count,ubit.pay from user_buy_item_transaction ubit left join item_info_transaction iit on ubit.item_transaction_id=iit.id where ubit.item_transaction_id=? and ubit.user_master_id=? order by ubit.insert_date desc";
		
		try{
			//PreparedStatementに代入
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			//定義したSQL文の1の?にActionから送られたものがそれぞれに入る
			preparedStatement.setString(1,item_transaction_id);
			preparedStatement.setString(2,user_master_id);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			
			//if(resultSet.next())は結果セットにまだ結果がある場合は、次の結果に移動して何かをするという意味
			if(resultSet.next()){
				myPageDTO.setItemName(resultSet.getString("item_name"));
				myPageDTO.setTotalPrice(resultSet.getString("total_price"));
				myPageDTO.setTotalCount(resultSet.getString("total_count"));
				myPageDTO.setPayment(resultSet.getString("pay"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		return myPageDTO;
		
	}
	
	public int buyItemHistoryDelete(String item_transaction_id,String user_master_id){
		
		//DBにインスタンス化とDB接続
		DBConnector dbConnector =new DBConnector();
		Connection connection =dbConnector.getConnection();
		
		String sql="delete from user_buy_item_transaction where item_transaction_id =? and user_master_id =?";
		PreparedStatement preparedStatement;
		int result =0;
		
		try{
			//PreparedStatementに代入
			preparedStatement=connection.prepareStatement(sql);
			
			//定義したSQL文の1の?にActionから送られたusernameそれぞれに入る
			preparedStatement.setString(1,item_transaction_id);
			preparedStatement.setString(2,user_master_id);
			
			//更新したものをresultに代入
			result=preparedStatement.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return result;
		
	}
	
	
}
