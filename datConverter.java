/* dp challenge = Daily Programmer Challenge, a subreddit with daily programming challenges.
Source: https://www.reddit.com/r/dailyprogrammer/comments/4q35ip/20160627_challenge_273_easy_getting_a_degree/
This is my second attempt, before I just used the main method now I'm going to try and put converter logic into a method.
*/

import java.util.Scanner;

class datConverter {
	
	//String convertRequest = "";
	//String userRequest;
	int numberPart = 0; // For taking the number part of the conversion reuqest.
	String numberString = ""; // For the number part of the string.
	double valuePart; // numberPart was for computational purposes. This is the actual number part of the conversion request to the right data type
	
	//Scanner input = new Scanner(System.in);
	
	double PI = 3.14159;
	double radToDegrees = 180 / PI;
	double degreesToRad = PI / 180;
	double conversionResult = 0.0;
	
	double fToC1 = 0.0;  //fToC1 = Fahrenheit to Celcius Step 1
	double fToC2 = 0.0;
	
	double fToK1 = 0.0;
	double fToK2 = 0.0;
	
	double conversionValue = 5.0/9.0;
	
	double cToF1 = 0.0;
	double cToF2 = 0.0;
	
	double kToF1 = 0.0;
	double kToF2 = 0.0;
	
	double conversionValue2 = 9.0/5.0;
	
	public void conversion(String convertRequest) {
		
		//System.out.println("Enter your conversion request: ");
		//convertRequest = input.nextLine();
		
		numberPart = convertRequest.length() - 2;
		
		numberString = convertRequest.substring(0, numberPart);
		valuePart = Double.parseDouble(numberString);
		
		String currentUnit = "";
		int currentUnitIndex = 0;
		
		currentUnitIndex = convertRequest.length() - 2;
		currentUnit = convertRequest.substring(currentUnitIndex, currentUnitIndex + 1);
		
		String requestedUnit = "";
		int requestedUnitIndex = 0;
		
		requestedUnitIndex = convertRequest.length() - 1;
		requestedUnit = convertRequest.substring(requestedUnitIndex, requestedUnitIndex + 1);
		
		if (currentUnit.equals("r") && requestedUnit.equals("d")) {
			
			conversionResult = valuePart * radToDegrees;
			System.out.println(conversionResult + requestedUnit);
			
			if (conversionResult > 360) {
				
				do {
					
					conversionResult = conversionResult - 360;
					
				}while (conversionResult > 360);
				
				System.out.println("I've noticed the result of your conversion is greater than 360 degrees. Here's a coterminal degree measure: " + conversionResult + requestedUnit);
				
			}
			
		}
		
		else if (currentUnit.equals("d") && requestedUnit.equals("r")) {
			
			conversionResult = valuePart * degreesToRad;
			System.out.println(conversionResult + requestedUnit);
			
			if (conversionResult > 6.28318) {
				
				do {
					
					conversionResult = conversionResult - 6.28318;
					
				}while (conversionResult > 6.28318);
				
				System.out.println("I've noticed the result of your conversion is greater than 2pi. Here's a coterminal radian measure: " + conversionResult + requestedUnit);
				
			}
			
		}
		
		else if (currentUnit.equals("c") && requestedUnit.equals("f")) {
			
			cToF1 = valuePart * conversionValue2;
			cToF2 = cToF1 + 32;
			conversionResult = cToF2;
			System.out.println(conversionResult + requestedUnit);
			
		}
		
		else if (currentUnit.equals("c") && requestedUnit.equals("k")) {
			
			conversionResult = valuePart + 273.15;
			System.out.println(conversionResult + requestedUnit);
			
		}
		
		else if (currentUnit.equals("f") && requestedUnit.equals("c")) {
			
			fToC1 = valuePart - 32;
			fToC2 = fToC1 * conversionValue;
			conversionResult = fToC2;
			System.out.println(conversionResult + requestedUnit);
			
		}
		
		else if (currentUnit.equals("f") && requestedUnit.equals("k")) {
			
			fToK1 = valuePart + 459.67;
			fToK2 = fToK1 * conversionValue;
			conversionResult = fToK2;
			System.out.println(conversionResult + requestedUnit);
			
		}
		
		else if (currentUnit.equals("k") && requestedUnit.equals("f")) {
			
			kToF1 = valuePart * conversionValue2;
			kToF2 = kToF1 - 459.67;
			conversionResult = kToF2;
			System.out.println(conversionResult + requestedUnit);
			
		}
		
		else if (currentUnit.equals("k") && requestedUnit.equals("c")) {
			
			conversionResult = valuePart - 273.15;
			System.out.println(conversionResult + requestedUnit);
			
		}
		
		else {
			
			System.out.println("Invalid Request.");
			
			String userRequest;
			Scanner input = new Scanner(System.in);
		
			System.out.println("Enter your conversion request: ");
			userRequest = input.nextLine();
		
			datConverter disConverter = new datConverter();
			disConverter.conversion(userRequest);
			
		}
		
	}
	
	public static void main(String[] args) {
		
		String userRequest;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter your conversion request: ");
		userRequest = input.nextLine();
		
		datConverter disConverter = new datConverter();
		disConverter.conversion(userRequest);
		
	}
	
}