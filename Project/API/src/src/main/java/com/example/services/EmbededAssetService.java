package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.models.EmbededAssetModel;
import com.example.repositories.EmbededAssetRepository;

public class EmbededAssetService {
      
    private EmbededAssetRepository assetRepository;

    @Autowired
    public EmbededAssetService(EmbededAssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    public EmbededAssetModel createAsset(EmbededAssetModel asset) {
        // You can add additional business logic here before saving the asset
        return assetRepository.save(asset);
    }

    public EmbededAssetModel getAssetById(Long itemId) {
        return assetRepository.findByItem_id(itemId);
    }

    public List<EmbededAssetModel> getAllAssets() {
        return assetRepository.findAll();
    }

    public EmbededAssetModel updateAsset(Long itemId, EmbededAssetModel updatedAsset) {
        EmbededAssetModel existingAsset = assetRepository.findByItem_id(itemId);
        if (existingAsset != null) {
            // You can add additional business logic here before updating the asset
            existingAsset.setItem_name(updatedAsset.getItem_name());
            existingAsset.setQuantity(updatedAsset.getQuantity());
            existingAsset.setRequest_code(updatedAsset.getRequest_code());
            return assetRepository.save(existingAsset);
        } else {
            return null;
        }
    }

    public boolean deleteAsset(Long itemId) {
        EmbededAssetModel existingAsset = assetRepository.findByItem_id(itemId);
        if (existingAsset != null) {
            assetRepository.delete(existingAsset);
            return true;
        } else {
            return false;
        }
    }

}
