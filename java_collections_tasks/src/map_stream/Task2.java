package map_stream;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

/*
Task 2:
Create a program that takes a map of Customer objects as input and performs the following operations:
Filter out all customers who have joined in the last 3 years and have a loyalty score less than 4, but have a balance between 2000 and 5000.
Calculate the sum of the balances of the remaining customers, but only for those who have an even age.
Find the average age of the remaining customers, but only if their country has more than 10 customers.
 */
public class Task2 {
	public static void main(String[] args) {
		Map<String, Customer> customers = CustomerUtil.readCustomers();
		Map<String, Customer> filtered = customers.entrySet().stream()
				.filter(c -> c.getValue().getDateOfJoining().isAfter(LocalDate.now().minusYears(3)))
				.filter(c -> c.getValue().getLoyaltyScore() < 4)
				.filter(c -> c.getValue().getBalance() >= 2000 && c.getValue().getBalance() <= 5000)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		// sum
		double sum = filtered.values().stream().filter(c -> c.getAge() % 2 == 0).mapToDouble(Customer::getBalance)
				.sum();
		double average = filtered.values().stream()
				.collect(Collectors.groupingBy(Customer::getCountry, Collectors.counting())).entrySet().stream()
				.filter(e -> e.getValue() > 10).mapToDouble(e -> customers.values().stream()
						.filter(c -> c.getCountry().equals(e.getKey())).mapToInt(Customer::getAge).average().orElse(0))
				.average().orElse(0);
	}
}
