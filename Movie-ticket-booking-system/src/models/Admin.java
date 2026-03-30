package models;

import enums.UserRole;

public class Admin extends User {
    public Admin(String id, String name, String email) {
        super(id, name, email, UserRole.ADMIN);
    }
}