package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class ItemListDeleteCompleteDAO {
	
	private DBConnector db =new DBConnector();
	private Connection con =db.getConnection();
	
	//DBから購入履歴を取得するためのメソッド
	public int deleteItemList()throws SQLException{
		
		String sql="delete from item_info_transaction";
		PreparedStatement ps;
		int result =0;
		
		try{
			//PreparedStatementに代入
			ps=con.prepareStatement(sql);
			
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