package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Incident> incidents = new ArrayList<>();
    private static final String FILE_NAME = "incidents.txt";

    private static int nextId = 1;

    static class Incident {
        int id;
        String title;
        String description;
        String severity;
        String status;

        Incident(int id, String title, String description,
                 String severity, String status) {
            this.id = id;
            this.title = title;
            this.description = description;
            this.severity = severity;
            this.status = status;
        }

        void display() {
            System.out.println("\nIncident ID: " + id);
            System.out.println("Title      : " + title);
            System.out.println("Description: " + description);
            System.out.println("Severity   : " + severity);
            System.out.println("Status     : " + status);
            System.out.println("------------------------------");
        }
    }

    public static void main(String[] args) {

        loadIncidents();

        while (true) {
            System.out.println("\n===== DEVOPS INCIDENT TRACKER =====");
            System.out.println("1. Report New Incident");
            System.out.println("2. View All Incidents");
            System.out.println("3. Update Incident Status");
            System.out.println("4. Search Incident");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    reportIncident();
                    break;
                case "2":
                    viewIncidents();
                    break;
                case "3":
                    updateStatus();
                    break;
                case "4":
                    searchIncident();
                    break;
                case "5":
                    saveIncidents();
                    System.out.println("Thank you for using Incident Tracker!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    static boolean isValidSeverity(String severity) {
        return severity.equalsIgnoreCase("Low")
                || severity.equalsIgnoreCase("Medium")
                || severity.equalsIgnoreCase("High")
                || severity.equalsIgnoreCase("Critical");
    }

    static boolean isValidStatus(String status) {
        return status.equalsIgnoreCase("Open")
                || status.equalsIgnoreCase("In Progress")
                || status.equalsIgnoreCase("Resolved");
    }

    private static void reportIncident() {

        System.out.print("Enter incident title: ");
        String title = scanner.nextLine().trim();

        System.out.print("Enter description: ");
        String description = scanner.nextLine().trim();

        if (title.isEmpty() || description.isEmpty()
                || title.contains("|") || description.contains("|")) {
            System.out.println("Title and description must be valid and non-empty.");
            return;
        }

        System.out.print("Enter severity (Low/Medium/High/Critical): ");
        String severity = scanner.nextLine().trim();

        if (!isValidSeverity(severity)) {
            System.out.println("Invalid severity. Incident not created.");
            return;
        }

        severity = severity.substring(0, 1).toUpperCase()
                + severity.substring(1).toLowerCase();

        Incident incident = new Incident(
                nextId++, title, description, severity, "Open");

        incidents.add(incident);
        saveIncidents();

        System.out.println("Incident reported successfully!");
        System.out.println("Assigned Incident ID: " + incident.id);
    }

    private static void viewIncidents() {

        if (incidents.isEmpty()) {
            System.out.println("No incidents found.");
            return;
        }

        for (Incident incident : incidents) {
            incident.display();
        }
    }

    private static void updateStatus() {

        System.out.print("Enter incident ID: ");
        int id = readId();

        Incident incident = findById(id);

        if (incident == null) {
            System.out.println("Incident not found.");
            return;
        }

        System.out.print("Enter new status (Open/In Progress/Resolved): ");
        String status = scanner.nextLine().trim();

        if (!isValidStatus(status)) {
            System.out.println("Invalid status.");
            return;
        }

        if (status.equalsIgnoreCase("In Progress")) {
            incident.status = "In Progress";
        } else {
            incident.status = status.substring(0, 1).toUpperCase()
                    + status.substring(1).toLowerCase();
        }

        saveIncidents();
        System.out.println("Incident status updated successfully!");
    }

    private static void searchIncident() {

        System.out.print("Enter incident ID to search: ");
        int id = readId();

        Incident incident = findById(id);

        if (incident == null) {
            System.out.println("Incident not found.");
        } else {
            incident.display();
        }
    }

    private static int readId() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static Incident findById(int id) {

        for (Incident incident : incidents) {
            if (incident.id == id) {
                return incident;
            }
        }

        return null;
    }

    private static void saveIncidents() {

        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {

            for (Incident incident : incidents) {
                writer.println(incident.id + "|"
                        + incident.title + "|"
                        + incident.description + "|"
                        + incident.severity + "|"
                        + incident.status);
            }

        } catch (IOException e) {
            System.out.println("Error saving incidents: " + e.getMessage());
        }
    }

    private static void loadIncidents() {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split("\\|", -1);

                if (data.length == 5) {
                    try {
                        int id = Integer.parseInt(data[0]);

                        Incident incident = new Incident(
                                id, data[1], data[2], data[3], data[4]);

                        incidents.add(incident);
                        nextId = Math.max(nextId, id + 1);

                    } catch (NumberFormatException e) {
                        System.out.println("Skipping invalid incident record.");
                    }
                }
            }

            System.out.println("Saved incidents loaded successfully.");

        } catch (IOException e) {
            System.out.println("Error loading incidents: " + e.getMessage());
        }
    }
}