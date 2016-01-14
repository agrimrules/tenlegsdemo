package com.agrimasthana.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.agrimasthana.model.User;
import com.agrimasthana.util.DBUtility;

public class UserService {

	private Connection connection;
	
	public UserService(){
		connection = DBUtility.getConnection();
	}
	
	public void createUser(User usr){
		if(usr.getDateJoined()==null){
			java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
			usr.setDateJoined(date);}
		try{
			PreparedStatement statement = connection.prepareStatement("insert into Users(name,date_joined) values (?, ? )");
			statement.setString(1, usr.getName());
			statement.setDate(2,usr.getDateJoined());
			statement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	
	
	public void updateUser(User usr){
		try{
			PreparedStatement statement = connection.prepareStatement("Update Users set name=?, date_joined=?  where id=?");
			statement.setString(1, usr.getName());
			statement.setDate(2,usr.getDateJoined());
			statement.setInt(3, usr.getid());
			statement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public User getUser(int id){
		User usr = new User();
		try{
			PreparedStatement statement = connection.prepareStatement("select * from Users where id=?");
			statement.setInt(1, id);
			ResultSet rs=statement.executeQuery();
			while(rs.next()){
				usr.setid(rs.getInt("id"));
				usr.setName(rs.getString("name"));
				usr.setDateJoined(rs.getDate("date_joined"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return usr;
	}
	
	
	public List<User> getAllUsers(){
		List<User> users = new ArrayList<User>();
		try{
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from Users");
			while (rs.next()){
				User user = new User();
				user.setid(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setDateJoined(rs.getDate("date_joined"));
				users.add(user);
				}
			} catch(SQLException e){
				e.printStackTrace();
			}
		return users;
	}
	
	public void deleteUser(int id){
		try{
			PreparedStatement statement = connection.prepareStatement("delete from Users where id=?");
			statement.setInt(1, id);
			statement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
}
