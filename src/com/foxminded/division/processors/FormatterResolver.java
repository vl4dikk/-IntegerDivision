package com.foxminded.division.processors;

import com.foxminded.division.formatters.ClassicFormatter;
import com.foxminded.division.formatters.Formatter;
import com.foxminded.division.formatters.JsonFormatter;
import com.foxminded.division.formatters.PlainTextFormatter;
import com.foxminded.division.formatters.SimpleFormatter;
import com.foxminded.division.formatters.UnknownFormatter;

public class FormatterResolver {
	public Formatter getFormatter(int dividend, int divisor, int choice) {
		if(divisor == 0 || dividend < 0 && divisor < 0) {
			throw new ArithmeticException("Divisor cannot be zero");
		}
		if(dividend < divisor) {
			return new SimpleFormatter();
		}
		if(choice == 1) {
			return new ClassicFormatter();
		}else if(choice == 2) {
			return new PlainTextFormatter();
		}else if (choice == 3) {
			return new JsonFormatter();
		}else 
			return new UnknownFormatter();
	}

}
