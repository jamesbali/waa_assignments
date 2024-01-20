package edu.miu.WebAppArchLab.controller;


import edu.miu.WebAppArchLab.DTO.PostDTO;
import edu.miu.WebAppArchLab.DTO.UserDTO;
import edu.miu.WebAppArchLab.repository.UserRepository;
import edu.miu.WebAppArchLab.service.imlp.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/users")
public class UserController {


    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        UserDTO userDTO = userService.getUserById(id);
        return ResponseEntity.ok(userDTO);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List <UserDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO createdUser = userService.createUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }
    @GetMapping("/{id}/posts")
    public ResponseEntity<List<PostDTO>> getPostsByUserId(@PathVariable Long id) {
        List<PostDTO> posts = userService.getPostsByUserId(id);
        return ResponseEntity.ok(posts);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        boolean isDeleted = userService.deleteUser(id);
        if(isDeleted) {
            return ResponseEntity.ok("User with id " + id + " deleted successfully");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with id " + id + " not found");
        }
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<UserDTO> findByName(@PathVariable String name) {
        Optional<UserDTO> user = userService.findByName(name);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }
    @GetMapping("/filter/{n}")
    public ResponseEntity<List<UserDTO>> findUsersWithMoreThanNPosts(@PathVariable int n) {
        List<UserDTO> users = userService.findUsersWithMoreThanNPosts(n);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/filter/postTitle/{title}")
    public ResponseEntity<List<UserDTO>> findUsersByPostTitle(@PathVariable String title) {
        List<UserDTO> users = userService.findUsersByPostsTitle(title);
        return ResponseEntity.ok(users);
    }







}
