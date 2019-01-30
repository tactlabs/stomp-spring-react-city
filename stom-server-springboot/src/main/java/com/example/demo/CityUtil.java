package com.example.demo;

import java.util.Random;

public class CityUtil {

	// https://en.wikipedia.org/wiki/List_of_largest_cities
	public static String[] COLOR_CODES = {		
		"Chongqing",
		"Shanghai",
		"Beijing",
		"Lagos",
		"Dhaka",
		"Mumbai",
		"Chengdu",
		"Karachi",
		"Guangzhou",
		"Istanbul",
		"Tokyo",
		"Tianjin",
		"Moscow",
		"Kinshasa",
	};
	
	private static Random random = new Random();
	
	public static Integer getRandomNumber(Integer min, Integer max){
		return random.nextInt(max - min + 1) + min;
	}

	public static String getRandomCity(){
		
		Integer rNo = getRandomNumber(0, COLOR_CODES.length-1);
		
		return COLOR_CODES[rNo];
	}
	
	public static void main1(String[] args){
		String cCode = getRandomCity();
		
		System.out.println();
	}
}
