package Service;

import Model.Employee;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

public class FindEmployeeWithHighestSalaryService {
    public static Employee findEmployeeWithHighestSalary(List<Employee> staff, int year) {
        LocalDate dateToCompare = LocalDate.of(year, Month.JANUARY, 1);

        Optional<Employee> optionalEmployee = staff.stream()
                .filter(Employee -> {
                    LocalDate dateOfEmployee = LocalDate.ofInstant(Employee.getWorkStart().toInstant(), ZoneId.systemDefault());
                    int result = Integer.compare(dateToCompare.getYear(), dateOfEmployee.getYear());
                    return result == 0;
                })
                .max(((o1, o2) -> o1.getSalary().compareTo(o2.getSalary())));

        if (optionalEmployee.isPresent()) {
            return optionalEmployee.get();
        }
        return null;
    }
}
