package com.gcu.data.repository.mongo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gcu.data.entity.OrderEntity;

public interface OrdersMongoRepository extends MongoRepository<OrderEntity, String>{

	OrderEntity getOrderById(String id);
}
