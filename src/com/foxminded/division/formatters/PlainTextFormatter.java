package com.foxminded.division.formatters;

import java.util.List;

import com.foxminded.division.processors.DivisionStep;

public class PlainTextFormatter implements Formatter {

	@Override
	public String format(Integer dividend, Integer divisor, List<DivisionStep> steps) {
		String answer = Integer.toString(dividend/divisor);
		StringBuilder resultBuilder = new StringBuilder();
		resultBuilder.append(dividend + ";" + divisor + ";" + answer + "\n");
		for(int i = 0; i < steps.size(); i++) {
			if(steps.get(i).getSubtrahend() == null) {
				resultBuilder.append(steps.get(i).getDividend());
			}else 
			resultBuilder.append(steps.get(i).getDividend()).append(";").append(steps.get(i).getSubtrahend()).append("\n");
		}
		return resultBuilder.toString();
	}

}
