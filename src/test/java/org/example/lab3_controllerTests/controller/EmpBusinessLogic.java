package org.example.lab3_controllerTests.controller;


import org.example.lab3_controllerTests.model.EmployeeDetails;

public class EmpBusinessLogic {

    // Calculate the yearly salary of employee
    public double calculateYearlySalary(EmployeeDetails employeeDetails) {
        double yearlySalary = 0;
        yearlySalary = employeeDetails.getMonthlySalary() * 12;
        return yearlySalary;
    }

    // Calculate the appraisal amount of employee
    public double calculateAppraisal(EmployeeDetails employeeDetails) {

        double appraisal = 0;

        if(employeeDetails.getMonthlySalary() < 10000) {
            appraisal = 500;

        } else {
            appraisal = 1000;
        }

        return appraisal;
    }
}
