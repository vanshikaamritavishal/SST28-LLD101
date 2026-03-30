package models;

import enums.UserRole;

public class Customer extends User {
    public Customer(String id, String name, String email) {
        super(id, name, email, UserRole.CUSTOMER);
    }
}