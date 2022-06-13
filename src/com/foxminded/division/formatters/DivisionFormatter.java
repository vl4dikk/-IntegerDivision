package com.foxminded.division.formatters;

import java.util.List;

public class DivisionFormatter {

	public void modifyResultToView(Integer dividend, Integer divisor, List<String> result) {
		StringBuilder quotient = new StringBuilder();
		quotient.append(dividend / divisor);
		StringBuilder divider = new StringBuilder();
		for (int i = 0; i < quotient.length(); i++) {
			divider.append("-");
		}
		result.set(0, "_" + dividend + "|" + divisor);
		int spaceLength = (dividend.toString().length() + 1) - result.get(1).length();
		if (spaceLength > 0) {
			result.set(1, String.format(result.get(1) + "%" + spaceLength + "s" + "|" + divider.toString(), ""));
			result.set(2, String.format(result.get(2) + "%" + spaceLength + "s" + "|" + quotient.toString(), ""));
		} else {
			result.set(1, String.format(result.get(1) + "|" + divider.toString(), ""));
			result.set(2, String.format(result.get(2) + "|" + quotient.toString(), ""));
		}
	}

}
