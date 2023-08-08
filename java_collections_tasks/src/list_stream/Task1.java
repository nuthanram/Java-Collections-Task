package list_stream;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
Task 1:
Implement a program that reads a list of Employee objects from the user and performs the following operations:
Filter out all employees who are managers and have a salary greater than 100,000, but have joined in the last 3 years.
Sort the remaining employees in descending order of their years of experience, and then by their performance ratings in ascending order.
Return a new list containing the names of the remaining employees, but with each name reversed and in uppercase.
 */
public class Task1 {
	public static void main(String[] args) {
		List<Employee> list = EmployeeUtil.readEmployees();
		List<String> names = list.stream()
				.filter(emp -> emp.getJobTitle().equals("manager") && emp.getSalary() > 100000
						&& emp.getDate().isAfter(LocalDate.now().minusYears(3)))
				.sorted(Comparator.comparingInt(Employee::getYearsOfExperience).reversed()
						.thenComparingInt(Employee::getPerformanceRating))
				.map(emp -> new StringBuilder(emp.getName()).reverse().toString().toUpperCase())
				.collect(Collectors.toList());
	}
}
