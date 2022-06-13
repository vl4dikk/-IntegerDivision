package com.foxminded.division;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.foxminded.division.processors.DivisionProccesor;

public class DivisionApplication {

	public static void main(String[] args) throws IOException {
		System.out.println("Enter the divident: ");
		final Integer dividend = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		System.out.println("Enter the divider: ");
		final Integer divisor = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

		DivisionProccesor formatter = new DivisionProccesor();
		System.out.println("Result: ");
		System.out.println(formatter.divide(dividend, divisor));

	}

}
