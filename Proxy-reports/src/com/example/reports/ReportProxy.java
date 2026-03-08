package com.example.reports;

public class ReportProxy implements Report {

    private final String name;
    private final String filePath;
    private final String requiredRole;

    private RealReport realReport; // lazily created

    public ReportProxy(String name, String filePath, String requiredRole) {
        this.name = name;
        this.filePath = filePath;
        this.requiredRole = requiredRole;
    }

    @Override
    public void display(User user) {
        System.out.println("[Proxy] User " + user + " requested report: " + name);

        if (!isAuthorized(user)) {
            System.out.println("[Proxy] ACCESS DENIED to report '" + name + "' for user " + user);
            return;
        }

        if (realReport == null) {
            System.out.println("[Proxy] Access granted. Lazy-loading real report for '" + name + "'.");
            realReport = new RealReport(filePath);
        } else {
            System.out.println("[Proxy] Access granted. Using cached real report for '" + name + "'.");
        }

        realReport.display(user);
    }

    private boolean isAuthorized(User user) {
        if (requiredRole == null || requiredRole.isEmpty()) {
            return true;
        }
        // simple rule: if user has the requiredRole or is ADMIN, allow
        if ("ADMIN".equalsIgnoreCase(user.getRole())) {
            return true;
        }
        return requiredRole.equalsIgnoreCase(user.getRole());
    }
}
