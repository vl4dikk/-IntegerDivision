package com.foxminded.division.formatters;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.foxminded.division.processors.DivisionStep;

class PlainTextFormatterTest {
	private List<DivisionStep> steps = Arrays.asList(new DivisionStep(7, 4), new DivisionStep(38, 36),
			new DivisionStep(29, 28), new DivisionStep(14, 12), new DivisionStep(25, 24), new DivisionStep(1, null));
	Formatter plainTextFormatter = new PlainTextFormatter();

	@Test
	void testDividing_ShouldResultOfDividing_WhenDividentIsBiggerThanDivisor() {
		String expected = "78945;4;19736\n" + "7;4\n" + "38;36\n" + "29;28\n" + "14;12\n" + "25;24\n" + "1";
		assertEquals(expected, plainTextFormatter.format(78945, 4, steps));
	}

}
