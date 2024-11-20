package kz.com.alzhan.temirlan.services.impl;

import kz.com.alzhan.temirlan.dto.LoginRequestDTO;
import kz.com.alzhan.temirlan.dto.UserDTO;
import kz.com.alzhan.temirlan.entities.UserEntity;
import kz.com.alzhan.temirlan.repositories.UserRepository;
import kz.com.alzhan.temirlan.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final AuthenticationManager authenticationManager;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    @Override
    public UserDTO createUser(UserDTO userDTO, String rawPassword) {
        UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);
        userEntity.setPassword(bCryptPasswordEncoder.encode(rawPassword));

        UserEntity savedUser = userRepository.save(userEntity);

        return modelMapper.map(savedUser, UserDTO.class);
    }

    @Override
    public UserDTO getUserById(Long id) {
        // Find user by ID or throw an exception if not found
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));

        // Map entity to DTO and return
        return modelMapper.map(userEntity, UserDTO.class);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        // Retrieve all users and map them to DTOs
        return userRepository.findAll().stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        // Find existing user by ID
        UserEntity existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));

        // Update user fields (except ID)
        existingUser.setEmail(userDTO.getEmail());
        existingUser.setName(userDTO.getName());
        existingUser.setRole(userDTO.getRole());
        existingUser.setContactInfo(userDTO.getContactInfo());
        existingUser.setActive(userDTO.isActive());

        // Save the updated entity to the database
        UserEntity updatedUser = userRepository.save(existingUser);

        // Map updated entity back to DTO and return
        return modelMapper.map(updatedUser, UserDTO.class);
    }

    @Override
    public void deleteUser(Long id) {
        // Check if the user exists and delete
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with ID: " + id);
        }
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO authenticate(String email, String password) {
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElse(null);

        if (userEntity != null && passwordEncoder.matches(password, userEntity.getPassword())) {
            // Use the builder to create UserDTO
            return UserDTO.builder()
                    .id(userEntity.getId())
                    .email(userEntity.getEmail())
                    .role(userEntity.getRole())
                    .name(userEntity.getName())
                    .contactInfo(userEntity.getContactInfo())
                    .isActive(userEntity.isActive())
                    .createdAt(userEntity.getCreatedAt())
                    .updatedAt(userEntity.getUpdatedAt())
                    .build();
        }

        return null; // Return null if authentication fails
    }

    @Override
    public String verify(LoginRequestDTO loginRequestDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequestDTO.getUsername(),
                        loginRequestDTO.getPassword()
                )
        );

        if(authentication.isAuthenticated()) {
            System.out.println(authentication.getPrincipal() + " is authenticated");
            return jwtService.generateToken(loginRequestDTO.getUsername());
        }

        System.out.println(authentication.getPrincipal() + " is not authenticated");
        return "fail";
    }

}
