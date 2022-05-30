package com.sts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sts.model.User;
import com.sts.util.ConnectionFactory;

public class UserDaoImp implements UserDao {

	@Override
	public void save(User user) {
		try (Connection connection=ConnectionFactory.createConnection();
				PreparedStatement preparedStatement=connection.prepareStatement(ConnectionFactory.INSERT_USER)){
			
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getCountry());
			
		int result=	preparedStatement.executeUpdate();
			System.out.println("save status is : "+result);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean update(User user) {
		try (Connection connection=ConnectionFactory.createConnection();
				PreparedStatement preparedStatement=connection.prepareStatement(ConnectionFactory.UPDATE_USER)){
			
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getCountry());
			preparedStatement.setInt(4, user.getId());
			
			return preparedStatement.executeUpdate() >0;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		try(Connection connection=ConnectionFactory.createConnection();
				PreparedStatement preparedStatement=connection.prepareStatement(ConnectionFactory.DELETE_USER)) {
			
			preparedStatement.setInt(1, id);
			
			return preparedStatement.executeUpdate() >0;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> list=new ArrayList<>();
		try(Connection connection=ConnectionFactory.createConnection();
				PreparedStatement preparedStatement=connection.prepareStatement(ConnectionFactory.LIST_ALL_USERS))  {
			
			ResultSet rs=preparedStatement.executeQuery();
			
			while(rs.next())
			{
				int id=rs.getInt("ID");
				String name=rs.getString("name");
				String email=rs.getString("email");
				String country=rs.getString("country");
				
				list.add(new User(id, name, email, country));
			}
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getUserbyId(int id) {
		
		User user=null;
		try (Connection connection=ConnectionFactory.createConnection();
				PreparedStatement preparedStatement=connection.prepareStatement(ConnectionFactory.LIST_USER_BY_ID)) {
			preparedStatement.setInt(1, id);
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next())
			{
				int id2=rs.getInt("id");
				String name="name";
				String email="email";
				String country="country";
				
				user=new User(id2, name, email, country);
			}
			return user;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
