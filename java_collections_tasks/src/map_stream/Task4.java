package map_stream;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
Task 4:
Implement a program that takes a map of Customer objects as input and performs the following operations:
Filter out all customers who have less than 2 years of membership and a balance less than 1000, but have made more than 10 transactions.
Sort the remaining customers in descending order of their loyalty scores, and then by their ages in ascending order.
Return a new map containing the customer IDs as keys and their names as values, but with each name reversed, in lowercase, and suffixed with their country code.
 */
public class Task4 {
	public static void main(String[] args) {
		Map<String, Customer> customers = CustomerUtil.readCustomers();
		customers.values().stream().filter(c -> c.getYearsOfMembership() < 2).filter(c -> c.getBalance() < 1000)
				.filter(c -> c.getNumberOfTransactions() > 10)
				.sorted(Comparator.comparingInt(Customer::getLoyaltyScore).reversed()
						.thenComparingInt(Customer::getAge))
				.collect(Collectors.toMap(Function.identity(), Customer::getId, (K1, K2) -> K1, LinkedHashMap::new));
//		LinkedHashMap<String, String> idNames = new LinkedHashMap<>();
//		for (Customer customer : filteredAndSorted) {
//			idNames.put(customer.getId(), new StringBuffer(customer.getName()).reverse().toString().toLowerCase()
//					+ (customer.getCountry().substring(0, 3)));
//		}
	}
}
