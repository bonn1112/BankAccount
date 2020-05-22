package YosukeAkutsuPP02;

import javax.swing.JOptionPane;
import java.io.*;

//payment class
public class Payment {
	
	//declare static object
	public static Validation validating;
	public static HashCode hashing;
	public static Customer[] customers;

	// method for checking whether a card is valid or invalid
	public static Boolean isValidCard(String num){
		boolean isValid = false;
		try {
			isValid = validating.aValidNumber(num);
		} 
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Invalid Card Number");
		}
		
		return isValid;

	}// end of the isValidCard method

	// method for creating a hash code for the credit card number to be stored in file
    public static String createHashCode(String num){
    	  	
		return hashing.getHashCode(num);

	}// end of the createHashCode method

    // method for adding a new customer to the array of customers once the payment is success
 	public static void addCustomer(Customer customer){
 		
 		customers[Customer.getNoOfCustomer()-1]= customer;
 		
 	}// end of the addCustomer method 	

	// it displays the payments average, maximum payment, and minimum payment
	public static void displayStat(){

		if (Customer.getNoOfCustomer() == 0)
			return;
		double totalAmount = 0;
		double maxAmount = customers[0].getAmount();
		double minAmount = customers[0].getAmount();
		//assign min and max for customer object
		for (int i = 0; i < Customer.getNoOfCustomer(); i++) {
			totalAmount += customers[i].getAmount();
			if (maxAmount < customers[i].getAmount())
				maxAmount = customers[i].getAmount();
			if (minAmount > customers[i].getAmount())
				minAmount = customers[i].getAmount();
		}
		
		String message = "Avgerage amount: " +String.format("%.2f", totalAmount / Customer.getNoOfCustomer()) 
						+ ", Highest amount is " + String.format("%.2f", maxAmount)	+ ", lowest amount is " 
						+ String.format("%.2f", minAmount) + "\n";
		
		for (int i = 0; i < Customer.getNoOfCustomer(); i++)
			message += customers[i].toString() + "\n";
		
		JOptionPane.showMessageDialog(null, message);

	}// end of the displayStat method

	// method for writing data to file
    public static void writeToFile()throws IOException {
    	
    	if (Customer.getNoOfCustomer() == 0)
			return;
    	
		String message = "";
		
		for (int i = 0; i < Customer.getNoOfCustomer(); i++) {
			String creditCardNumber = String.valueOf(customers[i].getCard().getNumber());
			String customerToString = customers[i].toString();
			customerToString = customerToString.replace(creditCardNumber, createHashCode(creditCardNumber));

			message = message  + customerToString + "\r\n";
		}
		//create a file
		java.io.File file = new java.io.File("Customer.txt");
		
		//write to the file
		java.io.PrintWriter output = new java.io.PrintWriter(file);
		output.print(message);	
				
		// close the file
		output.close();
		
		//display message
    	JOptionPane.showMessageDialog(null, "Completed writing data to file \"Customer.txt\"");
    
    }// end of the writeToFile method

	//main method
	public static void main(String[] args) throws Exception {
		
		//create new objects
		hashing = new HashCode();
		validating = new  Validation();
        
		// input the number of customers 
        int n = intInput("Please enter the number of customers");        
		int customerId;
		double amount = 0;
		
		// must hold the number of customers based on the user input
		customers = new Customer[n];
		
		// The program should allow users to enter customers payments information
		for (int i = 0; i < n; i++) {
			customerId = intInput("Please enter the Customer Id");
			String cardNumber = JOptionPane.showInputDialog("Please enter the credit number");	
			//call the isVaildCard method if user input invalid number 
			while(!isValidCard(cardNumber)) {
				JOptionPane.showMessageDialog(null, cardNumber + " is Invalid. ");			
				int selectedOption = JOptionPane.showConfirmDialog(null," Do you want to try again?", "Select Yes or No",JOptionPane.YES_NO_OPTION );
				
				if(selectedOption == JOptionPane.YES_OPTION) 
					cardNumber = JOptionPane.showInputDialog("Please enter the credit number");				
				else
					System.exit(0);				
			}
			// to get user name, data and amount
			String fName = JOptionPane.showInputDialog("Please enter the First Name");
			String lName = JOptionPane.showInputDialog("Please enter the Last Name");			
			String expdate = JOptionPane.showInputDialog("Please enter the expiration date(mm/yy)");			
			amount = doubleInput("Please enter the amount");		
			
			long cardId = Long.parseLong(cardNumber);
			
			//create new credit card object after getting information from user to throw the values
			CreditCard creditCard = new CreditCard(cardId, expdate);			
			addCustomer(new Customer(fName, lName, customerId, amount, creditCard));			
			createHashCode(cardNumber);

		}	
		
		displayStat();
		writeToFile();
		
	}// main
	
	//method for getting customer numbers
	private static int intInput(String message) {	
		boolean isValid = false;
		int i = 0;
		String input;
		
		do {
			try {
				input = JOptionPane.showInputDialog(message);
				i = Integer.parseInt(input);
				isValid = true;
			} 
			catch (Exception ex) {								
				JOptionPane.showMessageDialog(null, "Please enter valid numbers");
				
				//allow user to choose try again or not
				int selectedOption = JOptionPane.showConfirmDialog(null," Do you want to try again?", "Select Yes or No",JOptionPane.YES_NO_OPTION );
				if(selectedOption== JOptionPane.YES_OPTION) 
					continue;				
				else
					System.exit(0);
			}//catch
			
		}//end do-while loop
		while(!isValid);
		
		return i;
		
	}//end
	
	//method for getting amount
	private static double doubleInput(String message) {
		boolean isValid = false;
		double d = 0;
		String input;
		
		do{
			try {
				input = JOptionPane.showInputDialog(message);
				d = Double.parseDouble(input);
				isValid = true;
			}
			
			catch (NumberFormatException e) {
				
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Please enter valid numbers");
				
				//allow user to choose try again or not
				int selectedOption = JOptionPane.showConfirmDialog(null," Do you want to try again?", "Select Yes or No",JOptionPane.YES_NO_OPTION );
				if(selectedOption== JOptionPane.YES_OPTION) 
					continue;				
				else
					System.exit(0);
			}//catch
		}//do
		while(!isValid);
		return d;
		
	}//doubleInput()
		
}//class

