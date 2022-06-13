package com.foxminded.division.processors;

import java.util.ArrayList;

import com.foxminded.division.formatters.DivisionFormatter;

public class DivisionProccesor {

	public String divide(int dividend, int divisor) throws ArithmeticException {
		ArrayList<String> separatedLines = new ArrayList<>();
		StringBuilder reminder = new StringBuilder();

		if (divisor == 0) {
			throw new ArithmeticException("Divisor cannot be 0.");
		}
		if (dividend < divisor || dividend < 0 || divisor < 0) {
			return "" + dividend + "/" + divisor + "=0";
		}

		String[] digits = String.valueOf(dividend).split("");
		int reminderNumber;
		int multiplyResult;
		int mod;

		for (int i = 0; i < digits.length; i++) {
			reminder.append(digits[i]);
			reminderNumber = Integer.parseInt(reminder.toString());

			if (reminderNumber >= divisor) {
				mod = reminderNumber % divisor;
				multiplyResult = reminderNumber / divisor * divisor;

				String numberToSubstract = String.format("%" + (i + 2) + "s", "_" + reminderNumber);
				separatedLines.add(numberToSubstract);

				String subtractor = String.format("%" + (i + 2) + "d", multiplyResult);
				separatedLines.add(subtractor);

				Integer tab = numberToSubstract.length() - calculateDigitLength(multiplyResult);
				separatedLines.add(makeDivider(multiplyResult, tab));

				reminder.replace(0, reminder.length(), Integer.toString(mod));
				reminderNumber = Integer.parseInt(reminder.toString());
			}

			if (i == digits.length - 1) {
				separatedLines.add(String.format("%" + (i + 2) + "s", Integer.toString(reminderNumber)));
			}
		}
		new DivisionFormatter().modifyResultToView(dividend, divisor, separatedLines);
		return String.join("\n", separatedLines);
	}

	private String makeDivider(Integer reminderNumber, Integer tab) {
		return addSymbols(tab, ' ') + addSymbols(calculateDigitLength(reminderNumber), '-');
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
