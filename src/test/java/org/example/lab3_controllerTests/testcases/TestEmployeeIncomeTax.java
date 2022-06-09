package org.example.lab3_controllerTests.testcases;

import org.example.lab3_controllerTests.controller.EmployeeIncomeTaxLogic;
import org.example.lab3_controllerTests.model.EmployeeDetails;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestEmployeeIncomeTax {
    EmployeeIncomeTaxLogic empImcomeTax = new EmployeeIncomeTaxLogic();
    EmployeeDetails employee = new EmployeeDetails();
    @Test
    public void testCalculateincomeTax()
    {
        employee.setMonthlySalary(60000);
        double monthlysalary = empImcomeTax.findEmpIncomeTax(employee);
        Assert.assertEquals(4000, monthlysalary, 0.0, "60000");
    }
}
