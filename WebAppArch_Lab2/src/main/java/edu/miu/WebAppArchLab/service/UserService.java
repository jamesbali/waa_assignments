package edu.miu.WebAppArchLab.service;


import edu.miu.WebAppArchLab.DTO.UserDTO;
import edu.miu.WebAppArchLab.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

     UserDTO getUserById(Long id);

     List<UserDTO>  getAllUsers();

    UserDTO createUser(UserDTO userDTO);

     UserDTO updateUser(Long id, UserDTO userDTO);

    boolean deleteUser(Long id);

     UserDTO convertToDTO(User  user);

     User convertToEntity(UserDTO userDTO);

}
