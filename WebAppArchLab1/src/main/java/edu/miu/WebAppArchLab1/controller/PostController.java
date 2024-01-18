package edu.miu.WebAppArchLab1.controller;


import edu.miu.WebAppArchLab1.DTO.PostDTO;
import edu.miu.WebAppArchLab1.service.imlp.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostServiceImpl postService;

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getPostById(Long id) {

        PostDTO postDTO = postService.getPostById(id);
        return ResponseEntity.ok(postDTO);
    }
    @GetMapping
    public ResponseEntity<List<PostDTO>> getAllPosts() {

        List<PostDTO> posts = postService.getAllPosts();
        return ResponseEntity.ok(posts);
    }
    @PostMapping("/create")
    public ResponseEntity<PostDTO> createPost(PostDTO postDTO) {
        PostDTO createdPost = postService.createPost(postDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDTO> updatePost(@PathVariable Long id,@RequestBody PostDTO postDTO) {
        PostDTO updatedPost = postService.updatePost(id, postDTO);

        if(updatedPost != null) {
            return ResponseEntity.ok(updatedPost);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id) {
        boolean isDeleted = postService.deletePost(id);
        if(isDeleted) {
            return ResponseEntity.ok("Post with id " + id + " deleted successfully");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post with id " + id + " not found");
        }
    }


}
