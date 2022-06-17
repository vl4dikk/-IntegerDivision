package com.foxminded.division.processors;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.foxminded.division.formatters.ClassicFormatter;
import com.foxminded.division.formatters.JsonFormatter;
import com.foxminded.division.formatters.PlainTextFormatter;
import com.foxminded.division.formatters.SimpleFormatter;

class FormatterResolverTest {

	@Test
	void testChoosingClassicFormatter_ShouldReturnNewClassicFormatter_WhenDividentIsBiggerThanDivisorAndChoiceIsOne() {
		assertEquals(new FormatterResolver().getFormatter(78945, 4, 1).getClass(), ClassicFormatter.class);
		;
	}
	
	@Test
	void testChoosingPlainTextFormatter_ShouldReturnNewPlainTextFormatter_WhenDividentIsBiggerThanDivisorAndChoiceIsOne() {
		assertEquals(new FormatterResolver().getFormatter(78945, 4, 2).getClass(), PlainTextFormatter.class);
		;
	}
	
	@Test
	void testChoosingJsonFormatter_ShouldReturnNewJsonFormatter_WhenDividentIsBiggerThanDivisorAndChoiceIsOne() {
		assertEquals(new FormatterResolver().getFormatter(78945, 4, 3).getClass(), JsonFormatter.class);
		;
	}
	
	@Test
	void testOfSimpleFormatter_ShouldReturnNewSimpleFormatter_WhenDividentIsSmallerThanDivisor() {
		assertEquals(new FormatterResolver().getFormatter(3, 4, 1).getClass(), SimpleFormatter.class);
		;
	}
}
