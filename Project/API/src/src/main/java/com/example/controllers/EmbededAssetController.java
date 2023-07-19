package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.models.EmbededAssetModel;
import com.example.services.EmbededAssetService;

import java.util.List;

@RestController
@RequestMapping("/api/assets")
public class EmbededAssetController {

    @Autowired
    private  EmbededAssetService assetService;

    

    @PostMapping
    public ResponseEntity<EmbededAssetModel> createAsset(@Valid @RequestBody EmbededAssetModel asset) {
        EmbededAssetModel createdAsset = assetService.createAsset(asset);
        return new ResponseEntity<>(createdAsset, HttpStatus.CREATED);
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<EmbededAssetModel> getAssetById(@PathVariable("itemId") Long itemId) {
        EmbededAssetModel asset = assetService.getAssetById(itemId);
        if (asset != null) {
            return new ResponseEntity<>(asset, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<EmbededAssetModel>> getAllAssets() {
        List<EmbededAssetModel> assets = assetService.getAllAssets();
        return new ResponseEntity<>(assets, HttpStatus.OK);
    }

    @PutMapping("/{itemId}")
    public ResponseEntity<EmbededAssetModel> updateAsset(@PathVariable("itemId") Long itemId, @Valid @RequestBody EmbededAssetModel updatedAsset) {
        EmbededAssetModel asset = assetService.updateAsset(itemId, updatedAsset);
        if (asset != null) {
            return new ResponseEntity<>(asset, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<Void> deleteAsset(@PathVariable("itemId") Long itemId) {
        boolean deleted = assetService.deleteAsset(itemId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
