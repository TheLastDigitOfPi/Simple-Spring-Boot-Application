package com.gcu.data;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.OrderEntity;
import com.gcu.data.repository.mongo.OrdersMongoRepository;
import com.gcu.model.OrderModel;

@Service
public class OrdersDataService implements DataAccessInterface<OrderEntity>{	
	
	
	//private JdbcTemplate jdbcTemplateObject;
	
	//@Autowired
	//DataSource dataSource;
	
	public OrdersDataService()
	{
		//this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<OrderEntity> findAll() {
		
		
		
		
		//String sql = "SELECT * FROM ORDERS";
		List<OrderEntity> orders = new ArrayList<OrderEntity>();
		
		orders.add(new OrderEntity("1","1","product 1",3.50f,10));
		orders.add(new OrderEntity("2","2","product 2",3.50f,10));
		orders.add(new OrderEntity("3","3","product 3",1.50f,20));
		orders.add(new OrderEntity("4","4","product 4",2.50f,10));
		orders.add(new OrderEntity("5","5","product 5",4.50f,30));
		orders.add(new OrderEntity("6","6","product 6",5.50f,10));
		/*
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
		*/
		return orders;
		//return ordersRepository.findAll();
	}

	@Override
	public OrderEntity findById(String id) {
		
		
		for(OrderEntity Order : findAll())
		{
			if(Order.getOrderNo() == id)
				return Order;
		}
		return new OrderEntity("-1","-1","invalid",1f,1);
		/*
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
		*/
		
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
