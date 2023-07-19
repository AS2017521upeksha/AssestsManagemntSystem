package com.example.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import com.mongodb.lang.NonNull;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "admin")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminModel {

    // Attributes of Admin model class
    @Id
    @NotNull
    @Indexed(unique = true)
    private ObjectId id;

    @NotEmpty(message = "Cannot be empty")
    @Indexed(unique = true)
    @NonNull
    private String username;

    @NotNull
    @NotEmpty(message = "Cannot be empty")
    @Size(min = 8, message = "Password length must be at least 8 characters")
    private String password;

    @Email(message = "Not valid email")
    @Indexed(unique = true)
    private String email;

    @NotNull
    @NotEmpty(message = "Cannot be empty")
    private String role;
}
