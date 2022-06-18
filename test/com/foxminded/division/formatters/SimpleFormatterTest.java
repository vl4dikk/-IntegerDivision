package com.foxminded.division.formatters;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.foxminded.division.processors.DivisionProcessor;

class SimpleFormatterTest {
	DivisionProcessor processor = new DivisionProcessor();
    Formatter simpleFormatter = new SimpleFormatter();

	@Test
	void testArithmeticExceptin_ShouldThrowArithmeticException_WhenDivisorIsZero() {
		assertThrows(ArithmeticException.class,() -> simpleFormatter.format(7, 0, processor.divide(7, 0)));
	}
	
	@Test
	void testDividingWhenDivisorIsBiggerThanDividend_ShouldReturnSimpleDividing_WhenDivisorIsBiggerThanDividend() {
		assertEquals("8/10=0.8", simpleFormatter.format(8, 10, processor.divide(8, 10)));
	}
}
