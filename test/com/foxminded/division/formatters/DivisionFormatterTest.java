package com.foxminded.division.formatters;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.foxminded.division.processors.DivisionProccesor;

class DivisionFormatterTest {
	
    DivisionProccesor format = new DivisionProccesor();
	
	@Test
	void testArithmeticExceptin_ShouldThrowArithmeticException_WhenDivisorIsZero() {
		assertThrows(ArithmeticException.class,() -> format.makeDivision(7, 0));
	}
	
	@Test
	void testDividingWhenDivisorIsBiggerThanDividend_ShouldReturnSimpleDividing_WhenDivisorIsBiggerThanDividend() {
		assertEquals("-8/4=0", format.makeDivision(-8, 4));
	}
	
	@Test
	void testDividing_ShouldResultOfDividing_WhenDividentIsBiggerThanDivisor() {
		String expected = "_78945│4\n"
	                    + " 4    │-----\n"
				        + " -    │19736\n"
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
		assertEquals(expected, format.makeDivision(78945, 4));
	}
	
	@Test
	void testDividingWithSmallNumbers_ShouldReturnDividing_WhenDividendAndDivisorAreSmallNumbers() {
		assertEquals("_12│4\n"
				   + " 12│-\n"
				   + " --│3\n"
				   + "  0\n", format.makeDivision(12, 4));
	}

}
