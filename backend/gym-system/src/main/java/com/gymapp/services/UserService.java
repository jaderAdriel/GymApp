package com.gymapp.services;

import com.gymapp.dtos.user.RegisterUserDTO;
import com.gymapp.entities.User;
import com.gymapp.entities.enums.UserRoles;
import com.gymapp.repositories.RoleRepository;
import com.gymapp.repositories.UserRepository;
import com.gymapp.services.exceptions.DuplicateResourceException;
import jakarta.validation.Valid;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.gymapp.entities.Role;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RoleRepository roleRepository;


    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.roleRepository = roleRepository;
    }

    public User insert(@RequestBody @Valid RegisterUserDTO registerUserDTO) {

        Optional<Role> userDefaultRole = roleRepository.findByName(UserRoles.STUDENT.getRole());

        User newUser = registerUserDTO.toUser();
        newUser.setPassword(bCryptPasswordEncoder.encode(registerUserDTO.getPassword()));

        userDefaultRole.ifPresent(role -> newUser.setRoles(Set.of(role)));

        try {
            return userRepository.save(newUser);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateResourceException("login " + registerUserDTO.getLogin() + " already exists!");
        }

    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
