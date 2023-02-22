package vttp2022.csf.workshop37.server.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import vttp2022.csf.workshop37.server.model.Post;
import vttp2022.csf.workshop37.server.service.PostService;

@RestController
@RequestMapping(path="/api")
public class PostRestController {

    @Autowired
    private PostService postSvc;
    
    @PostMapping(value="/post", consumes=MediaType.MULTIPART_FORM_DATA_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> postCommentsWithPicture(@RequestPart String comments, @RequestPart MultipartFile picture) {


        System.out.println("formData received");

        try {

            // convert the multipart file into a byte[]
            byte[] pictureData;
            pictureData = picture.getBytes();
            // map the received data to our model
            Post post = new Post(comments, pictureData);

            String JsonObjectString = postSvc.postCommentsWithPicture(post);
        
            return ResponseEntity.ok(JsonObjectString);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading image");
        }


    }
}
