package YosukeAkutsuPP02;

//class Validation
public class Validation {
	
  // Return true if the card number is valid, otherwise returns false
  public boolean aValidNumber(String n) {

	long number = Long.parseLong(n);
	
	return  (numLength(number) >= 13) && (numLength(number) <= 16) &&
        (prefixCheck(number, 4) || prefixCheck(number, 5) ||
        prefixCheck(number, 6) || prefixCheck(number, 37)) &&
        (totalEevenNumbers(number) + totalOddNumbers(number)) % 10 == 0;
	
  }// end of aValidNumber method

  //get the sum of even places numbers, Starting from the second digit from right
  private int totalEevenNumbers(long number) {
	  int sum = 0; 
      String num = number + ""; 
      
      for (int i = numLength(number) - 2; i >= 0; i -= 2)  
          sum += singleDigit(Integer.parseInt(num.charAt(i) + "") * 2); 
        
      return sum;
      
  }// end of totalEevenNumbers method

  // Return the same number if it is a single digit, otherwise, return the sum of
  // the two digits in this number
  private int singleDigit(int number) {//singleDigit method
	  if (number < 9) 
          return number;
	  
      return (number / 10) + (number % 10);
      
  }// end of singleDigit method

  // Return the sum of odd place digits in number
  private int totalOddNumbers(long number) {//totalOddNumbers method

      int sum = 0; 
      String num = number + ""; 
      for (int i = numLength(number) - 1; i >= 0; i -= 2)  
          sum += Integer.parseInt(num.charAt(i) + "");         
      return sum; 

  }// end of totalOddNumbers method

  // Return true if the digit d is a prefix for number
  private boolean prefixCheck(long number, int digit) {//prefixCheck method
	
	  return numPrefix(number, numLength(digit)) == digit; 
	 
  }// end of prefixCheck method


  // Return the number of digits in this number parameter
  private int numLength(long number) {//numLength method

	  String num = number + ""; 
	  
      return num.length();
      
  }// end of numLength method

  // Return the first k number of digits from number, which is either a first digit or first two digits
  private long numPrefix(long number, int k) {
	  
	  if (numLength(number) > k) { 
          String num = number + ""; 
          return Long.parseLong(num.substring(0, k)); 
      } 
	  
      return number; 
  } 

}// end of the class