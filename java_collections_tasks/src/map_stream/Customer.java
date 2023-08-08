package map_stream;

import java.time.LocalDate;

public class Customer {
	private String id, name, country;
	private int age, yearsOfMembership, loyaltyScore, numberOfTransactions;
	private double balance;
	private LocalDate dateOfJoining;

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getYearsOfMembership() {
		return yearsOfMembership;
	}

	public void setYearsOfMembership(int yearsOfMembership) {
		this.yearsOfMembership = yearsOfMembership;
	}

	public int getLoyaltyScore() {
		return loyaltyScore;
	}

	public void setLoyaltyScore(int loyaltyScore) {
		this.loyaltyScore = loyaltyScore;
	}

	public int getNumberOfTransactions() {
		return numberOfTransactions;
	}

	public void setNumberOfTransactions(int numberOfTransactions) {
		this.numberOfTransactions = numberOfTransactions;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
