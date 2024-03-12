// package com.example.backend.repositoryTest;

// import org.assertj.core.api.Assertions;
// import org.junit.jupiter.api.MethodOrderer;
// import org.junit.jupiter.api.Order;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.TestMethodOrder;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
// import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
// import org.springframework.jdbc.core.JdbcTemplate;
// import org.springframework.test.annotation.Rollback;

// import com.example.backend.models.Post;
// import com.example.backend.repository.PostRepository;


// @DataJpaTest
// @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
// public class PostRepositoryTest {

//     @Autowired
//     private PostRepository postRepository;
    
//     @Test
//     @Order(1)
//     @Rollback(value = false)
//     public void savePostTest(){

//         Post post = Post.builder()
//                 .title("post1")
//                 .type("blog")
//                 .description("complain")
//                 .reference("5")
//                 .description("complain")
//                 .build();

//         postRepository.save(post);

//         Assertions.assertThat(post.getId()).isGreaterThan(0);
//     }
    
// }
