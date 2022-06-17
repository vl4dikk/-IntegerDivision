package com.foxminded.division.dto;

import java.util.List;

import com.foxminded.division.processors.DivisionStep;

public class DivisionDto {
	private int dividend;
	private int divider;
	private int result;
	private List<DivisionStep> iterations;

	public int getDividend() {
		return dividend;
	}

	public void setDividend(int dividend) {
		this.dividend = dividend;
	}

	public int getDivider() {
		return divider;
	}

	public void setDivider(int divider) {
		this.divider = divider;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public List<DivisionStep> getIterations() {
		return iterations;
	}

	public void setIterations(List<DivisionStep> iterations) {
		this.iterations = iterations;
	}

}
