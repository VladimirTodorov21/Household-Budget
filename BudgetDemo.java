/*This program runs a Householdbugdet application*/

package assignment4;

import java.util.Scanner; //class needs to import Scanner

public class BudgetDemo {
	
	public static void main(String[] args) {
		
		/*Scanner Input declared*/
		Scanner Input = new Scanner(System.in);
		
		/*5 Hard-coded Household Budgets */
		HouseholdBudget[] Houses = new HouseholdBudget[5]; //Houses Array declared as a Household budget array and initializes to 5 contents within the array
		
		/*Here is the following format for the five household budgets:
		 * 1. House#Fund Instance of Fund Constructor with 5 Integer Parameters declared and initialized
		 * 2. House#Expense# Instance of Expense Constructor with 5 Parameters declared and initialized
		 * ------The Household can have many expense instances or none at all-------
		 * 3. ExpenseHouse# as an array of Expense puts the content of the previously declared and initialized House#Expense# (there can be none, 1, or many of them in the array)
		 * 4. House# Instance of HouseholdBudget Constructor with 2 Parameters of type Fund and array Expense declared*/
		
		Fund House0Fund = new Fund(0,1,0,2,1);
		Expense House0Expense1 = new Expense("Purchase","IGA",85.5,25,11);
		Expense House0Expense2 = new Expense("Bill","Videotron",122.75,2,12);
		Expense[] ExpenseHouse0 = {House0Expense1,House0Expense2};
		HouseholdBudget House0 = new HouseholdBudget(House0Fund,ExpenseHouse0);
		
		Fund House1Fund = new Fund(0,1,0,2,1);
		Expense House1Expense1 = new Expense("Purchase","IGA",85.5,25,11);
		Expense House1Expense2 = new Expense("Bill","Costco",16.2,23,11);
		Expense[] ExpenseHouse1 = {House1Expense1,House1Expense2};
		HouseholdBudget House1 = new HouseholdBudget(House1Fund,ExpenseHouse1);
		
		Fund House2Fund = new Fund(2,0,2,1,1);
		Expense House2Expense1 = new Expense("Purchase","Pharmaprix",50.75,1,12);
		Expense House2Expense2 = new Expense("Purchase","TheBay",16.2,16,12);
		Expense House2Expense3 = new Expense("Bill","Fido",65.85,5,1);
		Expense[] ExpenseHouse2 = {House2Expense1,House2Expense2,House2Expense3};
		HouseholdBudget House2 = new HouseholdBudget(House2Fund,ExpenseHouse2);
		
		Fund House3Fund = new Fund(2,1,2,1,5);
		Expense[] ExpenseHouse3 = {};
		HouseholdBudget House3 = new HouseholdBudget(House3Fund,ExpenseHouse3);
		
		Fund House4Fund = new Fund(2,1,2,1,5);
		Expense[] ExpenseHouse4 = {};
		HouseholdBudget House4 = new HouseholdBudget(House4Fund,ExpenseHouse4);
		
		/*The content of the index in the array Houses becomes the content of the specific House#*/
		Houses[0] = House0;
		Houses[1] = House1;
		Houses[2] = House2;
		Houses[3] = House3;
		Houses[4] = House4;
		
		/*Welcomes user*/
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		
		System.out.println("Welcome to COMP248 Geek's HouseholdBudget_2022 Application\n");
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		
		boolean AnswerValidity = true; //AnswerValidity declared and is necessary for the condition in the loop below
		
		/*while loop*/
		while (AnswerValidity == true) {
			
			/*Displays a list of options that the user may choose from and each executes a specific task*/
			System.out.println("\nWhat would you like to do?");
			System.out.println("  1. See the possessions of all householdBudgets");
			System.out.println("  2. See the possessions of one householdBudget");
			System.out.println("  3. List householdBudgets with same total amount of fund");
			System.out.println("  4. List householdBudgets with same fund denomination(s)");
			System.out.println("  5. List householdBudgets with same total amount of fund and same number of expenses");
			System.out.println("  6. Add an expense to an existing householdBudget");
			System.out.println("  7. Remove an existing expense from a householdBudget");
			System.out.println("  8. Update the payment due date of an existing expense");
			System.out.println("  9. Add fund to a householdBudget");
			System.out.println("  0. To quit\n");
			
			System.out.print("Please enter your choice and press <Enter>:"); //prompts the user to enter an integer
			
			int IntegerInput = Input.nextInt(); //input from Input scanner as an integer
			
			/*Displays an error message if the user does enter a valid number between 0 and 9 (including those numbers limiting the bound)*/
			if (IntegerInput < 0 || IntegerInput > 9) {
				System.out.println("Sorry that is not a valid choice. Try again."); //error message
				continue; //does not break out of loop but redisplays list after error
			}
			
			/*switch that uses the input from the IntegerInput above*/
			switch(IntegerInput) {
				case 0: 
					System.out.println("Thank you for using COMP248 Geek's HouseholdBudget application!"); //thanks the user and ends the program
					
					AnswerValidity = false; //boolean set to false which allows the program to exit the while loop and terminate the application
					break;
					
				case 1:
					/*Display of format for content of each Household Budget*/
					System.out.println("\nContent of each HouseholdBudget:");
					System.out.println("---------------------");
					
					/*for loop that print the content of each household budget*/
					for (int i = 0; i < Houses.length; i++) {
						System.out.println("HouseholdBudget #" + i + ":"); //displays household budget number
						System.out.println(Houses[i]); //displays content of array Houses at the index in the for loop
					}
					break;
					
				case 2:
					System.out.print("Which HouseholdBudget you want to see the possessions of? (Enter number 0 to 4): "); //prompts user to enter a valid integer
					
					int HouseNumber = Input.nextInt(); //input from Input scanner as an integer
					
					/*Error will keep popping up until the user input a valid integer within the restrictions stated*/
					while (HouseNumber < 0 || HouseNumber > 4) {
						System.out.println("\nSorry but there is no HouseholdBudget number " + HouseNumber); //error message
						System.out.print("--> Try again: (Enter number 0 to 4): "); //prompts user to try inputting an integer again
						
						HouseNumber = Input.nextInt(); //allows user to input integer again
					}
					
					System.out.println("\n" + Houses[HouseNumber]); //displays information of the specific household 
					
					continue;
					
				case 3:
					System.out.println("List of HouseholdBudgets with the same total fund:\n"); //formats a list of household budgets with the same total fund
					
					/*for loop that looks at each content within the Houses array*/
					for (int i = 0; i < Houses.length; i ++) {
						/*for loop that looks at the content of the compared household*/
						for (int j = i; j < Houses.length; j++) {
							/*if statement necessary to not repeat household budgets with the same Household number. We want to compare Household Budgets with different Household numbers.*/
							if (i ==j) {
								continue;
							}
							/*if the total funds of a house is equal to those of another house using the compareTotalFunds() method from "HouseholdBudget" class*/
							if (Houses[i].compareTotalFunds(Houses[j])) {
								System.out.println("        HouseholdBudgets " + i + " and " + j + " both have " + Houses[i].HouseholdBudgetFundTotal()); //displays which and which houses have the exact amount of total funds displayed
							}
						}
					}
					System.out.println(); //skips a line
					
					continue;
					
				case 4:
					System.out.println("List of HouseholdBudgets with the same Fund:\n"); //formats a list of household budgets with the same fund
					
					/*for loop that looks at each content within the Houses array*/
					for (int i = 0; i < Houses.length; i ++) {
						/*for loop that looks at the content of the compared household*/
						for (int j = i; j < Houses.length; j++) {
							/*if statement necessary to not repeat household budgets with the same Household number. We want to compare Household Budgets with different Household numbers.*/
							if (i ==j) {
								continue;
							}
							/*if the fund type of a house is equal to that of another house using the compareFundType() method from "HouseholdBudget" class*/
							if (Houses[i].compareFundType(Houses[j])) {
								System.out.println("        HouseholdBudgets " + i + " and " + j + " both have " + Houses[i].fundBreakdown()); //displays which and which houses have the exact fund breakdown displayed
							}
						}
					}
					System.out.println(); //skips a line
					
					continue;
					
				case 5:
					System.out.println("List of HouseholdBudgets with the same amount of money and same number of expenses:\n"); //formats a list of household budgets with the same amount of money and number of expenses
					
					/*for loop that looks at each content within the Houses array*/
					for (int i = 0; i < Houses.length; i ++) {
						/*for loop that looks at the content of the compared household*/
						for (int j = i; j < Houses.length; j++) {
							/*if statement necessary to not repeat household budgets with the same Household number. We want to compare Household Budgets with different Household numbers.*/
							if (i ==j) {
								continue;
							}
							/*if the amount of money and number of expenses of a house are equal to those of another house using the equals() method from "HouseholdBudget" class*/
							if (Houses[i].equals(Houses[j])) {
								System.out.println("        HouseholdBudgets " + i + " and " + j); //displays which and which houses have the exact amount of money and number of expenses
							}
						}
					}
					System.out.println(); //skips a line
					
					continue;
					
				case 6:
					System.out.print("Which HouseholdBudget do you want to add an Expense to? (Enter number 0 to 4): "); //prompts the user to enter a valid integer within the restrictions
					
					int HouseChoice = Input.nextInt(); //input from Input scanner as an integer
				
					/*Error will keep popping up until the user inputs a valid integer within the restrictions stated*/
					while (HouseChoice < 0 || HouseChoice > 4) {
						
						System.out.println("\nSorry but there is no householdBudget number: " + HouseChoice); //error message
						System.out.print("--> Try again: (Enter number 0 to 4): "); //prompts user to try inputting an integer again
						
						HouseChoice = Input.nextInt(); //allows user to enter an integer again
					}
					System.out.println(Houses[HouseChoice].addExpense()); //prints the new expense added to the content of a house using the addExpense() method in "HouseholdBudget" class
					
					continue;
					
				case 7:
					System.out.print("Which HouseholdBudget do you want to remove an expense from? (Enter number 0 to 4): "); //prompts the user to enter a valid integer within the restrictions
					
					int RemoveExpense = Input.nextInt(); //input from Input scanner as an integer
					
					/*Error will keep popping up until the user inputs a valid integer within the restrictions stated*/
					while (RemoveExpense < 0 || RemoveExpense > 4) {
						System.out.println("\nSorry but there is no householdBudget number: " + RemoveExpense); //error message
						System.out.print("Try again: (Enter number 0 to 4): "); //prompts user to try inputting an integer again
						
						RemoveExpense = Input.nextInt(); //allows user to enter an integer again
					}
					
					/*If the Content of the array Houses at the indicated index content contains expenses*/
					if (Houses[RemoveExpense].NumberOfExpense() != 0) {
						System.out.print("(Enter number 0 to " + (Houses[RemoveExpense].NumberOfExpense() - 1) + "): "); //prompts the user to enter a valid integer within the restrictions
						
						int RemExpense = Input.nextInt(); //input from Input scanner as an integer
						
						/*If the content of the array Houses at the indicated index is correct using the removeExpense() method in the "HouseholdBudget" class, it removes the expense*/
						if (Houses[RemoveExpense].removeExpense(RemExpense) == true) {
							System.out.println("\nExpense was removed successfully\n"); //displays a message saying that the expense was removed
						}
					}
					else {
						System.out.println("Sorry that HouseholdBudget has no expenses\n"); //displays a message saying that the household budget has no budget otherwise
					}
					
					continue;
					
				case 8:
					System.out.print("Which HouseholdBudget do you want to update an expense from? (Enter number 0 to 4): "); //prompts the user to enter a valid integer within the restrictions
					
					int HouseHoldNumber = Input.nextInt(); //input from Input scanner as an integer
					
					/*Error will keep popping up until the user inputs a valid integer within the restrictions stated*/
					while (HouseHoldNumber < 0 || HouseHoldNumber > 4) {
						System.out.println("\nSorry but there is no householdBudget number: " + HouseHoldNumber); //error message
						System.out.print("--> Try again: (Enter number 0 to 4): "); //prompts user to try inputting an integer again
						
						HouseHoldNumber = Input.nextInt(); //allows user to enter an integer again
					}
					
					System.out.print("Which expense do you want to update? (Enter number 0 to " + (Houses[HouseHoldNumber].NumberOfExpense()-1) + "): "); //prompts the user to enter a valid integer within the restrictions
					
					int HouseholdExpense = Input.nextInt(); //input from Input scanner as an integer
					
					/*Error will keep popping up until the user inputs a valid integer within the restrictions stated*/
					while (HouseholdExpense > Houses[HouseHoldNumber].NumberOfExpense() || HouseholdExpense < 0) {
						System.out.println("\nSorry, there is no expense number " + HouseholdExpense); //error message
						System.out.print("--> Try again:" + "\n" + "(Enter number 0 to " + (Houses[HouseHoldNumber].NumberOfExpense()-1) + "): "); //prompts user to try inputting an integer again
						
						HouseholdExpense = Input.nextInt(); //allows user to enter an integer again
					}
					
					System.out.print("\n--> Enter new payment due day number and month (separate by a space): "); //prompts the user to enter 2 integers separated by a space 
					
					int DueDay = Input.nextInt(); //input from Input scanner as an integer
					int DueMonth = Input.nextInt(); //input from Input scanner as an integer
					Houses[HouseHoldNumber].updateDueDateOfExpense(DueDay, DueMonth, HouseholdExpense); //method declared for updating the due date of a household in array Houses using updateDueDateOfExpense() method in "HouseholdBudget" class
					System.out.println("Due Day and Month updated."); //outputs an update message for due day and due month
					
					continue;
					
				case 9:
					System.out.print("Which HouseholdBudget do you want to add Fund to? (Enter number 0 to 4): "); //prompts the user to enter a valid integer within the restrictions
					
					int NumberOfChoice = Input.nextInt(); //input from Input scanner as an integer
					
					/*Error will keep popping up until the user inputs a valid integer within the restrictions stated*/
					while (NumberOfChoice < 0 || NumberOfChoice > 4) {
						System.out.println("\nSorry but there is no householdBudget number: " + NumberOfChoice); // error message
						System.out.print("Try again: (Enter number 0 to 4): "); //prompts user to try inputting an integer again
						
						NumberOfChoice = Input.nextInt(); //allows user to enter an integer again
					}
					
					System.out.println("How many loonies, toonies, $5, $10 and $20 bill do you want to add?");
					System.out.print("Enter 5 numbers separated by a space: "); //asks user to input 5 integers seperated by a space
					
					int loonies = Input.nextInt(); //input from Input scanner as an integer
					int toonies = Input.nextInt(); //input from Input scanner as an integer
					int FiveDollarBill = Input.nextInt(); //input from Input scanner as an integer
					int TenDollarBill = Input.nextInt(); //input from Input scanner as an integer
					int TwentyDollarBill = Input.nextInt(); //input from Input scanner as an integer
					
					/*New total computed within the content of array Houses using the addFund() method with 5 Parameters in "HouseholdBudget" class*/
					double newTotal = Houses[NumberOfChoice].addFund(loonies, toonies, FiveDollarBill, TenDollarBill, TwentyDollarBill);
					
					System.out.println("You now have: " + newTotal); //displays the total of funds for the household
					
					continue;
			} //end of switch
		} //end of while loop
		Input.close(); //close scanner
	} //end of main
} //end of class
