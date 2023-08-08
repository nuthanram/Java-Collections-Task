package list_stream;

import java.time.LocalDate;

public class Employee {
	private int id;
	private String name;
	private String department;
	private String jobTitle;
	private int age;
	private int yearsOfExperience;
	private double salary;
	private int performanceRating;
	private LocalDate date;
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee() {
	};

	public Employee(int id, String name, String department, String jobTitle, int age, int yearsOfExperience,
			double salary, int performanceRating, int date, int month, int year, String status) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.jobTitle = jobTitle;
		this.age = age;
		this.yearsOfExperience = yearsOfExperience;
		this.salary = salary;
		this.performanceRating = performanceRating;
		this.date = LocalDate.of(year, month, date);
		this.status = status;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getPerformanceRating() {
		return performanceRating;
	}

	public void setPerformanceRating(int performanceRating) {
		this.performanceRating = performanceRating;
	}

	@Override
	public String toString() {
		return id + " " + name + " " + department + " " + jobTitle + " " + age + " " + yearsOfExperience + " " + salary
				+ " " + performanceRating + " " + date + " " + status;
	}

}
