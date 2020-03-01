package com.adc;

public class Student implements Comparable<Student> {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("Student(name=%s, score=%d)", name, score);
    }

    @Override
    public int compareTo(Student another) {
        if (score < another.score) {
            return -1;
        } else if (score > another.score) {
            return 1;
        } else {
            return 0;
        }
    }
}
