package com.foxminded.division.processors;

import java.util.ArrayList;

public class DivisionProcessor {

	public ArrayList<DivisionStep> divide(int dividend, int divisor) throws ArithmeticException {
		ArrayList<DivisionStep> iterations = new ArrayList<>();
		StringBuilder reminder = new StringBuilder();
		
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);

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
				
				iterations.add(new DivisionStep(reminderNumber, multiplyResult));

				reminder.replace(0, reminder.length(), Integer.toString(mod));
				reminderNumber = Integer.parseInt(reminder.toString());
			}
			if (i == digits.length - 1) {
				iterations.add(new DivisionStep(reminderNumber));
			}
		}
		return iterations;
	}

	
}
