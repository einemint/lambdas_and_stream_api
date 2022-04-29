import Model.Employee;
import Service.FindEmployeeWithHighestSalaryService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Поиск сотрудника с максимальной зарплатой среди тех, кто пришёл в 2017 году ")
public class TestFindParseEmployeeServiceByHighestSalary {

  @Test
  @DisplayName("Входные данные - staff.txt ")
  void getEmployee() throws ParseException {
    List<Employee> staff = Employee.loadStaffFromFile();
    Date date = (new SimpleDateFormat("dd.MM.yyyy")).parse("31.01.2017");
    Employee expectedEmployee = new Employee("Дмитрий Кочергин", 140000, date);
    Employee actualEmployee = FindEmployeeWithHighestSalaryService.findEmployeeWithHighestSalary(staff, 2017);
    assertEquals(expectedEmployee, actualEmployee);
  }

}
