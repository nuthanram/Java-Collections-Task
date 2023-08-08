package set_stream;

import java.time.LocalDate;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

/*
Task 3:
Create a program that takes a set of Student objects as input and performs the following operations:
Filter out all students who have joined in the last 3 years and have a major in Mathematics, but have a GPA below 3.0 and are on academic probation.
Calculate the sum of the GPAs of the remaining students, but only for those who have an age above 22 and a GPA above the average GPA.
Find the average age of the remaining students, but only if their department has more than 10 students and an average GPA above 3.5.
Calculate the factorial of the average age, but only if the total years of enrollment of all students is greater than 30 and the average GPA is below 3.9.
 */
public class Task3 {
	public static void main(String[] args) {
		Set<Student> students = StudentUtil.readStudents();
		Set<Student> filteredStudents = students.stream()
				.filter(s -> s.getDateOfJoining().isAfter(LocalDate.now().minusYears(3)))
				.filter(s -> s.getMajor().equals("Mathematics")).filter(s -> s.getGpa() < 3.0)
				.filter(Student::isProbation).collect(Collectors.toSet());

		// Calculate sum of GPAs of students above 22 years and GPA above average
		double averageGpa = students.stream().filter(s -> s.getAge() > 22)
				.filter(s -> s.getGpa() > students.stream().mapToDouble(Student::getGpa).average().orElse(0))
				.mapToDouble(Student::getGpa).sum();

		// Find average age of students if department has more than 10 students and
		// average GPA above 3.5
		double averageAge = students.stream().filter(s -> s.getMajor().equals("Mathematics"))
				.filter(s -> students.stream().filter(st -> st.getMajor().equals("Mathematics")).count() > 10)
				.filter(s -> students.stream().filter(st -> st.getMajor().equals("Mathematics"))
						.mapToDouble(Student::getGpa).average().orElse(0) > 3.5)
				.mapToDouble(Student::getAge).average().orElse(0);

		// Calculate factorial of average age if total years of enrollment is greater
		// than 30
		// and average GPA is below 3.9
		if (students.stream().mapToInt(Student::getYearsOfEnrollment).sum() > 30
				&& students.stream().mapToDouble(Student::getGpa).average().orElse(0) < 3.9) {
			int factorial = 1;
			for (int i = 2; i <= averageAge; i++) {
				factorial *= i;
			}
			System.out.println("Factorial of average age: " + factorial);
		}

	}
}
