package com.jiangfan.sort;

/**
 * @author jiangfan
 * @version 1.0
 * @CreateTime 2022-06-10  18:06
 */
public class Student implements Comparable<Student>{
    private String username;
    private int age;

    public Student(String username, int age) {
        this.username = username;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Student o) {
        return this.age-o.age;
    }
}
