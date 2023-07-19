package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.AssetModel;
import com.example.repositories.AssetRepository;

@Service
public class AssetService {

    @Autowired
    // This code segment declares a private field named assetRepository1
    private AssetRepository assetRepository1;

    // This code segment retrieves a list of all AssetModel objects from the
    // repository.
    public List<AssetModel> assetModelList() {

        List<AssetModel> assetModels = assetRepository1.findAll();
        return assetModels;
    }

    // This code segment adds an AssetModel object to the repository.also works as
    // create method
    public AssetModel addAssetModel(AssetModel assetModel1) {
        return assetRepository1.save(assetModel1);
    }

    // This code segment retrieves an AssetModel object from the repository based on
    // its ID.
    public AssetModel getAssetById(String id) {
        return assetRepository1.findById(id).orElse(null);
    }

    // This code segment updates an AssetModel object in the repository based on its
    // ID.
    public AssetModel updateAsset(String id, AssetModel updatedAssetModel) {
        AssetModel existingAssetModel = assetRepository1.findById(id).orElse(null);
        if (existingAssetModel != null) {
            // Update the existing assetModel object with the new values
            existingAssetModel.setItem_code(updatedAssetModel.getItem_code());
            existingAssetModel.setItem_name(updatedAssetModel.getItem_name());
            existingAssetModel.setRequest_code(updatedAssetModel.getRequest_code());
            existingAssetModel.setLocation(updatedAssetModel.getLocation());
            existingAssetModel.setBrand(updatedAssetModel.getBrand());
            existingAssetModel.setPurchase_date(updatedAssetModel.getPurchase_date());
            existingAssetModel.setBarcode(updatedAssetModel.getBarcode());

            return assetRepository1.save(existingAssetModel);
        }
        return null;
    }

    // This code segment deletes an AssetModel object from the repository based on
    // its ID.
    public boolean deleteAsset(String id) {
        AssetModel existingAssetModel = assetRepository1.findById(id).orElse(null);
        if (existingAssetModel != null) {
            assetRepository1.delete(existingAssetModel);
            return true;
        }
        return false;
    }

    // public AssetModel updateAssetModel(AssetModel existingAssetModel) {
    // return null;
    // }

    // public Optional<AssetModel> getAssetModel(String assetModelId) {
    // return null;
    // }

    // public Optional<AssetModel> deleteAssetModel(String assetModelId) {
    // return null;
    // }

}
