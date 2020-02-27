package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class ItemDeleteCompleteDAO {
	
	private DBConnector db =new DBConnector();
	private Connection con =db.getConnection();
	
	public int deleteItem(String id)throws SQLException{
		String sql ="delete from item_info_transaction where id=?";
		PreparedStatement ps;
		int result =1;
		
		try{
			ps=con.prepareStatement(sql);
			ps.setString(1,id);
			
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