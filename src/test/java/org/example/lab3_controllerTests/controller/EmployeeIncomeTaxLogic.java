package org.example.lab3_controllerTests.controller;

import org.example.lab3_controllerTests.model.EmployeeDetails;

public class EmployeeIncomeTaxLogic {
    public double findEmpIncomeTax(EmployeeDetails employeeDetails)
    {
        double monthlySalary =  employeeDetails.getMonthlySalary();
        double tax=0;
        System.out.println("Monthly Income is : "+ monthlySalary);
        if(monthlySalary<=20000)
            tax=0;
        else if(monthlySalary<=300000)
            tax=0.1*(monthlySalary-20000);
        else if(monthlySalary<=50000)
            tax=(0.2*(monthlySalary-30000))+(0.1*10000);
        else if(monthlySalary<=100000)
            tax=(0.3*(monthlySalary-50000))+(0.2*20000)+(0.1*10000);
        else			tax=(0.4*(monthlySalary-100000))+(0.3*50000)+(0.2*20000)+(0.1*10000);
        //System.out.println("Income tax amount is "+ tax);
        return tax;
    }
}
