package com.foxminded.division.formatters;

import java.util.List;

import com.foxminded.division.processors.DivisionStep;

public class SimpleFormatter implements Formatter{

	@Override
	public String format(Integer dividend, Integer divisor, List<DivisionStep> steps) {
		// TODO Auto-generated method stub
		return dividend + "/" + divisor + "=" + (double)dividend/divisor;
	}

}
