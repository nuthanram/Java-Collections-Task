package map_stream;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

/*
Task 1:
Implement a program that reads a map of Customer objects from the user and performs the following operations:
Filter out all customers who have a balance less than the average balance of all customers.
Calculate the total years of membership of the remaining customers.
Find the customer with the highest years of membership and return their details.
 */
public class Task1 {
	public static void main(String[] args) {
		Map<String, Customer> customers = CustomerUtil.readCustomers();
		double average = customers.values().stream().mapToDouble(Customer::getBalance).average().orElse(0);
		Map<String, Customer> filtered = customers.entrySet().stream().filter(e -> e.getValue().getBalance() >= average)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		int sum = filtered.values().stream().mapToInt(Customer::getYearsOfMembership).sum();
		Customer customer = filtered.values().stream().max(Comparator.comparingInt(Customer::getYearsOfMembership))
				.get();
	}
}
