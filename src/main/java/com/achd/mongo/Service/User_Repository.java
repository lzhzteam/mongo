package com.achd.mongo.Service;

import com.achd.mongo.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface User_Repository extends MongoRepository<User, Long> {
    User findByUsername(String username);
}
