/*This class runs a series of methods that incorporate the classes "Fund" and "Expense" as attributes for this class and manage the Household budget within a household.
 *There are methods that compare funds, fund types, add expenses, remove expenses, add funds, update due dates, display fund breakdowns,
 *compare households and display a string of information within the households. */

package assignment4;

import java.util.Scanner; //class needs to import Scanner

public class HouseholdBudget {

	/*2 Private Attributes called from the copy constructors of classes "Fund" and "Expense" and are Declared*/
	private Fund Fund;
	private Expense[] Expenses;
	
	/*Default Constructor that initializes Expenses array to null and creates an instance of the constructor Fund in class "Fund"*/
	public HouseholdBudget() {
		this.Fund = new Fund();
		this.Expenses = null;
	}
	
	/*Constructor of 2 Parameters that sets the value of the attributes to the Instance of an object declared in the driver class*/
	public HouseholdBudget (Fund Fund, Expense[] Expenses) {
		this.Fund = Fund;
		this.Expenses = Expenses;
	}
	
	/*Accessor method for the Attribute Fund*/
	public Fund getFund() {
		return Fund;
	}
	
	/*Accessor method for method fundTotal within the class "Fund" that returns the total value of funds*/
	public double HouseholdBudgetFundTotal() {
		return this.Fund.fundTotal();
	}
	
	/*Accessor method that returns the length of the array Expenses which is a number that displays the number of expenses in a household*/
	public int NumberOfExpense() {
		return this.Expenses.length;
	}
	
	/*Method that compares the total funds of 2 HouseholdBudgets and returns true if they are equal and false otherwise*/
	public boolean compareTotalFunds(HouseholdBudget HouseholdBudget) {
		return this.Fund.fundTotal() == HouseholdBudget.Fund.fundTotal();
	}
	
	/*Method that compared the types of funds of 2 HouseholdBudgets and returns true if they are equal and false otherwise*/
	public boolean compareFundType(HouseholdBudget HouseholdBudget) {
		return HouseholdBudget.Fund.equals(this.getFund());
	}
	
	/*Method that adds an expense to an existing household*/
	public String addExpense() {
		Scanner addExpenseInput = new Scanner(System.in); // Scanner Declared
		Expense[] newExpense = new Expense[Expenses.length + 1]; //Array of new Expense declared that has an incremented length by 1 than the previous Expenses array
		
		/*Instance Attributes that resemble the ones in "Expense" class are declared and initializes to 0, 0.0, and "".*/
		String ExpenseType = "";
		double Amount = 0.0;
		String NameOfBusiness = "";
		int DueDay = 0;
		int DueMonth = 0;
		
		/*Series of Outputs that prompt the user to enter the required information*/
		System.out.println("Please enter the following information so that we may complete the expense--");
		
		System.out.print(" --> Type of expense (Bill, Purchase, etc.): "); //prompts user to enter expense type
		ExpenseType = addExpenseInput.nextLine(); //Input for expense type as string
		
		System.out.print(" --> Amount of the expense: "); //prompts user to enter amount of expense
		Amount = addExpenseInput.nextDouble(); //Input for amount as double
		String SkipLine1 = addExpenseInput.nextLine(); //Skips a line
		
		System.out.print(" --> Business name: "); //prompts user to enter name of business
		NameOfBusiness = addExpenseInput.nextLine(); //Input for name of business as string
		
		System.out.print(" --> Payment due day and month (separate by a space): "); //prompts user to enter due date by day and month
		DueDay = addExpenseInput.nextInt(); //Input for due day as integer
		DueMonth = addExpenseInput.nextInt(); //Input for due month as integer
		String SkipLine2 = addExpenseInput.nextLine(); //Skips a line
		
		/*Instance of Expense Method with 5 parameters declared as newExpense1*/
		Expense newExpense1 = new Expense(ExpenseType, NameOfBusiness, Amount, DueDay, DueMonth);
		
		/*for loop that copies the content of the array Expenses into newExpense*/
		for (int i = 0; i < Expenses.length; i++) {
			newExpense[i] = Expenses[i];
		}
		
		newExpense[newExpense.length - 1] = newExpense1; //Shallow copy of newExpense1 Instance into array newExpense with a decremented length by 1
		Expenses = newExpense; //Shallow copy of newExpense array into initial array Expenses
		
		String ExpenseString = "You now have " + Expenses.length + " expense(s)"; //String output that shows to user how many expenses are present in the household
		
		return ExpenseString; //returns the String above
	}
	
