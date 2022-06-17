package com.foxminded.division.formatters;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.foxminded.division.processors.DivisionProcessor;

class JsonFormatterTest {
	DivisionProcessor processor = new DivisionProcessor();
	Formatter jsonFormatter = new JsonFormatter();

	@Test
	void testArithmeticExceptin_ShouldThrowArithmeticException_WhenDivisorIsZero() {
		assertThrows(ArithmeticException.class,() -> jsonFormatter.format(7, 0, processor.divide(7, 0)));
	}
	
	@Test
	void testDividing_ShouldResultOfDividing_WhenDividentIsBiggerThanDivisor() {
		String expected = "{\r\n"
				+ "  \"dividend\" : 78945,\r\n"
				+ "  \"divider\" : 4,\r\n"
				+ "  \"result\" : 19736,\r\n"
				+ "  \"iterations\" : [ {\r\n"
				+ "    \"dividend\" : 7,\r\n"
				+ "    \"subtrahend\" : 4\r\n"
				+ "  }, {\r\n"
				+ "    \"dividend\" : 38,\r\n"
				+ "    \"subtrahend\" : 36\r\n"
				+ "  }, {\r\n"
				+ "    \"dividend\" : 29,\r\n"
				+ "    \"subtrahend\" : 28\r\n"
				+ "  }, {\r\n"
				+ "    \"dividend\" : 14,\r\n"
				+ "    \"subtrahend\" : 12\r\n"
				+ "  }, {\r\n"
				+ "    \"dividend\" : 25,\r\n"
				+ "    \"subtrahend\" : 24\r\n"
				+ "  }, {\r\n"
				+ "    \"dividend\" : 1,\r\n"
				+ "    \"subtrahend\" : null\r\n"
				+ "  } ]\r\n"
				+ "}";
		assertEquals(expected, jsonFormatter.format(78945, 4, processor.divide(78945, 4)));
	}
	
	@Test
	void testDividingWithSmallNumbers_ShouldReturnDividing_WhenDividendAndDivisorAreSmallNumbers() {
		assertEquals("{\r\n"
				+ "  \"dividend\" : 12,\r\n"
				+ "  \"divider\" : 4,\r\n"
				+ "  \"result\" : 3,\r\n"
				+ "  \"iterations\" : [ {\r\n"
				+ "    \"dividend\" : 12,\r\n"
				+ "    \"subtrahend\" : 12\r\n"
				+ "  }, {\r\n"
				+ "    \"dividend\" : 0,\r\n"
				+ "    \"subtrahend\" : null\r\n"
				+ "  } ]\r\n"
				+ "}", jsonFormatter.format(12, 4, processor.divide(12, 4)));
	}

}
