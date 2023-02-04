package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.OrderEntity;
import com.gcu.data.repository.mongo.OrdersMongoRepository;
import com.gcu.model.OrderModel;

@Service
public class OrdersDataService implements DataAccessInterface<OrderEntity>{	
	
	
	private JdbcTemplate jdbcTemplateObject;
	
	@Autowired
	DataSource dataSource;
	
	public OrdersDataService(DataSource dataSource)
	{
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<OrderEntity> findAll() {
		
		String sql = "SELECT * FROM ORDERS";
		List<OrderEntity> orders = new ArrayList<OrderEntity>();
		try
		{
			SqlRowSet src = jdbcTemplateObject.queryForRowSet(sql);
			while(src.next())
			{
				orders.add(new OrderEntity(
						src.getString("id"),
						src.getString("id"),
						src.getString("productName"),
						src.getFloat("price"),
						src.getInt("quantity")
						));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return orders;
		//return ordersRepository.findAll();
	}

	@Override
	public OrderEntity findById(String id) {
		String sql = "SELECT * FROM ORDERS WHERE id = " + id;
		try
		{
			SqlRowSet src = jdbcTemplateObject.queryForRowSet(sql);
			while(src.next())
			{
				 return new OrderEntity(
						src.getString("id"),
						src.getString("id"),
						src.getString("productName"),
						src.getFloat("price"),
						src.getInt("quantity")
						);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean create(OrderEntity order) {
		
		//ordersRepository.save(order);
		
		return true;
	}

	@Override
	public boolean update(OrderEntity t) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean delete(OrderEntity t) {
		// TODO Auto-generated method stub
		return true;
	}
	


}
