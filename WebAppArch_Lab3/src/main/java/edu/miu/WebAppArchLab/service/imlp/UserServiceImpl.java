package edu.miu.WebAppArchLab.service.imlp;

import edu.miu.WebAppArchLab.DTO.CommentDTO;
import edu.miu.WebAppArchLab.DTO.PostDTO;
import edu.miu.WebAppArchLab.DTO.UserDTO;

import edu.miu.WebAppArchLab.domain.Comment;
import edu.miu.WebAppArchLab.domain.User;
import edu.miu.WebAppArchLab.repository.PostRepository;
import edu.miu.WebAppArchLab.repository.UserRepository;
import edu.miu.WebAppArchLab.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private ModelMapper modelMapper;

    public UserDTO getUserById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
        return convertToDTO(user);
    }

    public List<UserDTO> getAllUsers() {
        List <User> users = userRepository.findAll();
        return users.stream().map(user -> modelMapper.map(user, UserDTO.class))
                        .collect(Collectors.toList());
    }

    public UserDTO createUser(UserDTO userDTO) {
        User user = convertToEntity(userDTO);
        user = userRepository.save(user);
        return convertToDTO(user);
    }
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            User existingUser = optionalUser.get();
            existingUser.setName(userDTO.getName());

            User updatedUser = userRepository.save(existingUser);
            return modelMapper.map(updatedUser, UserDTO.class);

        }
        else{
            return null;
        }
    }

    public boolean deleteUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            User userToDelete = optionalUser.get();
            userRepository.delete(userToDelete);
            return true;
        }
        else{
            return false;
        }
    }

   public List<PostDTO> getPostsByUserId(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
        return user.getPosts().stream().map(post -> modelMapper.map(post, PostDTO.class))
                        .collect(Collectors.toList());
    }

    public Optional<UserDTO> findByName(String name) {
        Optional<User> user = userRepository.findByName(name);
        return user.map(value -> modelMapper.map(value, UserDTO.class));
    }

    public List<UserDTO> findUsersWithMoreThanNPosts(@Param("n") int n) {
        List <User> users = userRepository.findUsersWithMoreThanNPosts(n);
        return users.stream().map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }
    public List<UserDTO> findUsersByPostsTitle(String title) {
        List <User> users = userRepository.findUsersByPostsTitle(title);
        return users.stream().map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    public Optional<CommentDTO> findCommentByUserAndPost(Long userId, Long postId, Long commentId) {
        Optional<Comment> comment = userRepository.findCommentByUserAndPost(userId, postId, commentId);
        return comment.map(value -> modelMapper.map(value, CommentDTO.class));
    }

    public UserDTO convertToDTO(User  user){
        return modelMapper.map(user, UserDTO.class);
    }

    public User convertToEntity(UserDTO userDTO){
        return modelMapper.map(userDTO, User.class);
    }


}
