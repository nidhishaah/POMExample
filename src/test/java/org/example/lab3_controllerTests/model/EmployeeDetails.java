package org.example.lab3_controllerTests.model;

public class EmployeeDetails {

    private String name;
    private double monthlySalary;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // @return the monthlySalary

    public double getMonthlySalary() {
        return monthlySalary;
    }

    // @param monthlySalary the monthlySalary to set

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    // @return the age

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
