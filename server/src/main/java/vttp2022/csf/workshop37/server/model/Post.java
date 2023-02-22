package vttp2022.csf.workshop37.server.model;

import java.util.UUID;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Post {
    String postId;
    String comments;
    byte[] picture;

    public String getPostId() {
        return postId;
    }
    public void setPostId(String postId) {
        this.postId = postId;
    }
    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }
    public byte[] getPicture() {
        return picture;
    }
    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public Post (String comments, byte[] picture) {
        this.postId = UUID.randomUUID().toString().substring(0,8);
        this.comments = comments;
        this.picture = picture;
    }


    // helper function
    public JsonObject toJson() {
        return Json.createObjectBuilder()
            .build();
    }


}

/*
 * In Spring Boot, the best data type to use for storing uploaded images into a SQL database would be a byte array or a BLOB (Binary Large Object) data type.
 * When receiving an uploaded image from Angular, Spring Boot can convert the image to a byte array using a MultipartFile object. 
 * This byte array can then be stored in a BLOB field in the SQL database.
 */