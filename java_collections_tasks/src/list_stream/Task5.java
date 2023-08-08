package list_stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
/*
Task 5:
Implement a program that takes a list of Employee objects as input and performs the following operations:
Filter out all employees who have less than 3 years of experience and are not in the IT department, but have a performance rating of at least 8.
Sort the remaining employees in descending order of their performance ratings, and then by their years of experience in ascending order.
Return a new list containing the names of the remaining employees, but with each name reversed, in lowercase, and suffixed with their age.
 */
public class Task5 {
	public static void main(String[] args) {
		List<Employee> list = EmployeeUtil.readEmployees();
		List<String> collect = list.stream()
				.filter(emp -> emp.getYearsOfExperience() < 3 && !emp.getDepartment().equals("IT")
						&& emp.getPerformanceRating() >= 8)
				.sorted(Comparator.comparingInt(Employee::getPerformanceRating).reversed()
						.thenComparingInt(Employee::getYearsOfExperience))
				.map(emp -> new StringBuffer(emp.getName()).reverse().toString().toLowerCase() + emp.getAge())
				.collect(Collectors.toList());
		for (String string : collect) {
			
		}
	}
}
