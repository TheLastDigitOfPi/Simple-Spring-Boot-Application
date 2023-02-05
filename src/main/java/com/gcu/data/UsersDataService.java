package com.gcu.data;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.OrderEntity;
import com.gcu.data.entity.UserEntity;
import com.gcu.data.repository.mongo.UsersMongoRepository;
@Service
public class UsersDataService implements UserDataAccessInterface<UserEntity> {

	//@Autowired
	//private UsersMongoRepository usersRepository;

	//private JdbcTemplate jdbcTemplateObject;
	
	//@Autowired
	//DataSource dataSource;
	
	@Override
	public UserEntity findByUsername(String username) {
		//this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		
		List<UserEntity> usersList = new ArrayList<UserEntity>();
		usersList.add(new UserEntity("1", "Daniel", "$2a$10$LzO.G0Fd2MwR9tA4zwQnDOrbhQvHm5p.ncuFDvCpxl7SZ/WK9.BLS"));
		usersList.add(new UserEntity("2", "Test", "$2a$10$.yEgZxAVU9sUxAq7JJVOnewu9ZgQG5e2E1FCcm3OE6CeHR9bRBECO"));
		
		for(UserEntity user : usersList)
		{
			if(user.getUsername().equals(username))
				return user;
		}
		return null;
		/*
		String sql = "SELECT * FROM USERS WHERE username = '" + username + "'";
		try
		{
			SqlRowSet src = jdbcTemplateObject.queryForRowSet(sql);
			while(src.next())
			{
				 return new UserEntity(
						src.getString("id"),
						src.getString("username"),
						src.getString("password")
						);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
		*/
	}

}
