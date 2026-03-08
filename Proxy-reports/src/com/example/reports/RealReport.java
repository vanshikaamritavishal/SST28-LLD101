package com.example.reports;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RealReport implements Report {

    private final String filePath;
    private String content;

    public RealReport(String filePath) {
        this.filePath = filePath;
        loadFromFile(); // expensive operation
    }

    private void loadFromFile() {
        System.out.println("[RealReport] Loading report from file: " + filePath);
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            sb.append("[ERROR reading file: ").append(e.getMessage()).append("]");
        }
        this.content = sb.toString();
    }

    @Override
    public void display(User user) {
        System.out.println("=== Report for " + user.getUsername() + " ===");
        System.out.println(content);
        System.out.println("=======================================");
    }
}
