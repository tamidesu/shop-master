package kz.com.alzhan.temirlan.services;

import kz.com.alzhan.temirlan.dto.LoginRequestDTO;
import kz.com.alzhan.temirlan.dto.UserDTO;
import java.util.List;

public interface UserService {

    UserDTO createUser(UserDTO userDTO, String rawPassword);

    UserDTO getUserById(Long id);

    List<UserDTO> getAllUsers();

    UserDTO updateUser(Long id, UserDTO userDTO);

    void deleteUser(Long id);

    String verify(LoginRequestDTO loginRequestDTO);
}
