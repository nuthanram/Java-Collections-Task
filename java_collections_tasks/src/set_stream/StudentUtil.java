package set_stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class StudentUtil {
	public static Set<Student> readStudents() {
		Set<Student> students = new HashSet<>();
		InputStreamReader r = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(r);
		int n = 1;
		for (int i = 1; i <= n; i++) {
			System.out.println("enter data in following format");
			System.out.println(
					"name - major - age - years of enrollment - gpa - number of incomplete courses - date - month - year");
			String s = null;
			try {
				s = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			String a[] = s.split(" ");
			Student student = new Student(a[0], a[1], Integer.parseInt(a[2]), Integer.parseInt(a[3]),
					Double.parseDouble(a[4]), Integer.parseInt(a[5]), Integer.parseInt(a[6]), Integer.parseInt(a[7]),
					Integer.parseInt(a[8]));
			students.add(student);
		}
		return students;
	}
}
