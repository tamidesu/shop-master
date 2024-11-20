package kz.com.alzhan.temirlan.controllers;

import kz.com.alzhan.temirlan.dto.LoginRequestDTO;
import kz.com.alzhan.temirlan.dto.RegistrationRequestDTO;
import kz.com.alzhan.temirlan.dto.UserDTO;
import kz.com.alzhan.temirlan.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public UserDTO register(@RequestBody RegistrationRequestDTO requestDTO) {
        UserDTO userDTO = UserDTO.builder()
                .email(requestDTO.getEmail())
                .name(requestDTO.getName())
                .role(requestDTO.getRole())
                .contactInfo(requestDTO.getContactInfo())
                .isActive(requestDTO.isActive())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        return userService.createUser(userDTO, requestDTO.getPassword());
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody LoginRequestDTO loginRequestDTO) {
        System.out.println(loginRequestDTO);
        return userService.verify(loginRequestDTO);
//        return "Success";
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/{id}")
    public UserDTO updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        return userService.updateUser(id, userDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
