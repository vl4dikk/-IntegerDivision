package com.foxminded.division.formatters;


public class DivisionFormatter {
	private StringBuilder result = new StringBuilder();
	private StringBuilder quotient = new StringBuilder();
	private StringBuilder reminder = new StringBuilder();

	public String makeDivision(int dividend, int divisor) {
		quotient.append(dividend/divisor);

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

				String numberToSubstract = String.format("%" + (i + 2) + "s", "_" + reminderNumber.toString());
				result.append(numberToSubstract).append("\n");

				String subtractor = String.format("%" + (i + 2) + "d", multiplyResult);
				result.append(subtractor).append("\n");

				Integer tab = numberToSubstract.length() - calculateDigit(multiplyResult);
				result.append(makeDivider(multiplyResult, tab)).append("\n");

				reminder.replace(0, reminder.length(), mod.toString());
				reminderNumber = Integer.parseInt(reminder.toString());
			} 

			if (i == digits.length - 1) {
				result.append(String.format("%" + (i + 2) + "s", reminderNumber.toString())).append("\n");
			}
		}
		modifyResultToView(dividend, divisor);
		return result.toString();
	}

	private String makeDivider(Integer reminderNumber, Integer tab) {
		return addSymbols(tab, ' ') + addSymbols(calculateDigit(reminderNumber), '-');
	}

	private void modifyResultToView(Integer dividend, Integer divisor) {
		int[] index = new int[3];
		for (int i = 0, j = 0; i < result.length(); i++) {
			if (result.charAt(i) == '\n') {
				index[j] = i;
				j++;
			}

			if (j == 3) {
				break;
			}
		}

		int tab = calculateDigit(dividend) + 1 - index[0];
		result.insert(index[2], addSymbols(tab, ' ') + "│" + quotient.toString());
		result.insert(index[1], addSymbols(tab, ' ') + "│" + addSymbols(quotient.length(), '-'));
		result.insert(index[0], "│" + divisor);
		result.replace(1, index[0], dividend.toString());
	}

	private int calculateDigit(int i) {
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
