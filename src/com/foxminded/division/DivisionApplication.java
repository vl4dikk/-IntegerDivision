package com.foxminded.division;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.foxminded.division.formatters.DivisionFormatter;

public class DivisionApplication {

	public static void main(String[] args) throws IOException{
		System.out.println("Enter the divident: ");
		final Integer divident = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		System.out.println("Enter the divider: ");	
		final Integer divider = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		
		DivisionFormatter formatter = new DivisionFormatter();
		System.out.println("Result: ");
		System.out.println(formatter.makeDivision(divident, divider));

	}

}
