package com.coding.practice.sample.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Question - 
 * 	Given a string s. An awesome substring is a non-empty substring of s such that we can make any number of swaps in 
 * 		order to make it palindrome.Return the length of the maximum length awesome substring of s.
 *  
 *  Example1 - 
 *  Input: s = "3242415"
 *  Output: 5
 *  Explanation: "24241" is the longest awesome substring, we can form the palindrome "24142" with some swaps.
 * 
 */
public class Find_Longest_Awesome_Substring_1542 {

	public static void main(String[] args) {

		System.out.println(longestAwesomeSubString("9498331")); //9933481 = 93139
	}

	private static int longestAwesomeSubString(String string) {

		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0; i<string.length();i++) {
			if(map.containsKey(string.charAt(i))) {
				map.put(string.charAt(i), map.get(string.charAt(i))+1);
			}
			map.putIfAbsent(string.charAt(i), 1);
		}

		for(Character c1 : map.keySet()) {
			int value = map.get(c1);
			if(value > 1) {
				if(value % 2 == 0 ) {
					list1.add(value);
				}else {
					list1.add(value-1);
				}

			}else {
				list2.add(map.get(c1));
			}
		}

		if(list1.size() == 0)
			return 0;

		if(list2.size() == 0) 
			return list1.stream().mapToInt(Integer::intValue).sum();

		return list1.stream().mapToInt(Integer::intValue).sum()+1;
	}
}
