package edu.miu.WebAppArchLab.controller;


import edu.miu.WebAppArchLab.DTO.PostDTO;
import edu.miu.WebAppArchLab.DTO.UserDTO;
import edu.miu.WebAppArchLab.repository.UserRepository;
import edu.miu.WebAppArchLab.service.imlp.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {


    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(Long id) {
        UserDTO userDTO = userService.getUserById(id);
        return ResponseEntity.ok(userDTO);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List <UserDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(UserDTO userDTO) {
        UserDTO createdUser = userService.createUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }
    @GetMapping("/{id}/posts")
    public ResponseEntity<List<PostDTO>> getPostsByUserId(Long id) {
        List<PostDTO> posts = userService.getPostsByUserId(id);
        return ResponseEntity.ok(posts);
    }



}
