package set_stream;

import java.time.LocalDate;

public class Student {
	private String name;
	private String major;
	private int age;
	private int yearsOfEnrollment;
	private double gpa;
	private int numberOfIncompleteCourses;
	private LocalDate dateOfJoining;
	private Department department;
	private boolean probation;
	private double performanceRating;

	public double getPerformanceRating() {
		return performanceRating;
	}

	public void setPerformanceRating(double performanceRating) {
		this.performanceRating = performanceRating;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public boolean isProbation() {
		return probation;
	}

	public void setProbation(boolean probation) {
		this.probation = probation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getYearsOfEnrollment() {
		return yearsOfEnrollment;
	}

	public void setYearsOfEnrollment(int yearsOfEnrollment) {
		this.yearsOfEnrollment = yearsOfEnrollment;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public int getNumberOfIncompleteCourses() {
		return numberOfIncompleteCourses;
	}

	public void setNumberOfIncompleteCourses(int numberOfIncompleteCourses) {
		this.numberOfIncompleteCourses = numberOfIncompleteCourses;
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public Student(String name, String major, int age, int yearsOfEnrollment, double gpa, int numberOfIncompleteCourses,
			int date, int month, int year) {
		super();
		this.name = name;
		this.major = major;
		this.age = age;
		this.yearsOfEnrollment = yearsOfEnrollment;
		this.gpa = gpa;
		this.numberOfIncompleteCourses = numberOfIncompleteCourses;
		this.dateOfJoining = LocalDate.of(year, month, date);
	}

	public Student() {
	}

	@Override
	public String toString() {
		return name + " " + major + " " + age + " " + yearsOfEnrollment + " " + gpa + " " + numberOfIncompleteCourses
				+ " " + dateOfJoining;
	}
}
