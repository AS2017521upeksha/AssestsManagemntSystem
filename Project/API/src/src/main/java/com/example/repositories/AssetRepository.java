package com.example.repositories;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.models.AssetModel;

public interface AssetRepository extends MongoRepository<AssetModel, ObjectId> {

    Optional<AssetModel> findById(String id);

}
