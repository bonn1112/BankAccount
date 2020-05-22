package YosukeAkutsuPP02;				                                                                    

public class CreditCard {//class
	
	private long number;
	private String expDate;
	
	public CreditCard(long number, String expDate){
		this.number = number;
		this.expDate = expDate;
	}

	// add public setter/getter methods, and also the toString method
	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	
	@Override
	public String toString() {
		return  number + ", Expiration Date: " + expDate;
	}
	
}//class