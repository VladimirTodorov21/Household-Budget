/*This class runs a series of methods for managing the expenses inside a household budget. It involved 5 attributes namely
 *(the type of expense, the name of business, the amount of money, the due day, the due month) that are taken into account by
 *the program and display the information for a particular expense in a household. */

package assignment4;

public class Expense{
	
	/*5 Private Attributes Declared (2 Strings, 1 double, 2 integers)*/
	private String ExpenseType;
	private String NameOfBusiness;
	private double Amount;
	private int DueMonth;
	private int DueDay;
	
	/*Default Constructor*/
	public Expense() {
		
	}
	
	/*Constructor of 5 Parameters that sets the value of the attributes to the Instance of an object declared in the driver class*/
	public Expense(String ExpenseType, String NameOfBusiness, double Amount, int DueDay, int DueMonth) {
		
		this.ExpenseType = ExpenseType;
		this.NameOfBusiness = NameOfBusiness;
		this.Amount = Amount;
		
		/*If the number input for the due day is not a valid number, the number is set to 0 for the day.*/
		if (!(DueDay >= 1 && DueDay <= 31)) {
			this.DueDay = 0;
		} else {
			this.DueDay = DueDay;
		}
		
		/*If the number input for the due month is no a valid number, the number is set to 0 for the month.*/
		if (!(DueMonth >= 1 && DueMonth <= 12)) {
			this.DueMonth = 0;
		} else {
			this.DueMonth = DueMonth;
		}
	}
	
	/*Copy Constructor that allows the values for the attributes to be referenced as Attributes in the HouseholdBudget class*/
	public Expense(Expense Expense)
	{
		this.ExpenseType = Expense.ExpenseType;
		this.Amount = Expense.Amount;
		this.NameOfBusiness = Expense.NameOfBusiness;
		this.DueMonth = Expense.DueMonth;
		this.DueDay = Expense.DueDay;
	}
	
	/*Accessor method for the Attribute ExpenseType*/
	public String getExpenseType() {
		return ExpenseType;
	}
	
	/*Accessor method for the Attribute NameOfBusiness*/
	public String getNameOfBusiness() {
		return NameOfBusiness;
	}
	
	/*Accessor method for the Attribute Amount*/
	public double getAmmount() {
		return Amount;
	}
	
	/*Mutator method for the Attribute DueMonth*/
	public void setDueMonth(int DueMonth) {
		if (DueMonth >= 1 && DueMonth <= 12) {
			this.DueMonth = DueMonth;
		}
		else {
			this.DueMonth = 0;
		}
	}
	
	/*Accessor method for the Attribute DueMonth*/
	public int getDueMonth() {
		return DueMonth;
	}
	
	/*Mutator method for the Attribute DueDay*/
	public void setDueDay(int DueDay) {
		if (DueDay >= 1 && DueDay <= 31) {
			this.DueDay = DueDay;
		}
		else {
			this.DueDay = 0;
		}
	}
	
	/*Accessor method for the Attribute DueDay*/
	public int getDueDay() {
		return DueDay;
	}
	
	/*Overridden toString() method that returns a string of information for a single expense*/
	public String toString() {
		String stringDueDay = Integer.toString(DueDay); // DueDay becomes a String 
		String stringDueMonth = Integer.toString(DueMonth); // DueMonth becomes a String
		
		/*If the integer of DueDay is lower than 10, add an extra 0 in front of the istring number*/
		if (DueDay <= 9) {
			stringDueDay = "0" + stringDueDay;
		}
		
		/*If the integer of DueMonth is lower than 10, add an extra 0 in front of the string number*/
		if (DueMonth <= 9) {
			stringDueMonth = "0" + stringDueMonth;
		}
		
		return  ExpenseType + " - $" + Amount + " - " + NameOfBusiness + " - " + stringDueDay + "/" + stringDueMonth + ".";
	}
	
	/*Overridden equals() method that compares the Attributes of two objects and returns true if they are all the same or False otherwise*/
	public boolean equals(Expense Expense) {
		if ((ExpenseType == Expense.ExpenseType) && (NameOfBusiness == Expense.NameOfBusiness) && (Amount == Expense.Amount) && (DueDay == Expense.DueDay) && (DueMonth == Expense.DueMonth)) {
			return true;
		}
		else {
			return false;
		}
	}
} // end of class
