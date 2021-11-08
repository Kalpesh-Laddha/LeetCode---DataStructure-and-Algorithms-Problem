package com.coding.practice.sample.example;

/***
 *Question - 
 *	Given two non-negative integers num1 and num2 represented as strings, 
 *		  return the product of num1 and num2, also represented as a string.
 *
 *Note -
 *	You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 * Time Complexity: O(M*N) --> We will visit each pair of digits in both numbers.
 * Space Complexity: O(M+N) --> Needed by temporary array and StringBuilder
 *  	
 */
public class Multiply_String_43 {

	public static void main(String[] args) {
		String num1 = "123";
		String num2 = "456";
		
		System.out.println( multiply2String(num1,num2));
	}

	private static String multiply2String(String num1, String num2) {

		// check the basic condition
		int num1Length = num1.length();
		int num2Length = num2.length();
		if(num1Length == 0 || num2Length == 0 || "0".equals(num1) || "0".equals(num2)) {
			return "0";
		}

		if(num1Length == 1 && num1.charAt(0) == '1')
			return num2;

		if(num2Length == 1 && num2.charAt(0) == '1')
			return num1;

		int arr []  = new int[num2Length+num1Length];

		for(int i=num1Length-1; i>=0; i--) {
			for(int j=num2Length-1; j>=0; j--) {
				int product = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');

				product = product + arr[i+j+1];

				arr[i+j+1] = product % 10;
				arr[i+j] = arr[i+j] + product / 10;

			}
		}

		StringBuilder build = new StringBuilder();

		for(int i : arr) {
			if(build.length() == 0 && i ==0) {
				continue;
			}
			build.append(i);
		}

		return build.toString();
	}
}
