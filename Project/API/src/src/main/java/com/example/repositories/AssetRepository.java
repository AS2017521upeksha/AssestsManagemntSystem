package com.example.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.models.AssetModel;

public interface AssetRepository extends MongoRepository<AssetModel, ObjectId> {

}
