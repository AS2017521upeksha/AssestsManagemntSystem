package com.example.repositories;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.models.AdminModel;

public interface AdminRepository extends MongoRepository<AdminModel, ObjectId> {

    AdminModel findOneById(String id);

    void deleteById(String id);
}
