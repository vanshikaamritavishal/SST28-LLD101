package models;

import enums.PaymentMethod;
import enums.PaymentStatus;

public class Payment {
    private String id;
    private double amount;
    private PaymentMethod method;
    private PaymentStatus status;

    public Payment(String id, double amount, PaymentMethod method, PaymentStatus status) {
        this.id = id;
        this.amount = amount;
        this.method = method;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public PaymentStatus getStatus() {
        return status;
    }
}