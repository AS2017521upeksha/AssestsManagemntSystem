package com.example.models;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.IndexOptions.Unique;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Asset")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class AssetModel {

    private String item_code;
    private String item_name;
    private String request_code;
    private String location;
    private String brand;
    private Date purchase_date;
    private String barcode;

}
