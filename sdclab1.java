package ArithmeticSystem;

import java.util.Scanner;

public class ArithmeticSystem {

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero");
            return Double.NaN; // Return NaN to indicate an error
        }
        return a / b;
    }

    public static void main(String[] args) {
        ArithmeticSystem calculator = new ArithmeticSystem();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Arithmetic System!");

        while (true) {
            System.out.println("\nSelect an operation:");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();

            if (choice == 5) {
                System.out.println("Exiting the system. Goodbye!");
                break;
            }

            if (choice >= 1 && choice <= 4) {
                System.out.print("Enter first number: ");
                double num1 = scanner.nextDouble();
                System.out.print("Enter second number: ");
                double num2 = scanner.nextDouble();
                
                double result = 0;
                switch (choice) {
                    case 1:
                        result = calculator.add(num1, num2);
                        System.out.println("Addition result: " + result);
                        break;
                    case 2:
                        result = calculator.subtract(num1, num2);
                        System.out.println("Subtraction result: " + result);
                        break;
                    case 3:
                        result = calculator.multiply(num1, num2);
                        System.out.println("Multiplication result: " + result);
                        break;
                    case 4:
                        result = calculator.divide(num1, num2);
                        if (!Double.isNaN(result)) {
                            System.out.println("Division result: " + result);
                        }
                        break;
                }
            } else {
                System.out.println("Invalid input, please try again.");
            }
        }

        scanner.close();
    }
}
