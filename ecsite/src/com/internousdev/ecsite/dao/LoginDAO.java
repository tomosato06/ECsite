package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.LoginDTO;
import com.internousdev.ecsite.util.DBConnector;


public class LoginDAO {
		
		//DBにインスタンス化とDB接続
		private DBConnector db =new DBConnector();
		private Connection con =db.getConnection();
		private LoginDTO loginDTO =new LoginDTO();
		
		public LoginDTO getLoginUserInfo(String loginUserId,String loginPassword){
			//sql文を書く
			String sql="select * from login_user_transaction where login_id=? and login_pass=?";
			try{
				//PreparedStatementに代入
				PreparedStatement ps=con.prepareStatement(sql);
				
				//定義したSQL文の1の?にActionから送られたusernameそれぞれに入る
				ps.setString(1,loginUserId);
				ps.setString(2,loginPassword);
				
				//ResultSetインターフェイスのオブジェクトとして取得	
				//executeQueryでDBから何らかの結果が返ってくる
				ResultSet rs=ps.executeQuery();
				
				//if(resultSet.next())は結果セットにまだ結果がある場合は、次の結果に移動して何かをするという意味
				//loginDTOにデータを格納する
				if(rs.next()){
					loginDTO.setLoginId(rs.getString("login_id"));
					loginDTO.setLoginPassword(rs.getString("login_pass"));
					loginDTO.setUserName(rs.getString("user_name"));
					
					//かつlogin_idはActionへ	//!=(ノットイコール)正しくなければtrue
					if(rs.getString("login_id")!=null){
						loginDTO.setLoginFlg(true);
					}
					loginDTO.setAdminFlg(rs.getString("admin_flg"));
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			return loginDTO;
		}
		public LoginDTO getLoginDTO(){
			return loginDTO;
		}
	}
