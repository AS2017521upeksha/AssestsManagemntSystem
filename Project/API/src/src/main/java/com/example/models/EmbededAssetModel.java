package com.example.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Embeded_Asset")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmbededAssetModel {
    private Number item_id;
    private String item_name;
    private Number quantity;
    private Number request_code;

}
