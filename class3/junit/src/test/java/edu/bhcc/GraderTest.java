package edu.bhcc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraderTest {

    @Test
    void testGradeA() {
        Grader grader = new Grader();
        assertEquals("A", grader.getGrade(95));
    }

    @Test
    void testGradeF() {
        Grader grader = new Grader();
        assertEquals("F", grader.getGrade(50));
    }
}