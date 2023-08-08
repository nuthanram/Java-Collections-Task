package set_stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;

/*
Task 5:
Implement a program that takes a set of Student objects as input and performs the following operations:
Filter out all students who have less than 2 years of enrollment and are not majoring in Computer Science, but have a GPA of at least 3.2 and an age above 20.
Sort the remaining students in descending order of their GPA, and then by their age in ascending order.
Return a new set containing the names of the remaining students, but with each name reversed, in lowercase, suffixed with their age, and prefixed with their major code.
 */
public class Task5 {
	public static void main(String[] args) {
		Set<Student> students = StudentUtil.readStudents();
		Set<String> collect = students.stream().filter(st -> st.getYearsOfEnrollment() < 2)
				.filter(st -> !(st.getMajor().equals("Computer science"))).filter(st -> st.getGpa() >= 3.2)
				.filter(st -> st.getAge() > 20)
				.sorted(Comparator.comparingDouble(Student::getGpa).reversed().thenComparingInt(Student::getAge))
				.map(e -> e.getMajor() + new StringBuffer(e.getName()).reverse().toString().toLowerCase() + e.getAge())
				.collect(Collectors.toSet());
	}
}
