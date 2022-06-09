package org.example.lab3_controllerTests.testcases;

	import org.example.lab3_controllerTests.controller.EmpBusinessLogic;
    import org.example.lab3_controllerTests.model.EmployeeDetails;
    import org.testng.Assert;
	import org.testng.annotations.Test;
	public class TestEmployeeDetails {
		   EmpBusinessLogic empBusinessLogic = new EmpBusinessLogic();
		   EmployeeDetails employee = new EmployeeDetails();
		   @Test
	         public void testCalculateAppriasal() {
                	         employee.setName("john");
                	         employee.setAge(25);
                	         employee.setMonthlySalary(8000);
                	      double appraisal = empBusinessLogic.calculateAppraisal(employee);
                	         Assert.assertEquals(800, appraisal, 0.0, "500");
                	}
	// Test to check yearly salary
        	        @Test
	        public void testCalculateYearlySalary() {
                	        employee.setName("john");
                	        employee.setAge(25);
                employee.setMonthlySalary(3000);
                      double salary = empBusinessLogic.calculateYearlySalary(employee);
                	       Assert.assertEquals(36000, salary, 0.0, "38000");
           }

    }
