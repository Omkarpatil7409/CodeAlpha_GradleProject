
package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void shouldStoreStudentDetails() {
        App student = new App("Rahul", 101, 85);

        assertEquals("Rahul", student.getStudentName());
        assertEquals(101, student.getRollNumber());
        assertEquals(85, student.getMarks());
    }

    @Test
    void shouldCalculateGradeAPlus() {
        App student = new App("Rahul", 101, 95);

        assertEquals("A+", student.calculateGrade());
    }

    @Test
    void shouldCalculateGradeA() {
        App student = new App("Rahul", 101, 85);

        assertEquals("A", student.calculateGrade());
    }

    @Test
    void shouldCalculateGradeB() {
        App student = new App("Rahul", 101, 75);

        assertEquals("B", student.calculateGrade());
    }

    @Test
    void shouldCalculateGradeC() {
        App student = new App("Rahul", 101, 65);

        assertEquals("C", student.calculateGrade());
    }

    @Test
    void shouldCalculateFailGrade() {
        App student = new App("Rahul", 101, 40);

        assertEquals("Fail", student.calculateGrade());
    }
}
