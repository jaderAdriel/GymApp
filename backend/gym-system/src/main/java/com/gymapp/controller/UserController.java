package com.gymapp.controller;

import com.gymapp.dtos.user.RegisterUserDTO;
import com.gymapp.entities.User;
import com.gymapp.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> newUser(@RequestBody RegisterUserDTO registerUserDTO) {
        User newUser = userService.insertUser(registerUserDTO);

        Map<String, String> content = Map.of("message", "User registered with success");

        return ResponseEntity.status(HttpStatus.CREATED.value()).body(content);
    }


    @GetMapping
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<List<User>> listUsers() {
        List<User> userList = userService.findAllUsers();

        return ResponseEntity.ok().body(userList);
    }

}
