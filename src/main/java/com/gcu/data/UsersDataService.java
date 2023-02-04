package com.gcu.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.OrderEntity;
import com.gcu.data.entity.UserEntity;
import com.gcu.data.repository.mongo.UsersMongoRepository;
@Service
public class UsersDataService implements UserDataAccessInterface<UserEntity> {

	@Autowired
	private UsersMongoRepository usersRepository;

	private JdbcTemplate jdbcTemplateObject;
	
	@Autowired
	DataSource dataSource;
	
	@Override
	public UserEntity findByUsername(String username) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
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
		
	}

}
