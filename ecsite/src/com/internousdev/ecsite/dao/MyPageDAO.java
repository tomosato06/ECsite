package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.MyPageDTO;
import com.internousdev.ecsite.util.DBConnector;

public class MyPageDAO {
	
	public ArrayList<MyPageDTO> getMyPageUserInfo(String item_transaction_id,String user_master_id)throws SQLException{
		
		//DBにインスタンス化とDB接続
		DBConnector db =new DBConnector();
		Connection con =db.getConnection();
		ArrayList<MyPageDTO> myPageDTO =new ArrayList<MyPageDTO>();
		
		//iitはitem_info_transaction テーブルを再定義したもの
		//ubitはuser_buy_item_transaction テーブルを再定義したもの
		//LEFT JOINを用いて複数のテーブルを結合することによってユーザ情報と履歴情報を紐付けて一括に取得することが出来る
		String sql="select ubit.id,iit.item_name,ubit.total_price,ubit.total_count,ubit.pay,ubit.insert_date "
				+ "from user_buy_item_transaction ubit "
				+ "left join item_info_transaction iit "
				+ "on ubit.item_transaction_id=iit.id "
				+ "where ubit.item_transaction_id=? "
				+ "and ubit.user_master_id=? "
				+ "order by insert_date desc";
		
		try{
			//PreparedStatementに代入
			PreparedStatement ps=con.prepareStatement(sql);
			
			//定義したSQL文の1の?にActionから送られたものがそれぞれに入る
			ps.setString(1,item_transaction_id);
			ps.setString(2,user_master_id);
			
			ResultSet rs=ps.executeQuery();
			
			
			//if(resultSet.next())は結果セットにまだ結果がある場合は、次の結果に移動して何かをするという意味
			while(rs.next()){
				MyPageDTO dto =new MyPageDTO();
				
				//取得した結果を1件ずつDTOに格納し,更にDTOをArraListに格納
				dto.setId(rs.getString("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setTotalPrice(rs.getString("total_price"));
				dto.setTotalCount(rs.getString("total_count"));
				dto.setPayment(rs.getString("pay"));
				dto.setInsert_date(rs.getString("insert_date"));
				myPageDTO.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return myPageDTO;
	}
	
	//削除するためのメッソド
	public int buyItemHistoryDelete(String item_transaction_id,String user_master_id)throws SQLException{
		
		//DBにインスタンス化とDB接続
		DBConnector db =new DBConnector();
		Connection con =db.getConnection();
		
		String sql="delete from user_buy_item_transaction where item_transaction_id =? and user_master_id =?";
		PreparedStatement ps;
		int result =0;
		
		try{
			//PreparedStatementに代入
			ps=con.prepareStatement(sql);
			
			//定義したSQL文の1の?にActionから送られたusernameそれぞれに入る
			ps.setString(1,item_transaction_id);
			ps.setString(2,user_master_id);
			
			//更新したものをresultに代入
			result=ps.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return result;
		
	}
	
}
