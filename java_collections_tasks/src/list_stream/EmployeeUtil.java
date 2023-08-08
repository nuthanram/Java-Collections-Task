package list_stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class EmployeeUtil {
	public static List<Employee> readEmployees() {
		List<Employee> employees = new ArrayList();
		InputStreamReader r = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(r);
		int n = 1;
		for (int i = 1; i <= n; i++) {
			System.out.println("enter data in following format");
			System.out.println(
					"id - name - dept - job title - age - experience - sal - performance rating - day - month - year - work type");
			String s = null;
			try {
				s = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			String a[] = s.split(" ");
			Employee employee = new Employee(Integer.parseInt(a[0]), a[1], a[2], a[3], Integer.parseInt(a[4]),
					Integer.parseInt(a[5]), Double.parseDouble(a[6]), Integer.parseInt(a[7]), Integer.parseInt(a[8]),
					Integer.parseInt(a[9]), Integer.parseInt(a[10]), a[11]);
			employees.add(employee);
		}
		return employees;
	}
}
