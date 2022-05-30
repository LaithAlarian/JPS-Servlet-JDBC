package com.sts.dao;

import java.util.List;

import com.sts.model.User;

public interface UserDao {
	
	public void save(User user);
	public boolean update(User user);
	public boolean delete(int id);
	public List<User> getAllUsers();
	public User getUserbyId(int id);
}
