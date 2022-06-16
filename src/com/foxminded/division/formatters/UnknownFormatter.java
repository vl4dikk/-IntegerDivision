package com.foxminded.division.formatters;

import java.util.List;

import com.foxminded.division.processors.DivisionStep;

public class UnknownFormatter implements Formatter{

	@Override
	public String format(Integer dividend, Integer divisor, List<DivisionStep> steps) {
		return "Unknown format";
	}

}
