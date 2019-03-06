package com.achd.mongo.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "User")
public class User implements Serializable {

    @Id
    private String id;

    private String username;

    private String passwordMD5;

    public User(String id, String userName, String passwordMD5) {
        this.id = id;
        this.username = userName;
        this.passwordMD5 = passwordMD5;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordMD5() {
        return passwordMD5;
    }

    public void setPasswordMD5(String passwordMD5) {
        this.passwordMD5 = passwordMD5;
    }

}
