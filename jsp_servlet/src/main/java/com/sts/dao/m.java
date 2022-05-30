package com.sts.dao;

import java.util.ArrayList;
import java.util.List;

import com.sts.model.User;

public class m {

	public static void main(String[] args) {
		
		List<User> user22=new ArrayList<>();

		UserDaoImp daoImp=new UserDaoImp();
		
		User user=new User();
	user22=	daoImp.getAllUsers();
		
		for(User user2:user22)
		{
			System.out.println(user2.getId()+"    "+user2.getName());
			
		}
		
	}

}
