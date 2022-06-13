package com.foxminded.division.formatters;

import java.util.ArrayList;

public class DivisionFormatter {
	
	public void modifyResultToView(Integer dividend, Integer divisor, ArrayList<String> result) {
		StringBuilder quotient = new StringBuilder();
		StringBuilder firstString = new StringBuilder(result.get(0));
		StringBuilder secondString = new StringBuilder(result.get(1));
		StringBuilder thirdString = new StringBuilder(result.get(2));
		quotient.append(dividend/divisor);
		

		int tab = calculateDigitLength(dividend) + 1 - index[0];
		result.insert(index[2], addSymbols(tab, ' ') + "│" + quotient.toString());
		result.insert(index[1], addSymbols(tab, ' ') + "│" + addSymbols(quotient.length(), '-'));
		result.insert(index[0], "│" + divisor);
		result.replace(1, index[0], dividend.toString());
	}


}
