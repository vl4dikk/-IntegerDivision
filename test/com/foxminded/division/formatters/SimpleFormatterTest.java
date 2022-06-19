package com.foxminded.division.formatters;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.foxminded.division.processors.DivisionStep;

class SimpleFormatterTest {
	private List<DivisionStep> steps = Arrays.asList(new DivisionStep(8, 10));
	Formatter simpleFormatter = new SimpleFormatter();

	@Test
	void testDividingWhenDivisorIsBiggerThanDividend_ShouldReturnSimpleDividing_WhenDivisorIsBiggerThanDividend() {
		assertEquals("8/10=0.8", simpleFormatter.format(8, 10, steps));
	}
}
