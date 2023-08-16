package com.example.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "embeded_asset")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmbededAssetModel {
    
    //Represant the ID of item
    @NonNull
    @Positive
    private Number item_id;

    //Represant the name of item
    @NotNull
    @NotBlank
    private String item_name;

    //Represant the quantity of item
    @NonNull
    @PositiveOrZero
    private Number quantity;

    //Reprasant the code for requesting the item
    @NonNull
    @Positive
    private Number request_code;

}
