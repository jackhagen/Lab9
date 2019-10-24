package co.grandcircus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// use methods to store the menu

public class Lab9 {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);

		System.out.println("Welcome to Jack's Market! ");
		String userInput;

		Map<String, Double> map = new HashMap<>();
		List<String> items = new ArrayList<>();
		List<Double> cost = new ArrayList<>();

		boolean isValid = true;

		map.put("apples", 5.99);
		map.put("beer", 8.99);
		map.put("pineapples", 111.99);
		map.put("strawberries", 10.99);
		map.put("whatever", 500.99);
		map.put("sriracha", 13.99);
		map.put("computer", 13.99);
		map.put("sushi", 13.99);

		do {

			// print the menu
			printMenu(map);

			userInput = Validator.getString(scnr, "what item what you like?");

			if (map.keySet().contains(userInput.toLowerCase())) {
				// add key(or NAME of item to list)
				items.add(userInput);
				// add the value(or PRICE to list)
				cost.add(map.get(userInput));
			} else {
				System.out.println("Sorry, we don't have those!");

			}
			userInput = Validator.getString(scnr, "Would you like to order anything else?(y/n)");
			if (userInput.charAt(0) != 'y') {
				isValid = false;
			}

		} while (isValid);

		System.out.println("Thanks for your order");
		for (

				int i = 0; i < items.size(); i++) {
			System.out.println(items.get(i) + " $" + cost.get(i));

			int arrSize = items.size();
			double totalCost = items.size() * cost.get(i);

			System.out.println("The total cost is: " + totalCost);
			System.out.println("The average cost is: " + averageCost());

		}
		scnr.close();

	}

	private static void printMenu(Map<String, Double> map) {

		for (String itemName : map.keySet()) {
			System.out.printf("%-12s %-12.2f", itemName, map.get(itemName));
			System.out.println();
		}

	}

	public static double averageCost(double arrSize, double totalCost) {

		double averageCost = (totalCost / arrSize);
		return averageCost;

	}

}
