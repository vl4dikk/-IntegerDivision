package com.foxminded.division.formatters;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.foxminded.division.processors.DivisionProcessor;

class PlainTextFormatterTest {
	 DivisionProcessor processor = new DivisionProcessor();
	 Formatter plainTextFormatter = new PlainTextFormatter();

	@Test
	void testArithmeticExceptin_ShouldThrowArithmeticException_WhenDivisorIsZero() {
		assertThrows(ArithmeticException.class,() -> plainTextFormatter.format(7, 0, processor.divide(7, 0)));
	}
	
	@Test
	void testDividing_ShouldResultOfDividing_WhenDividentIsBiggerThanDivisor() {
		String expected = "78945;4;19736\n"
				        + "7;4\n"
				        + "38;36\n"
				        + "29;28\n"
				        + "14;12\n"
				        + "25;24\n"
				        + "1";
		assertEquals(expected, plainTextFormatter.format(78945, 4, processor.divide(78945, 4)));
	}
	
	@Test
	void testDividingWithSmallNumbers_ShouldReturnDividing_WhenDividendAndDivisorAreSmallNumbers() {
		assertEquals("12;4;3\n"
				    + "12;12\n"
				    + "0", plainTextFormatter.format(12, 4, processor.divide(12, 4)));
	}
}
