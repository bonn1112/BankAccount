package YosukeAkutsuPP02;			                                                                    

//Customer class
public class Customer {
	
	private int id;
	private String fName, lName;
	private double amount;
	private CreditCard card;
	private static int noOfCustomer;
	//Default constructor
	public Customer(String fName, String lName, int id, double amount, CreditCard card) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.id = id;
		this.amount = amount;
		this.card = card;
		noOfCustomer++;
	}
	
	// add public setter/getter methods, and also the toString method
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public CreditCard getCard() {
		return card;
	}

	public void setCard(CreditCard card) {
		this.card = card;
	}	

	public static int getNoOfCustomer() {
		return noOfCustomer;
	}	

	@Override
	public String toString() {
		return "Customer Id: " + id + ", Customer First Name: " + fName + ", Customer Last Name: " + lName + ", Amount: " + String.format("%.2f", amount) + ", Card Number: " + card;
	}
	
	
	
}//class
