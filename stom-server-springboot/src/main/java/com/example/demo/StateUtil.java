package com.example.demo;

import java.util.Random;

public class StateUtil {

	// https://en.wikipedia.org/wiki/List_of_largest_cities
	public static String[] COLOR_CODES = {		
		"China",
		"India",
		"United States",
		"Indonesia",
		"Brazil",
		"Pakistan",
		"Nigeria",
		"Bangladesh",
		"Russia",
		"Mexico",
		"Japan",
		"Ethiopia",
		"Philippines",
		"Egypt"
	};
	
	private static Random random = new Random();
	
	public static Integer getRandomNumber(Integer min, Integer max){
		return random.nextInt(max - min + 1) + min;
	}

	public static String getRandomState(){
		
		Integer rNo = getRandomNumber(0, COLOR_CODES.length-1);
		
		return COLOR_CODES[rNo];
	}
	
	public static void main1(String[] args){
		String cCode = getRandomState();
		
		System.out.println();
	}
}
