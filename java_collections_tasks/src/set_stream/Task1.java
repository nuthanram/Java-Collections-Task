package set_stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.DoubleStream;

/*
Task 1:
Write a program that takes a set of Student objects as input and performs the following operations:
Group the students by their major into a Map where the key is the major and the value is a set of students in that major, but only for majors with more than 5 students and an average GPA above 3.0.
Sort the students within each major in ascending order of their GPA, and then by their age in descending order.
Return the Map containing the grouped and sorted students.
 */
public class Task1 {
	public static void main(String[] args) {
		Set<Student> set = StudentUtil.readStudents();
		Map<String, Set<Student>> map = new HashMap();
		for (Student s : set) {
			map.computeIfAbsent(s.getMajor(), st -> new HashSet()).add(s);
		}
		Map<String, Set<Student>> group = new HashMap();
		for (Map.Entry<String, Set<Student>> entry : map.entrySet()) {
			String major = entry.getKey();
			Set<Student> students = entry.getValue();
			if (students.size() > 5 && average(students) >= 3.0) {
				List<Student> list = new ArrayList(students);
				list.sort(Comparator.comparingDouble(Student::getGpa).thenComparingDouble(Student::getAge).reversed());
				group.put(major, new LinkedHashSet(list));
			}
		}
		System.out.println(group);
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