	/*Method of 1 Integer Parameter that removes an expense from an existing household*/
	public boolean removeExpense(int Index) {
		Expense[] UpdatedExpense = new Expense[Expenses.length - 1]; //Array of UpdatedExpense declared that has an decremented length by 1 than the previous Expenses array
		
		int Counter = 0; //Counter initializes to 0
		
		/*for loop that removes an expense within the array*/
		for (int i = 0; i < Expenses.length; i++) {
			
			/*As long as "i" is not equal to the input Index from the user, the counter will keep incrementing until the condition is not met
			 * where "i" is equal to the index. This will skip the position within the array and the next increment will become the content
			 * at this previous spot and will remove the expense.*/
			if (i != Index) {
				UpdatedExpense[Counter] = Expenses[i]; //the content within the Counter index position of UpdatedExpense will become that of the Expenses array within "i" index position
				Counter++; //Counter is incremented
			}
		}
		
		Expenses = UpdatedExpense; //content of Expenses array becomes that of UpdatedExpense
		return true;
	}
	
	/*Method of 3 Integer Parameters that updates the due date of the expense*/
	public void updateDueDateOfExpense(int DueDay, int DueMonth, int ExpenseIndex) {
		
		this.Expenses[ExpenseIndex].setDueDay(DueDay); //due day within the index of the expenses array is instanciated
		this.Expenses[ExpenseIndex].setDueMonth(DueMonth); //due month within the index of the expenses array is instanciated
	}
	
	/*Method of 5 Integer Parameters that increase the value of the total funds by increasing the values of fund types*/
	public int addFund(int loonies, int toonies, int FiveDollarBill, int TenDollarBill, int TwentyDollarBill) {
		
		/*Values for each fund type are increased by the amount of each parameter indicated*/
		this.Fund.setLoonies(this.Fund.getLoonies() + loonies);
		this.Fund.setToonies(this.Fund.getToonies() + toonies);
		this.Fund.setFiveDollarBill(this.Fund.getFiveDollarBill() + FiveDollarBill);
		this.Fund.setTenDollarBill(this.Fund.getTenDollarBill() + TenDollarBill);
		this.Fund.setTwentyDollarBill(this.Fund.getTwentyDollarBill() + TwentyDollarBill);
		
		return this.Fund.fundTotal(); //returns the value for the fund total as an integer
	}
	
	/*Overriden equals() method that compares the total funds and number of expenses between two households and returns true if they are equal or false otherwise*/
	public boolean equals(HouseholdBudget HouseholdBudget) {
		return this.compareTotalFunds(HouseholdBudget) && this.NumberOfExpense() == HouseholdBudget.NumberOfExpense();
	}
	
	/*Overridden toString() method that displays the content for the funds and expenses within a household*/
	public String toString() {
		
		String Details = ""; //Details initializes to ""
		
		Details += this.Fund.toString() + "\n"; //Details adds the output information for the funds from the toString() method within the "Fund" class
		
		/*If the household has no expenses, the output displays "No expenses"*/
		if (this.NumberOfExpense() == 0) {
			Details += "No Expenses" + "\n";
		/*otherwise*/	
		} else {
			/*for loop looks at the content within the Expenses array and displays it*/
			for (int i = 0; i < this.Expenses.length; i++) {
				Details += this.Expenses[i].toString() + "\n"; //for each index of the Expenses array, details adds the output information from the toString() method within the "Expense" class
			}
		}
		
		return Details;
	}
	
	/*Method that displays the fund breakdown as a string*/
	public String fundBreakdown() {
		return this.Fund.toString();
	}
} //end of class
