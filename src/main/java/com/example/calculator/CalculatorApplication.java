package com.example.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class CalculatorApplication {


	public static void main(String[] args) {
		SpringApplication.run(CalculatorApplication.class, args);
		Scanner inputReader = new Scanner(System.in);

		while (true) {
			displayMenu();
			try {
				int operation = inputReader.nextInt();
				performOperation(operation, inputReader);
			} catch (Exception e) {
				System.out.println("An error occurred. Please enter valid input.");
				inputReader.nextLine(); // to clear the buffer
			}
		}
	}

	private static void displayMenu() {
		System.out.println("\nAdvanced Math Operations:");
		System.out.println("1. Add");
		System.out.println("2. Subtract");
		System.out.println("3. Multiply");
		System.out.println("4. Divide");
		System.out.println("5. Root");
		System.out.println("6. Calculate Factorial");
		System.out.println("7. Logarithm");
		System.out.println("8. Exponentiate");
		System.out.println("9. Quit");
		System.out.print("Select an option: ");
	}

	private static void performOperation(int choice, Scanner scanner) {
		System.out.println("Enter your number(s): ");
		double result = 0;
		boolean isUnaryOperation = choice == 5 || choice == 6 || choice == 7;

		if (isUnaryOperation) {
			double num = scanner.nextDouble();
			result = switch (choice) {
				case 5 -> root(num);
				case 6 -> factorial((int) num);
				case 7 -> log(num);
				default -> result;
			};
		} else if (choice >= 1 && choice <= 4 || choice == 8) {
			double num1 = scanner.nextDouble();
			double num2 = scanner.nextDouble();
			result = switch (choice) {
				case 1 -> add(num1, num2);
				case 2 -> subtract(num1, num2);
				case 3 -> multiply(num1, num2);
				case 4 -> divide(num1, num2);
				case 8 -> exponent(num1, num2);
				default -> result;
			};
		} else if (choice == 9) {
			System.out.println("Calculator closing...");
			scanner.close();
			System.exit(0);
		} else {
			System.out.println("Please select a valid option.");
		}
		System.out.println("Result: " + result);
	}

	public static double add(double num1, double num2) {
		return num1 + num2;
	}

	public static double subtract(double num1, double num2) {
		return num1 - num2;
	}

	public static double multiply(double num1, double num2) {
		return num1 * num2;
	}

	public static double divide(double num1, double num2) {
		if (num2 == 0) {
			System.out.println("Cannot divide by zero.");
			return Double.NaN;
		}
		return num1 / num2;
	}

	public static double root(double num) {
		return Math.sqrt(num);
	}

	public static double factorial(int number) {
		if (number < 0) {
			System.out.println("Factorial of a negative number is not defined.");
			return Double.NaN;
		}
		double result = 1;
		for (int i = 2; i <= number; i++) {
			result *= i;
		}
		return result;
	}

	public static double log(double num) {
		return Math.log(num);
	}

	public static double exponent(double base, double exponent) {
		return Math.pow(base, exponent);
	}
}
