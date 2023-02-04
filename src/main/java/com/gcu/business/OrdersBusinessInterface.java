package com.gcu.business;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gcu.model.OrderModel;

public interface OrdersBusinessInterface {

	public void test();
	public List<OrderModel> getOrders();
	public OrderModel getOrderById(String id);
}
