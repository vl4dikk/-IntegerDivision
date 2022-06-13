package com.foxminded.division.processors;

import java.util.ArrayList;

import com.foxminded.division.formatters.DivisionFormatter;

public class DivisionProccesor {

	public String makeDivision(int dividend, int divisor) {
		ArrayList<String> result = new ArrayList<String>();
//		StringBuilder result = new StringBuilder();
		StringBuilder reminder = new StringBuilder();

		if (divisor == 0) {
			throw new ArithmeticException("Divisor cannot be 0");
		}

		if (dividend < divisor || dividend < 0 || divisor < 0) {
			return "" + dividend + "/" + divisor + "=0";
		}
		
		Math.abs(dividend);
		Math.abs(divisor);

		String[] digits = String.valueOf(dividend).split("");
		Integer reminderNumber;
		Integer multiplyResult;
		Integer mod;

		for (int i = 0; i < digits.length; i++) {
			reminder.append(digits[i]);
			reminderNumber = Integer.parseInt(reminder.toString());

			if (reminderNumber >= divisor) {
				mod = reminderNumber % divisor;
				multiplyResult = reminderNumber / divisor * divisor;

				String numberToSubstract = String.format("%" + (i + 2) + "s", "_" + reminderNumber.toString() + "\n");
				result.add(numberToSubstract);

				String subtractor = String.format("%" + (i + 2) + "d", multiplyResult + "\n");
				result.add(subtractor);

				Integer tab = numberToSubstract.length() - calculateDigitLength(multiplyResult);
				result.add(makeDivider(multiplyResult, tab));

				reminder.replace(0, reminder.length(), mod.toString());
				reminderNumber = Integer.parseInt(reminder.toString());
			} 

			if (i == digits.length - 1) {
				result.add(String.format("%" + (i + 2) + "s", reminderNumber.toString()) + "\n");
			}
		}
		DivisionFormatter format = new DivisionFormatter();
		format.modifyResultToView(dividend, divisor, result);
		return result.toString();
	}

	private String makeDivider(Integer reminderNumber, Integer tab) {
		return addSymbols(tab, ' ') + addSymbols(calculateDigitLength(reminderNumber), '-') + "\n";
	}

	private int calculateDigitLength(int i) {
		return String.valueOf(i).length();
	}

	private String addSymbols(int numberOfSymbols, char symbol) {
		StringBuilder string = new StringBuilder();
		for (int i = 0; i < numberOfSymbols; i++) {
			string.append(symbol);
		}
		return string.toString();
	}
}
