package org.bootcamp.sonarlint;

public class Sonar {
    // Bug: unused variable
    private String name;

    // Code smell: empty method
    public void doSomething() {
    }

    // Bug: potential null dereference
    public int getLength(String input) {
        return input.length();
    }

    // Vulnerability: hardcoded password
    String password = "admin123";

    // Code smell: method too complex
    public String classify(int score) {
        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}