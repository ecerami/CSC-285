package edu.bhcc;

/**
 * A Grader Utility.
 */
public class Grader {

    /**
     * Given a value, return the letter grade.
     */
    public String getGrade(int numberGrade) {
        if (numberGrade < 60) {
            return "F";
        } else if (numberGrade < 70) {
            return "D";
        } else if (numberGrade < 80) {
            return "C";
        } else if (numberGrade < 90) {
            return "B";
        }
        return "A";
    }
}

