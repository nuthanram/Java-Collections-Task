package list_stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Task 3:
Write a program that reads a list of Employee objects from the user and performs the following operations:
Remove all employees who are part-time and have a salary less than 50,000, but are in the Sales or Marketing department.
Calculate the sum of the salaries of the remaining employees, but only for those who have more than 3 years of experience.
Find the average age of the remaining employees, but only for those who have a performance rating of at least 7.
 */
public class Task3 {
	public static void main(String[] args) {
		List<Employee> list = EmployeeUtil.readEmployees();
		List<Employee> filter = list.stream()
				.filter(emp -> emp.getStatus().equals("part-time") && emp.getSalary() < 50000
						&& (emp.getDepartment().equals("sales") || emp.getDepartment().equals("marketing")))
				.collect(Collectors.toList());
		double sum = 0;
		for (Employee e : filter) {
			if (e.getYearsOfExperience() > 3)
				sum = sum + e.getSalary();
		}
		System.out.println("average sum :" + sum);
		double ageSum = 0;
		int c = 0;
		for (Employee e : filter) {
			if (e.getPerformanceRating() >= 7) {
				ageSum += e.getAge();
				c++;
			}
		}
		double average = ageSum / c;
		System.out.println("average age :" + average);

	}
}
