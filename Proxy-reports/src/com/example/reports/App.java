package com.example.reports;

public class App {

    public static void main(String[] args) {
        // sample users
        User admin = new User("alice", "ADMIN");
        User staff = new User("bob", "STAFF");
        User student = new User("charlie", "STUDENT");

        // proxies for different reports
        Report financeReport = new ReportProxy(
                "Finance Q1",
                "finance-report.txt",   // you can put a simple text file next to src or give full path
                "STAFF"
        );

        Report examsReport = new ReportProxy(
                "Exam Results",
                "exam-report.txt",
                "STAFF"
        );

        Report publicNotice = new ReportProxy(
                "Public Notice",
                "notice-report.txt",
                "" // no role required, everyone can see
        );

        ReportViewer viewer = new ReportViewer();

        System.out.println("---- Admin opening finance report twice ----");
        viewer.openReport(financeReport, admin);
        viewer.openReport(financeReport, admin);

        System.out.println("\n---- Student trying finance report ----");
        viewer.openReport(financeReport, student);

        System.out.println("\n---- Staff opening exams report ----");
        viewer.openReport(examsReport, staff);

        System.out.println("\n---- Everyone opening public notice ----");
        viewer.openReport(publicNotice, admin);
        viewer.openReport(publicNotice, staff);
        viewer.openReport(publicNotice, student);
    }
}
