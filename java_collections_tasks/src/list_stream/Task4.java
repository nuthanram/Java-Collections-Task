package list_stream;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/*
Task 4:
Write a program that reads a list of Employee objects from the user and performs the following operations:
Filter out all employees who have a salary greater than 150,000 and are in the Engineering department, but have joined in the last 4 years.
Calculate the square root of the sum of the salaries of the remaining employees, but only for those who have a performance rating of at least 9.
Find the employee with the closest years of experience to the square root, but only if their age is less than 40.
 */
public class Task4 {
	public static void main(String[] args) {
		List<Employee> list = EmployeeUtil.readEmployees();
		Stream<Employee> filter = list.stream().filter(emp -> emp.getSalary() > 150000
				&& emp.getDepartment().equals("Engineering") && emp.getDate().isAfter(LocalDate.now().minusYears(4)));
		double sum = filter.filter(emp -> emp.getPerformanceRating() >= 9).mapToDouble(emp -> emp.getSalary()).sum();
		double sqrt = Math.sqrt(sum);
		System.out.println("square root of salaries : " + sqrt);
		Employee closest = filter.filter(emp -> emp.getAge() < 40)
				.min(Comparator.comparingDouble(emp -> Math.abs(emp.getYearsOfExperience() - sqrt))).get();
	}
}
