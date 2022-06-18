package com.foxminded.division.formatters;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.foxminded.division.dto.DivisionDto;
import com.foxminded.division.processors.DivisionStep;

public class JsonFormatter implements Formatter{

	@Override
	public String format(Integer dividend, Integer divisor, List<DivisionStep> steps) {
		DivisionDto json = new DivisionDto();
		json.setDividend(dividend);
		json.setDivider(divisor);
		json.setResult(dividend/divisor);
		json.setIterations(steps);
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "";
		}
	}

}
