package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.template.dto.LoginDTO;
import com.internousdev.template.util.DBConnector;

public class LoginDAO {
	
	public LoginDTO getLoginUserInfo(String loginUserId,String loginPassword){
		
		//DBにインスタンス化とDB接続
		DBConnector dbConnector =new DBConnector();
		Connection connection =dbConnector.getConnection();
		LoginDTO loginDTO =new LoginDTO();
				
		//sql文を書く
		String sql="select * from login_user_transaction where login_id=? and login_pass=?";
		try{
			//PreparedStatementに代入
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			//定義したSQL文の1の?にActionから送られたusernameそれぞれに入る
			preparedStatement.setString(1,loginUserId);
			preparedStatement.setString(2,loginPassword);
			
			//ResultSetインターフェイスのオブジェクトとして取得	
			//executeQueryでDBから何らかの結果が返ってくる
			ResultSet resultSet=preparedStatement.executeQuery();
			
			//if(resultSet.next())は結果セットにまだ結果がある場合は、次の結果に移動して何かをするという意味
			//loginDTOにデータを格納する
			if(resultSet.next()){
				loginDTO.setLoginId(resultSet.getString("login_id"));
				loginDTO.setLoginPassword(resultSet.getString("login_pass"));
				loginDTO.setUserName(resultSet.getString("user_name"));
				
				//かつlogin_idはActionへ	//!=(ノットイコール)正しくなければtrue
				if(resultSet.getString("login_id")!=null){
					loginDTO.setLoginFlg(true);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		//dtoに入った値をActionへ
		return loginDTO;
	}
}
