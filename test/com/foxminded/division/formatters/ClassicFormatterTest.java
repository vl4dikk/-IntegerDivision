package com.foxminded.division.formatters;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.foxminded.division.processors.DivisionStep;

class ClassicFormatterTest {
	private Formatter classicFormatter = new ClassicFormatter();
	private List<DivisionStep> steps = Arrays.asList(new DivisionStep(7, 4), new DivisionStep(38, 36),
			new DivisionStep(29, 28), new DivisionStep(14, 12), new DivisionStep(25, 24), new DivisionStep(1, null));

	@Test
	void testDividing_ShouldResultOfDividing_WhenDividentIsBiggerThanDivisor() {
		String expected = "_78945|4\n" + " 4    |-----\n" + " -    |19736\n" + "_38\n" + " 36\n" + " --\n" + " _29\n"
				+ "  28\n" + "  --\n" + "  _14\n" + "   12\n" + "   --\n" + "   _25\n" + "    24\n" + "    --\n"
				+ "     1\n";
		assertEquals(expected, classicFormatter.format(78945, 4, steps));
	}

}
