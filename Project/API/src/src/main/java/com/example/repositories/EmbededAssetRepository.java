package com.example.repositories;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.models.EmbededAssetModel;


public interface EmbededAssetRepository extends MongoRepository<EmbededAssetModel, ObjectId>{
    
}
