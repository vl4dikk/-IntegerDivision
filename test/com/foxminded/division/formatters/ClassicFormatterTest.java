package com.foxminded.division.formatters;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.foxminded.division.processors.DivisionProcessor;

class ClassicFormatterTest {
	
    DivisionProcessor processor = new DivisionProcessor();
    Formatter classicFormatter = new ClassicFormatter();
	
	@Test
	void testArithmeticExceptin_ShouldThrowArithmeticException_WhenDivisorIsZero() {
		assertThrows(ArithmeticException.class,() -> classicFormatter.format(7, 0, processor.divide(7, 0)));
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

}
