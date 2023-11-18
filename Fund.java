/*This class runs a series of methods for managing the Funds inside a HouseholdBudget. It involves 5 variables or rather
 *Fund Types (loonies, toonies, five dollar bills, ten dollar bills, twenty dollar bills) that are taken into account by
 *the program and compute the total of funds for a single household. */

package assignment4;

public class Fund {
	
	/*5 Private Integer Attributes Declared*/
	private int loonies;
	private int toonies;
	private int FiveDollarBill;
	private int TenDollarBill;
	private int TwentyDollarBill;
	
	/*5 Private Static final Integer Attributes that cannot be changed and remain constant*/
	public static final int looniesValue = 1;
	public static final int tooniesValue = 2;
	public static final int FiveDollarBillValue = 5;
	public static final int TenDollarBillValue = 10;
	public static final int TwentyDollarBillValue = 20;
	
	/*Default Constructor initializes the 5 Integer Attributes to 0*/
	public Fund() {
		loonies = 0;
		toonies = 0;
		FiveDollarBill = 0;
		TenDollarBill = 0;
		TwentyDollarBill = 0;
	}
	
	/*Constructor of 5 Integer Parameters that sets the value of the attributes to the Instance of an object declared in the driver class*/
	public Fund(int loonies, int toonies, int FiveDollarBill, int TenDollarBill, int TwentyDollarBill){
		this.loonies = loonies;
		this.toonies = toonies;
		this.FiveDollarBill = FiveDollarBill;
		this.TenDollarBill = TenDollarBill;
		this.TwentyDollarBill = TwentyDollarBill;
	}
	
	/*Copy Constructor that allows the values for the attributes to be referenced as Attributes in the HouseholdBudget class*/
	public Fund(Fund Fund) {
		
		this.loonies = Fund.loonies;
		this.toonies = Fund.toonies;
		this.FiveDollarBill = Fund.FiveDollarBill;
		this.TenDollarBill = Fund.TenDollarBill;
		this.TwentyDollarBill = Fund.TwentyDollarBill;
	}
	
	/*Mutator method for the Attribute loonies*/
	public void setLoonies(int loonies) {
		this.loonies = loonies;
	}
	
	/*Accessor method for the Attribute loonies*/
	public int getLoonies() {
		return loonies;
	}
	
	/*Mutator method for the Attribute toonies*/
	public void setToonies(int toonies) {
		this.toonies = toonies;
	}
	
	/*Accessor method for the Attribute toonies*/
	public int getToonies() {
		return toonies;
	}
	
	/*Mutator method for the Attribute FiveDollarBill*/
	public void setFiveDollarBill(int FiveDollarBill) {
		this.FiveDollarBill = FiveDollarBill;
	}
	
	/*Accessor method for the Attribute FiveDollarBill*/
	public int getFiveDollarBill() {
		return FiveDollarBill;
	}
	
	/*Mutator method for the Attribute TenDollarBill*/
	public void setTenDollarBill(int TenDollarBill) {
		this.TenDollarBill = TenDollarBill;
	}
	
	/*Accessor method for the Attribute TenDollarBill*/
	public int getTenDollarBill() {
		return TenDollarBill;
	}
	
	/*Mutator method for the Attribute TwentyDollarBill*/
	public void setTwentyDollarBill(int TwentyDollarBill) {
		this.TwentyDollarBill = TwentyDollarBill;
	}
	
	/*Accessor method for the Attribute TwentyDollarBill*/
	public int getTwentyDollarBill() {
		return TwentyDollarBill;
	}
	
	/*Method of 5 Integer Parameters that adds the allocated values to the respective FundTypes*/
	public void addFund(int loonies, int toonies, int FiveDollarBill, int TenDollarBill, int TwentyDollarBill) {
		this.loonies += loonies;
		this.toonies += toonies;
		this.FiveDollarBill += FiveDollarBill;
		this.TenDollarBill += TenDollarBill;
		this.TwentyDollarBill += TwentyDollarBill;
	}
	
	/*Method that returns an integer value for the total of funds of a household*/
	public int fundTotal() {
		return ((loonies*looniesValue) + (toonies*tooniesValue) + (FiveDollarBill*FiveDollarBillValue) + (TenDollarBill*TenDollarBillValue) + (TwentyDollarBill*TwentyDollarBillValue));
	}
	
	/*Overridden toString() method that returns a string of explicit Fund types computations to arrive to the total of funds*/
	public String toString() {
		return "(" + loonies + " x $1) + (" + toonies + " x $2) + (" + FiveDollarBill + " x $5) + (" + TenDollarBill + " x $10) + (" + TwentyDollarBill + " x $20)";
	}
	
	/*Overridden equals() method that compares the Fund types of two objects and returns true if they are all the same or False otherwise*/
	public boolean equals(Fund Fund) {
		if ((loonies == Fund.loonies) && (toonies == Fund.toonies) && (FiveDollarBill == Fund.FiveDollarBill) && (TenDollarBill == Fund.TenDollarBill) && (TwentyDollarBill == Fund.TwentyDollarBill)) {
			return true;
		} else {
			return false;
		}
	}
} //end of class
