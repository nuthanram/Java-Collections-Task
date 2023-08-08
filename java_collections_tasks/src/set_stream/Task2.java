package set_stream;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;

/*
Task 2:
Implement a program that reads a set of Student objects from the user and performs the following operations:
Filter out all students who have a GPA less than the average GPA of all students, but have an age above 18 and a major in Biology or Chemistry.
Calculate the total years of enrollment of the remaining students, but only for those who have joined in the last 4 years and are majoring in Computer Science or Engineering.
Find the student with the highest years of enrollment and return their details, but only if they have an age below 30 and a GPA above 3.7.
 */
public class Task2 {
	public static void main(String[] args) {
		Set<Student> set = StudentUtil.readStudents();
		double average = average(set);
		Set<Student> filter = set.stream()
				.filter(st -> st.getGpa() < average && st.getAge() > 18
						&& (st.getMajor().equals("Biology") || st.getMajor().equals("chemistry")))
				.collect(Collectors.toSet());
		double sum = filter.stream()
				.filter(st -> st.getDateOfJoining().isAfter(LocalDate.now().minusYears(4))
						&& (st.getMajor().equals("computer science") || st.getMajor().equals("engineering")))
				.mapToDouble(Student::getYearsOfEnrollment).sum();
		Student maxenrollstud = filter.stream().filter(st -> st.getAge() < 30 && st.getGpa() > 3.7)
				.max(Comparator.comparingInt(Student::getYearsOfEnrollment)).get();
	}

	private static double average(Set<Student> students) {
		double sum = 0;
		int count = 0;
		for (Student student : students) {
			sum += student.getGpa();
			count++;
		}
		return sum / count;
	}
}
