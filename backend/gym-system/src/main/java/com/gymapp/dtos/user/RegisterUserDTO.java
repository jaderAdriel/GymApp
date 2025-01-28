package com.gymapp.dtos.user;

import com.gymapp.entities.User;
import lombok.*;
import jakarta.validation.constraints.NotNull;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class RegisterUserDTO {

    @NotNull(message = "Name is required")
    String name;

    @NotNull(message = "username is required")
    String email;

    @NotNull(message = "username is required")
    String login;

    @NotNull(message = "Password is required")
    String password;

    public User toUser() {
        User user = new User();
        user.setEmail(email);
        user.setName(email);
        user.setLogin(login);
        user.setPassword(password);
        return user;
    }
}
