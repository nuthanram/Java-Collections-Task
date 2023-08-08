package set_stream;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/*
Task 4:
Write a program that reads a set of Student objects from the user and performs the following operations:
Filter out all students who have a GPA greater than 3.8 and are majoring in Biology, but have joined in the last 4 years and have a performance rating below 7.
Calculate the square root of the sum of the GPAs of the remaining students, but only for those who have an age above 30 and a GPA above 3.9.
Find the student with the closest age to the square root, but only if their major is Computer Science and they have a GPA above 4.2.
 */
public class Task4 {
	public static void main(String[] args) {
		Set<Student> students = StudentUtil.readStudents();
		// Filter students with GPA > 3.8, majoring in Biology, joined in the last 4 years, and performance rating < 7
		Set<Student> filteredStudents = students.stream().filter(s -> s.getGpa() > 3.8)
				.filter(s -> s.getMajor().equals("Biology"))
				.filter(s -> s.getDateOfJoining().isAfter(LocalDate.now().minusYears(4)))
				.filter(s -> s.getPerformanceRating() < 7).collect(Collectors.toSet());

		// Calculate square root of the sum of GPAs of students above 30 years and GPA > 3.9
		double squareRootSum = Math.sqrt(students.stream().filter(s -> s.getAge() > 30).filter(s -> s.getGpa() > 3.9)
				.mapToDouble(Student::getGpa).sum());

		// Find student with closest age to the square root if major is Computer Science and GPA > 4.2
		Optional<Student> closestStudent = students.stream().filter(s -> s.getMajor().equals("Computer Science"))
				.filter(s -> s.getGpa() > 4.2)
				.min(Comparator.comparingDouble(s -> Math.abs(s.getAge() - squareRootSum)));

		closestStudent
				.ifPresent(student -> System.out.println("Student closest to square root age: " + student.getName()));
	}
}
