package com.gcu.data.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gcu.data.entity.UserEntity;

public interface UsersMongoRepository extends MongoRepository<UserEntity, String>{

	UserEntity findByUsername(String username);
}
