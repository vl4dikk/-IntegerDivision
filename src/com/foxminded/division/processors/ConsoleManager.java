package com.foxminded.division.processors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.foxminded.division.formatters.Formatter;

public class ConsoleManager {
	private static final DivisionProcessor divisionProcessor = new DivisionProcessor();
	private static final FormatterResolver resolver = new FormatterResolver();

	public void run() throws IOException {
		InputStreamReader streamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(streamReader);
		try {
			System.out.println("Enter the divident: ");
			final int dividend = Integer.parseInt(bufferedReader.readLine());
			System.out.println("Enter the divider: ");
			final int divisor = Integer.parseInt(bufferedReader.readLine());

			System.out.println("Choose result format:");
			System.out.println("1 Classic format");
			System.out.println("2 PlainText format");
			System.out.println("3 JSON format");
			final int choice = Integer.parseInt(bufferedReader.readLine());
			Formatter formatter = resolver.getFormatter(dividend, divisor, choice);
			System.out.println(formatter.format(dividend, divisor, divisionProcessor.divide(dividend, divisor)));
		} catch (ArithmeticException aex) {
			aex.printStackTrace();
			System.out.println(aex.getLocalizedMessage() + " Try again, please.");
		} catch (Exception ex) {
			System.out.println("Error has been occured: " + ex.getLocalizedMessage());
			ex.printStackTrace();
		} finally {
			System.out.println("Do you want to try again? (Y/n)");
			String confirm = bufferedReader.readLine();
			if (confirm.equalsIgnoreCase("Y")) {
				run();
			} else if (confirm.equalsIgnoreCase("n")) {
				System.out.println("Exiting...");
				bufferedReader.close();
				streamReader.close();
			} else {
				System.out.println("Could not resolve the answer. Exiting...");
				bufferedReader.close();
				streamReader.close();
			}
		}
	}

}
