package com.foxminded.division.processors;

public class DivisionStep {
	private Integer dividend;
	private Integer subtrahend;

	public DivisionStep(Integer dividend, Integer subtrahend) {
		this.dividend = dividend;
		this.subtrahend = subtrahend;
	}

	public DivisionStep(Integer dividend) {
		this.dividend = dividend;
	}

	public Integer getDividend() {
		return dividend;
	}

	public void setDividend(Integer dividend) {
		this.dividend = dividend;
	}

	public Integer getSubtrahend() {
		return subtrahend;
	}

	public void setSubtrahend(Integer subtrahend) {
		this.subtrahend = subtrahend;
	}

	@Override
	public String toString() {
		return "DivisionStep [dividend=" + dividend + ", subtrahend=" + subtrahend + "]";
	}

}
