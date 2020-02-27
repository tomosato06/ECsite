package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ItemListDAO {
	
	private DBConnector db =new DBConnector();
	private Connection con =db.getConnection();
	
	//DBから購入履歴を取得するためのメソッド
	public List<ItemInfoDTO>getItemList()throws SQLException{
		
		List<ItemInfoDTO>itemInfoDTOList =new ArrayList<ItemInfoDTO>();
		//複数のテーブルを紐づけ
		String sql="select *from item_info_transaction order by id";
		
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				ItemInfoDTO dto =new ItemInfoDTO();
				dto.setId(rs.getString("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getString("item_price"));
				dto.setItemStock(rs.getString("item_stock"));
				dto.setInsert_date(rs.getString("insert_date"));
				dto.setUpdated_date(rs.getString("updated_date"));
				itemInfoDTOList.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return itemInfoDTOList;
	}
	

}
