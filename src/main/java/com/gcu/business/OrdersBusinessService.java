package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.DataAccessInterface;
import com.gcu.data.entity.OrderEntity;
import com.gcu.model.OrderModel;

@Service
public class OrdersBusinessService implements OrdersBusinessInterface {

	private ArrayList<OrderModel> orders = new ArrayList<OrderModel>();
	
	@Autowired
	DataAccessInterface<OrderEntity> service;
	
	@Override
	public void test() {
		System.out.println("Hello from OrdersBusinessService");
		
	}
	
	

	@Override
	public List<OrderModel> getOrders() {
		
		List<OrderEntity> ordersEntity = service.findAll();
		
		List<OrderModel> ordersDomain = new ArrayList<OrderModel>();
		for(OrderEntity entity: ordersEntity)
		{
			ordersDomain.add(new OrderModel(entity.getId(), entity.getOrderNo(), entity.getProductName(), entity.getPrice(), entity.getQuantity()));
		}
		
		return ordersDomain;
		
	}
	
	public OrdersBusinessService() {
		orders.add(new OrderModel("", "000000001", "Product 1", 1.00f, 1));
		orders.add(new OrderModel("", "000000002", "Product 2", 2.00f, 2));
		orders.add(new OrderModel("", "000000003", "Product 3", 3.00f, 3));
		orders.add(new OrderModel("", "000000004", "Product 4", 4.00f, 4));
		orders.add(new OrderModel("", "000000005", "Product 5", 5.00f, 5));
	}

	

	@Override
	public OrderModel getOrderById(String id) {
		
		OrderEntity orderEntity = service.findById(id);
		
		return orderEntity == null? null: new OrderModel(orderEntity.getId(), orderEntity.getOrderNo(), orderEntity.getProductName(), orderEntity.getPrice(), orderEntity.getQuantity());
	}

	
}
