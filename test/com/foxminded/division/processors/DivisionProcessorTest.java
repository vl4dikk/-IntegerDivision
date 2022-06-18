package com.foxminded.division.processors;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class DivisionProcessorTest {
	 DivisionProcessor processor = new DivisionProcessor();

	@Test
	void testArithmeticExceptin_ShouldThrowArithmeticException_WhenDivisorIsZero() {
		assertThrows(ArithmeticException.class,() -> processor.divide(7, 0));
	}
	
	@Test
	void testDividing_ShouldResultOfDividing_WhenDividentIsBiggerThanDivisor() {
		List<DivisionStep> expected = new ArrayList<DivisionStep>();
		expected.add(new DivisionStep(7, 4));
		expected.add(new DivisionStep(38, 36));
		expected.add(new DivisionStep(29, 28));
		expected.add(new DivisionStep(14, 12));
		expected.add(new DivisionStep(25, 24));
		expected.add(new DivisionStep(1));
		assertEquals(expected, processor.divide(78945, 4));
	}
	
	@Test
	void testDividingWithSmallNumbers_ShouldReturnListOfDivisionSteps_WhenDividendAndDivisorAreSmallNumbers() {
		List<DivisionStep> expected = new ArrayList<DivisionStep>();
		expected.add(new DivisionStep(12, 12));
		expected.add(new DivisionStep(0));
		assertEquals(expected, processor.divide(12, 4));
	}

}
