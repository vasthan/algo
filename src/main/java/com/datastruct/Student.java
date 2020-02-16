package com.datastruct;

public class Student {
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

    public static void main(String[] args) {
        Array<Student> students = new Array<>();
        students.addLast(new Student("Alice", 20));
        students.addLast(new Student("Bob", 18));
        System.out.println(students);
    }
}
