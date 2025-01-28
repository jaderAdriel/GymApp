package com.gymapp.dtos.user;

import com.gymapp.entities.User;
import lombok.*;
import jakarta.validation.constraints.NotNull;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "username")
public class RegisterUserDTO {

    @NotNull(message = "username is required")
    String username;

    @NotNull(message = "Password is required")
    String password;

    public User toUser() {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }
}
