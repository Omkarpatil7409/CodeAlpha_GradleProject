
# DevOps Incident Tracker

A Java-based console application that helps users report, track, search, and manage DevOps incidents.

## Project Overview

The DevOps Incident Tracker is developed using Java 21 and Gradle. It provides a simple way to record incidents, monitor their severity, and update their status.

Incident records are stored in a local text file so that data remains available after restarting the application.

## Features

- Report new incidents
- View all reported incidents
- Search incidents by ID
- Update incident status
- Assign incident severity
- Validate severity and status inputs
- Automatically generate incident IDs
- Save and load incident records
- Automated testing using JUnit 5

## Technologies Used

- Java 21
- Gradle 9.9.2
- JUnit 5
- Git and GitHub
- GitHub Actions

## Project Structure

```text
CodeAlpha_GradleProject/
├── .github/
│   └── workflows/
│       └── gradle.yml
├── app/
│   ├── src/
│   │   ├── main/java/org/example/
│   │   │   └── App.java
│   │   └── test/java/org/example/
│   │       └── AppTest.java
│   └── build.gradle.kts
├── gradle/
├── gradlew
├── gradlew.bat
├── settings.gradle.kts
└── README.md
```

## How to Run

### 1. Clone the repository

```bash
git clone https://github.com/Omkarpatil7409/CodeAlpha_GradleProject.git
```

### 2. Open the project directory

```powershell
cd CodeAlpha_GradleProject
```

### 3. Run the application

On Windows PowerShell:

```powershell
.\gradlew.bat :app:run
```

### 4. Run automated tests

```powershell
.\gradlew.bat test
```

### 5. Build the project

```powershell
.\gradlew.bat build
```

## Incident Severity Levels

- Low
- Medium
- High
- Critical

## Incident Status

- Open
- In Progress
- Resolved

## CI/CD Integration

This project uses GitHub Actions to automatically build and test the application whenever changes are pushed to the main branch or a pull request is created.

## Data Storage

Incident records are saved in a local file named `incidents.txt`. The application loads previously saved incidents when it starts.

## Internship Project

Developed as part of the CodeAlpha DevOps Internship.

## Author

Omkar

GitHub: https://github.com/Omkarpatil7409
