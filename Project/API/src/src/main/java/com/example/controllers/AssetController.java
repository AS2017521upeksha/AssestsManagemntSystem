package com.example.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.AdminModel;
import com.example.models.AssetModel;
import com.example.services.AssetService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/asset")
public class AssetController {

    @Autowired
    private AssetService assetService1;

    @GetMapping
    public ResponseEntity<List<AssetModel>> allAssetModelsEntity() {
        return new ResponseEntity<List<AssetModel>>(assetService1.assetModelList(), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<AssetModel> addAssetModelEntity(@Valid AssetModel assetModelData, BindingResult bindingResult,
            @RequestBody AssetModel assetModel) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<AssetModel>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<AssetModel>(assetService1.addAssetModel(assetModel), HttpStatus.OK);
        }

    }

    @PutMapping("/{Id}")
    public ResponseEntity<AssetModel> updateAdmin(@PathVariable String id, @RequestBody AssetModel assetModel) {
        AssetModel existingAssetModel = assetService1.getAssetById(id);
        if (existingAssetModel.isPresent()) {
            assetModel.setId(existingAssetModel.get().getAssetById());
            AssetModel updateAssetModel = assetService1.updateAsset(id, updateAssetModel);
            return ResponseEntity.ok(updateAssetModel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{assetModelId}")
    public ResponseEntity<AssetModel> patchAssetModel(@PathVariable("assetModelId") String assetModelId,
            @RequestBody Map<String, Object> updatedFields) {
        Optional<AssetModel> existingAssetModelOptional = assetService1.getAsset(assetModelId);
        if (existingAssetModelOptional.isPresent()) {
            AssetModel existingAssetModel = existingAssetModelOptional.get();

            AssetModel patchedAssetModel = assetService1.updateAsset(existingAssetModel);
            return ResponseEntity.ok(patchedAssetModel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{assetModelId}")
    public ResponseEntity<Void> deleteAssetModel(@PathVariable("assetModelId") String assetModelId) {
        Optional<AssetModel> assetModel = assetService1.deleteAssetModel(assetModelId);
        if (assetModel.isPresent()) {
            assetService1.deleteAsset(assetModelId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
