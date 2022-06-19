package com.foxminded.division.formatters;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.foxminded.division.processors.DivisionStep;

class JsonFormatterTest {
	private List<DivisionStep> steps = Arrays.asList(new DivisionStep(7, 4), new DivisionStep(38, 36),
			new DivisionStep(29, 28), new DivisionStep(14, 12), new DivisionStep(25, 24), new DivisionStep(1, null));
	Formatter jsonFormatter = new JsonFormatter();

	@Test
	void testDividing_ShouldResultOfDividing_WhenDividentIsBiggerThanDivisor() {
		String expected = "{\r\n" + "  \"dividend\" : 78945,\r\n" + "  \"divider\" : 4,\r\n"
				+ "  \"result\" : 19736,\r\n" + "  \"iterations\" : [ {\r\n" + "    \"dividend\" : 7,\r\n"
				+ "    \"subtrahend\" : 4\r\n" + "  }, {\r\n" + "    \"dividend\" : 38,\r\n"
				+ "    \"subtrahend\" : 36\r\n" + "  }, {\r\n" + "    \"dividend\" : 29,\r\n"
				+ "    \"subtrahend\" : 28\r\n" + "  }, {\r\n" + "    \"dividend\" : 14,\r\n"
				+ "    \"subtrahend\" : 12\r\n" + "  }, {\r\n" + "    \"dividend\" : 25,\r\n"
				+ "    \"subtrahend\" : 24\r\n" + "  }, {\r\n" + "    \"dividend\" : 1,\r\n"
				+ "    \"subtrahend\" : null\r\n" + "  } ]\r\n" + "}";
		assertEquals(expected, jsonFormatter.format(78945, 4, steps));
	}

}
