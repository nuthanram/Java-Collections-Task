package list_stream;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
 Task 2:
Create a program that takes a list of Employee objects as input and performs the following operations:
Filter out all employees who have joined in the last 5 years and have a performance rating of less than 8, but have a salary between 60,000 and 120,000.
Sort the remaining employees in ascending order of their salaries, and then by their years of experience in descending order.
Return a new list containing the IDs of the remaining employees, but with each ID multiplied by 10.
 */
public class Task2 {
	public static void main(String[] args) {
		List<Employee> list = EmployeeUtil.readEmployees();
		List<Integer> collect = list.stream()
				.filter(emp -> emp.getDate().isAfter(LocalDate.now().minusYears(5)) && emp.getPerformanceRating() < 8
						&& emp.getSalary() > 60000 && emp.getSalary() < 120000)
				.sorted(Comparator.comparingDouble(Employee::getSalary)
						.thenComparingDouble(Employee::getYearsOfExperience).reversed())
				.map(emp -> emp.getId() * 10).collect(Collectors.toList());
	}
}
