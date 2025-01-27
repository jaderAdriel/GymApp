package com.gymapp.entities.enums;

public enum UserRoles {
    ADMIN(1L),
    RECEPTIONIST(2L),
    PERSONAL_TRAINER(3L),
    STUDENT(4L);

    final long roleId;

    UserRoles(long roleId) {
        this.roleId = roleId;
    }

    public long getRoleId() {
        return roleId;
    }
}
