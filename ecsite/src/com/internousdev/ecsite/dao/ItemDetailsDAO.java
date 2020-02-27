package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ItemDetailsDAO {
	
	private DBConnector db =new DBConnector();
	private Connection con =db.getConnection();
	
	public ItemInfoDTO getItemInfo (String id)throws SQLException{
		ItemInfoDTO dto =new ItemInfoDTO();
		String sql ="select * from item_info_transaction where id=?";
		
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,Integer.parseInt(id));
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				
				dto.setId(rs.getString("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getString("item_price"));
				dto.setItemStock(rs.getString("item_stock"));
				dto.setInsert_date(rs.getString("insert_date"));
				dto.setUpdated_date(rs.getString("updated_date"));

			}
		}catch(Exception e){
			e.printStackTrace();
	
		
		}finally{
			con.close();
		}
		return dto;
	}

}
