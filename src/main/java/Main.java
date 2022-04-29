import Model.Employee;
import Service.FindEmployeeWithHighestSalaryService;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile();
        Employee employeeMaxSalary = FindEmployeeWithHighestSalaryService.findEmployeeWithHighestSalary(staff, 2017);

        System.out.println(employeeMaxSalary);
    }
}