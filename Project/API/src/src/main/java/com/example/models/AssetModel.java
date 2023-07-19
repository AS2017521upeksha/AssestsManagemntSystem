package com.example.models;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.IndexOptions.Unique;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "asset")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class AssetModel {

    // Represent the code of item
    @NotNull(message = "Item code cannot be null")
    private String item_code;

    // Represent the name of the item
    @NotNull(message = "Item name cannot be null")
    @Size(max = 100, message = "Item name must be at most 100 characters long")
    private String item_name;

    // Represent the code for requesting the item
    @NotNull(message = "Request code cannot be null")
    private String request_code;

    // Represent the location of item
    @NotNull(message = "Item location cannot be null")
    private String location;

    // Represent the brand of item
    @NotNull(message = "Item brand cannot be null")
    private String brand;

    // Represent the date of item's purchase
    @NotNull(message = "Purchase date cannot be null")
    // to get date format as yyyy/MM/dd
    @DateTimeFormat
    private Date purchase_date;

    // Represent the barcod of the item
    @NotNull(message = "Item barcode cannot be null")
    private String barcode;

    // This implementation of the isPresent() method always returns false.
    // It indicates that the value is not present within the current context.
    public boolean isPresent() {
        return false;
    }

    public Object get() {
        return null;
    }

}
