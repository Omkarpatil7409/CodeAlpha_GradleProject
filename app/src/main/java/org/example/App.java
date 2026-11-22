
package org.example;

public class App {

    private String studentName;
    private int rollNumber;
    private int marks;

    public App(String studentName, int rollNumber, int marks) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public int getMarks() {
        return marks;
    }

    public String calculateGrade() {
        if (marks >= 90) {
            return "A+";
        } else if (marks >= 80) {
            return "A";
        } else if (marks >= 70) {
            return "B";
        } else if (marks >= 60) {
            return "C";
        } else {
            return "Fail";
        }
    }

    public void displayStudentDetails() {
        System.out.println("===== STUDENT MANAGEMENT SYSTEM =====");
        System.out.println("Student Name : " + studentName);
        System.out.println("Roll Number  : " + rollNumber);
        System.out.println("Marks        : " + marks);
        System.out.println("Grade        : " + calculateGrade());
        System.out.println("====================================");
    }

    public static void main(String[] args) {
        App student = new App("Rahul", 101, 85);
        student.displayStudentDetails();
    }
}
