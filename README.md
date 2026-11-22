\# Student Management System



\## Project Overview

The Student Management System is a Java application developed using Gradle. It stores student information, displays student details, and calculates grades based on marks.



\## Technologies Used

\- Java 21

\- Gradle 9.9.2

\- JUnit Jupiter

\- IntelliJ-independent command-line build using Gradle



\## Features

\- Store student name, roll number, and marks.

\- Display student details.

\- Calculate grades automatically.

\- Automated unit testing using JUnit Jupiter.



\## Grade Criteria



| Marks | Grade |

|---|---|

| 90–100 | A+ |

| 80–89 | A |

| 70–79 | B |

| 60–69 | C |

| Below 60 | Fail |



\## Project Structure



```text

CodeAlpha\_GradleProject/

├── app/

│   ├── src/

│   │   ├── main/java/org/example/App.java

│   │   └── test/java/org/example/AppTest.java

│   └── build.gradle.kts

├── gradle/

├── gradlew

├── gradlew.bat

└── settings.gradle.kts

```



\## How to Run



Make sure Java 21 is installed.



Build the project:



```bash

gradle build

```



Run the application:



```bash

gradle run

```



Run automated tests:



```bash

gradle test

```



\## Sample Output



```text

===== STUDENT MANAGEMENT SYSTEM =====

Student Name : Rahul

Roll Number  : 101

Marks        : 85

Grade        : A

====================================

```



\## Testing

The project includes six automated JUnit Jupiter tests covering student details and grade calculations.



\## Internship

Developed as part of the CodeAlpha DevOps Internship.



\## Author

Omkar



\## License

This project is created for educational and internship purposes.

