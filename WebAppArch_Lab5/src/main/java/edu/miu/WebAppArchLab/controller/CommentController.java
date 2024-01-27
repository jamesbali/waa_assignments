package edu.miu.WebAppArchLab.controller;


import edu.miu.WebAppArchLab.DTO.CommentDTO;
import edu.miu.WebAppArchLab.service.imlp.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentServiceImpl commentService;

    @GetMapping ("/{id}")
    public ResponseEntity<CommentDTO> getCommentById(@PathVariable Long id){
        CommentDTO comment = commentService.getCommentById(id);
        return ResponseEntity.ok(comment);
    }

    @GetMapping
    public ResponseEntity<List<CommentDTO>> getAllComments(){
        List <CommentDTO> comments = commentService.getAllComments();
        return ResponseEntity.ok(comments);
    }

    @PostMapping("/create")
    public ResponseEntity<CommentDTO> createComment(@RequestBody CommentDTO commentDTO){
        CommentDTO createdComment = commentService.createComment(commentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdComment);

    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentDTO> updateComment(@PathVariable Long id, @RequestBody CommentDTO commentDTO){
        CommentDTO updatedComment = commentService.updateComment(id, commentDTO);
        if(updatedComment != null) {
            return ResponseEntity.ok(updatedComment);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/posts/{id}")
    public ResponseEntity<CommentDTO> addCommentToPost(@PathVariable Long id, @RequestBody CommentDTO commentDTO){
        CommentDTO updatedComment = commentService.addCommentToPost(id, commentDTO);
        if(updatedComment != null) {
            return ResponseEntity.ok(updatedComment);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable Long id){
        boolean isDeleted = commentService.deleteComment(id);
        if(isDeleted) {
            return ResponseEntity.ok("Comment with id " + id + " deleted successfully");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Comment with id " + id + " not found");
        }
    }



}
