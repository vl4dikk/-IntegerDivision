package com.foxminded.division.formatters;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.foxminded.division.processors.DivisionProcessor;

class DivisionFormatterTest {
	
    DivisionProcessor processor = new DivisionProcessor();
    Formatter classicFormatter = new ClassicFormatter();
    Formatter plainTextFormatter = new PlainTextFormatter();
    Formatter jsonFormatter = new JsonFormatter();
    Formatter simpleFormatter = new SimpleFormatter();
	
	@Test
	void testArithmeticExceptin_ShouldThrowArithmeticException_WhenDivisorIsZero() {
		assertThrows(ArithmeticException.class,() -> classicFormatter.format(7, 0, processor.divide(7, 0)));
	}
	
	@Test
	void testDividingWhenDivisorIsBiggerThanDividend_ShouldReturnSimpleDividing_WhenDivisorIsBiggerThanDividend() {
		assertEquals("8/10=0.8", simpleFormatter.format(8, 10, processor.divide(8, 10)));
	}
	
	@Test
	void testDividing_ShouldResultOfDividing_WhenDividentIsBiggerThanDivisor() {
		String expected = "_78945|4\n"
				        + " 4    |-----\n"
				        + " -    |19736\n"
				        + "_38\n"
				        + " 36\n"
				        + " --\n"
				        + " _29\n"
				        + "  28\n"
				        + "  --\n"
				        + "  _14\n"
				        + "   12\n"
				        + "   --\n"
				        + "   _25\n"
				        + "    24\n"
				        + "    --\n"
				        + "     1\n";
		assertEquals(expected, classicFormatter.format(78945, 4, processor.divide(78945, 4)));
	}
	
	@Test
	void testDividingWithSmallNumbers_ShouldReturnDividing_WhenDividendAndDivisorAreSmallNumbers() {
		assertEquals("_12|4\n"
				   + " 12|-\n"
				   + " --|3\n"
				   + "  0\n", classicFormatter.format(12, 4, processor.divide(12, 4)));
	}
	
	@Test
	void testPlainTextFormatter_ShouldReturnDividingInPlainText_WhenDividendAndDivisorAreNumbers() {
		assertEquals("78945;4;19736\n"
				+ "7;4\n"
				+ "38;36\n"
				+ "29;28\n"
				+ "14;12\n"
				+ "25;24\n"
				+ "1", plainTextFormatter.format(78945, 4, processor.divide(78945, 4)));
	}

}
