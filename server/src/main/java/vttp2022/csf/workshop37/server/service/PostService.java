package vttp2022.csf.workshop37.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import vttp2022.csf.workshop37.server.model.Post;
import vttp2022.csf.workshop37.server.repository.PostRepository;

@Service
public class PostService {
    
    @Autowired
    private PostRepository postRepo;

    public String postCommentsWithPicture(Post post) {
        
        boolean isPostInserted = postRepo.postCommentsWithPicture(post);

        if(!isPostInserted) {
            JsonObject joInsertPostResult = Json.createObjectBuilder()
                .add("message", "upload was unsuccessful")
                .build();
            
            return joInsertPostResult.toString();
        }

        JsonObject joInsertPostResult = Json.createObjectBuilder()
        .add("message", "upload successfull")
        .build();
    
        return joInsertPostResult.toString();
        
    }

}
