package com.foxminded.division.formatters;

import java.util.List;

import com.foxminded.division.processors.DivisionStep;

public class ClassicFormatter implements Formatter {

	@Override
	public String format(Integer dividend, Integer divisor, List<DivisionStep> steps) {
		if(dividend < divisor) {
			return dividend + "/" + divisor + "=" + (double)dividend/divisor;
		}
		StringBuilder formatedResult = new StringBuilder();
		formatedResult.append(formatHead(dividend, divisor, steps));
		formatedResult.append(formatBodyItem(steps));
		return formatedResult.toString();
	}
		
		
	private String formatHead(Integer dividend, Integer divisor, List<DivisionStep> steps) {
		String answer = Integer.toString(dividend/divisor);
		StringBuilder border = new StringBuilder();
		StringBuilder head = new StringBuilder();
		for (int i = 0; i < answer.length(); i++) {
			border.append("-");
		}

		head.append("_").append(dividend).append("|").append(divisor).append("\n");
		head.append(" ").append(steps.get(0).getSubtrahend()).append(addSymbols((dividend.toString().length()-steps.get(0).getSubtrahend().toString().length()), ' ')).append("|").append(border.toString()).append("\n");
		head.append(" ").append(addSymbols(steps.get(0).getSubtrahend().toString().length(), '-')).append(addSymbols((dividend.toString().length()-steps.get(0).getSubtrahend().toString().length()), ' ')).append("|").append(answer).append("\n");
		return head.toString();
	}
	
	private String formatBodyItem (List<DivisionStep> steps) {
		StringBuilder result = new StringBuilder();
		for(int i = 1; i < steps.size(); i++) {
			if(i < steps.size()-1) {
			 String lastReminder = String.format("%" + (i + 2) + "s", "_" + steps.get(i).getDividend().toString());
             result.append(lastReminder).append("\n");

             String multiply = String.format("%" + (i + 2) + "d", steps.get(i).getSubtrahend());
             result.append(multiply).append("\n");

             Integer tab = lastReminder.length() - calculateDigit(steps.get(i).getSubtrahend());
             result.append(makeDivider(steps.get(i).getDividend(), tab)).append("\n");
			}else if(i == steps.size()-1) {
				if (i > 1) {
					result.append(String.format("%" + (i + 1) + "s", steps.get(i).getDividend().toString())).append("\n");
				}else
				 result.append(String.format("%" + (i + 2) + "s", steps.get(i).getDividend().toString())).append("\n");
			}
		}
			
		return result.toString();
	}
	
	 private String makeDivider(Integer reminderNumber, Integer tab) {
	        return addSymbols(tab, ' ') + addSymbols(calculateDigit(reminderNumber), '-');
	    }
	   
	 private String addSymbols(int numberOfSymbols, char symbol) {
	        StringBuilder string = new StringBuilder();
	        for (int i = 0; i < numberOfSymbols; i++) {
	            string.append(symbol);
	        }
	        return string.toString();
	 }
	 private int calculateDigit(int i) {
	        return (int) Math.log10(i) + 1;
	    }
	


}

