package com.assignment.BookStore.models;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    @Id
    private String id;

    private String name;
    private String email;
    private String password;
    private String role;
    private String phone;
    private String address;
    private String createdAt;
    private String updatedAt;
    private String status;
    private String bannedReason;
}

