package YosukeAkutsuPP02;			                                                                    

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashCode {//class	
   // creates hash good to a given long number in a String format	
   public String getHashCode(String number){//getHashCode(String number)
    	
        MessageDigest md = null;
		
        try {
			md = MessageDigest.getInstance("MD5");
		} 
		catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}//catch
		
        md.update(number.getBytes());
        
        byte[] byteData = md.digest();
        
       //call convert the byte to hex format method, and return the String Hex 
    	return convertToHexString(byteData);
    	
    }//end
   
 //converts the byte to hex format method code
   private String convertToHexString(byte[] byteData ){
	 
    StringBuffer hexString = new StringBuffer();
    
   	for (int i=0;i<byteData.length;i++) {
   		String hex=Integer.toHexString(0xff & byteData[i]);
  	     	if(hex.length()==1) 
  	     		hexString.append('0');
  	     	hexString.append(hex);
   	}
   
   	return hexString.toString();
   
   }
   
}//class
