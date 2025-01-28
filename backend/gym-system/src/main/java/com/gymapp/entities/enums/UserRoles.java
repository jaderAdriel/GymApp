package com.gymapp.entities.enums;

public enum UserRoles {
    ADMIN("ADMIN"),
    RECEPTIONIST("RECEPTIONIST"),
    PERSONAL_TRAINER("PERSONAL_TRAINER"),
    STUDENT("STUDENT");

    final String role;

    UserRoles(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
