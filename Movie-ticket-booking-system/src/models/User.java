package models;

import enums.UserRole;

public abstract class User {
    protected String id;
    protected String name;
    protected String email;
    protected UserRole role;

    public User(String id, String name, String email, UserRole role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public UserRole getRole() {
        return role;
    }
}