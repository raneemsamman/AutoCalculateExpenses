/**
* DinnerOut.java
* @description performs calculations of total contributions for people's orders
* author R Samman
* version 3.0 02-10-2022
*/

import java.util.Scanner;

public class DinnerOut{

// ---- attributes ----
private int n; // number of people in the dinner
private String[] persons = new String[] {"first person", "second person",
              "third person", "fourth person", "fifth person", "sixth person"};
private double [] amounts = new double[6];
private double tip, tax;
private double [] totalPrice = new double[6];
private Scanner scan = new Scanner(System.in);

// ---- methods ----
/** constructor */
public DinnerOut(){}

// asks user for the number of invitees and their names
public void ask(){
  System.out.println("Hello! How many people are you inviting to the party?");
    n = scan.nextInt();
    if (n > 6){
      System.out.println("Sorry. The maximum number of invitations is 6.");
      n=6;
      scan.nextLine();
      for (int i=0; i <n; i++){
      System.out.println("Enter the name of " + persons[i] + ": ");
      persons[i] = scan.nextLine(); }

    }else{
      scan.nextLine();
      //Ricardo Salazar suggested adding a scanner object here
      for (int i=0; i <n; i++){
      System.out.println("Enter the name of " + persons[i] + ": ");
      persons[i] = scan.nextLine(); }  //taking input as a string
        }
}
// asks for each individual's orders' value up until they enter 0
public void order(){
  double price;
  double onePersonTotal;
  for (int i=0; i<n; i++){ //Ricardo Salazar, a friend of mine, helped me set the parameters
    price = 1.0;
    onePersonTotal = 1.0;
    while(price!=0){
      System.out.println("Enter the costs for " + persons[i] +"'s food (or type 0 to move on): ");
      price = scan.nextDouble();
      onePersonTotal += price;
    }
    amounts[i] = onePersonTotal;
    onePersonTotal = 0.0;
    //Malek Alaghel suggested adding an intial value for the onepersontotal costs variable
    }
    }
// setter for taxes
public void setTax(){
  System.out.println("Enter the rate of tax as a decimal (eg: for 10%, enter 0.10):");
  tax = scan.nextDouble();
}
// setter for tips
public void setTip(){
  System.out.println("Enter the rate of tip as a decimal (eg: for 10%, enter 0.10):");
  tip = scan.nextDouble();
}
//calculates the total price for each person with taxes and tips
public void total(){
  for (int i=0; i <6; i++){
    totalPrice[i] += tax*amounts[i] + tip*amounts[i] + amounts[i];
  }
}
// creates and prints information as strings/sentences
public String toString(){
  String s="";
  for (int i=0; i <n; i++){
  s += "\nHere is the total for: \n";
  s+= persons[i] + ": $" + totalPrice[i] +"USD\n"; }
  return s;
  }
public static void main(String[] args) {
  DinnerOut customer = new DinnerOut();
  customer.ask();
  customer.order();
  customer.setTax();
  customer.setTip();
  customer.total();
  System.out.println(customer.toString());
  }
}
