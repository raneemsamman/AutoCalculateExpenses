/**
* SplitExpenses.java
* @description performs calculations of individual weighted expenses when sharing a meal or any expense
* author R Samman
* version 2.0 28-12-2023
*/

import java.util.Scanner;

public class SplitExpenses {

    private int numberOfPeople;
    private String[] names;
    private double[] percentages;
    private double totalAmount;
    private Scanner scanner = new Scanner(System.in);

/** constructor  **/
    public SplitExpenses() {}
/** gets user's input */
    public void getInput() {
        System.out.println("Enter the total amount of money spent: ");
        totalAmount = scanner.nextDouble();

        System.out.println("Enter the number of people who shared the meal: ");
        numberOfPeople = scanner.nextInt();

        scanner.nextLine(); 

        names = new String[numberOfPeople];
        percentages = new double[numberOfPeople];

        // Get names and percentages
        for (int i = 0; i < numberOfPeople; i++) {
            System.out.println("Enter the name of person " + (i + 1) + ": ");
            names[i] = scanner.nextLine();

            System.out.println("Enter the percentage of how much " + names[i] + " ate: ");
            percentages[i] = scanner.nextDouble();

            if (i < numberOfPeople - 1) {
                scanner.nextLine();
            }
        }
    }
//* calculates weighted expenses */
    public void calculateExpenses() {
        System.out.println("\nIndividual total expenses:");

        for (int i = 0; i < numberOfPeople; i++) {
            double individualExpense = (percentages[i] / 100) * totalAmount;
            System.out.println(names[i] + ": $" + individualExpense);
        }
    }
 //* main method */
    public static void main(String[] args) {
        SplitExpenses expensesCalculator = new SplitExpenses();
        expensesCalculator.getInput();
        expensesCalculator.calculateExpenses();
    }
}
