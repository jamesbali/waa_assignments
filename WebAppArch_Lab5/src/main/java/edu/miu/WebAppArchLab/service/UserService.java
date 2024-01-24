package edu.miu.WebAppArchLab.service;


import edu.miu.WebAppArchLab.DTO.UserDTO;
import edu.miu.WebAppArchLab.domain.User;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

     UserDTO getUserById(Long id);

     List<UserDTO>  getAllUsers();

    UserDTO createUser(UserDTO userDTO);

     UserDTO updateUser(Long id, UserDTO userDTO);

    boolean deleteUser(Long id);

//    Optional<UserDTO> findByName(String name);
//    List<UserDTO> findUsersWithMoreThanNPosts(@Param("n") int n);

     UserDTO convertToDTO(User  user);

     User convertToEntity(UserDTO userDTO);

}
