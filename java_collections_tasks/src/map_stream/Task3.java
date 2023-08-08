package map_stream;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
Task 3:
Write a program that reads a map of Customer objects from the user and performs the following operations:
Filter out all customers who have a balance greater than 10000 and are from the United States, but have joined in the last 5 years.
Calculate the square root of the sum of the balances of the remaining customers, but only for those who have a loyalty score greater than 8.
Find the customer with the closest age to the square root, but only if their age is less than 40.
 */
public class Task3 {
	public static void main(String[] args) {
		Map<String, Customer> customers = CustomerUtil.readCustomers();
		List<Customer> collect = customers.values().stream().filter(c -> c.getBalance() > 10000)
				.filter(c -> c.getCountry().equals("Unites States"))
				.filter(c -> c.getDateOfJoining().isAfter(LocalDate.now().minusYears(5))).collect(Collectors.toList());
		double sqrt = Math
				.sqrt(collect.stream().filter(c -> c.getLoyaltyScore() > 8).mapToDouble(Customer::getBalance).sum());
		Customer customer = collect.stream().filter(c -> c.getAge() < 40)
				.min(Comparator.comparingDouble(e -> Math.abs(e.getAge() - sqrt))).get();
	}
}
