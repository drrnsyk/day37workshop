package vttp2022.csf.workshop37.server.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import vttp2022.csf.workshop37.server.model.Post;

import static vttp2022.csf.workshop37.server.repository.Queries.*;

@Repository
public class PostRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean postCommentsWithPicture(Post post) {
        return jdbcTemplate.update(SQL_INSERT_POST,
            post.getPostId(), post.getComments(), post.getPicture()) > 0;
    }

}
