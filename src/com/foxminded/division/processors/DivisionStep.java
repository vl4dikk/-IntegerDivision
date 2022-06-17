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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dividend == null) ? 0 : dividend.hashCode());
		result = prime * result + ((subtrahend == null) ? 0 : subtrahend.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DivisionStep other = (DivisionStep) obj;
		if (dividend == null) {
			if (other.dividend != null)
				return false;
		} else if (!dividend.equals(other.dividend))
			return false;
		if (subtrahend == null) {
			if (other.subtrahend != null)
				return false;
		} else if (!subtrahend.equals(other.subtrahend))
			return false;
		return true;
	}

}
