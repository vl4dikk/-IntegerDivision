package com.foxminded.division.formatters;

import java.util.List;

import com.foxminded.division.processors.DivisionStep;

public interface Formatter {
	public String format (Integer dividend, Integer divisor, List<DivisionStep> steps);
}
