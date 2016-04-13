package com.team4element.library.utilities;

public class JerkFilter {

	private double m_lastInput = 0;
	private double m_changeMax = 0.25;
	private double m_changeMin = 0.25;

	public JerkFilter() {
		m_lastInput = 0;
	}

	public double filter(double currentInput) {

		currentInput = filterInputs(currentInput, m_lastInput);
		m_lastInput = currentInput;
		return currentInput;

	}

	public void setMaxRateOfChange(double changeMax) {
		this.m_changeMax = changeMax;
	}

	public void setMinRateOfChange(double changeMin) {
		this.m_changeMin = changeMin;
	}

	public double getMaxRateOfChange() {
		return m_changeMax;
	}

	public double getMinRateOfChange() {
		return m_changeMin;
	}
	
	public double getLastInput(){
		return m_lastInput;
	}

	private double filterInputs(double input, double lastSpeed) {

		int sign = (int) Math.signum(input);

		input = Math.abs(input);
		lastSpeed = Math.abs(lastSpeed);
		if (input > lastSpeed + m_changeMax) {
			input = lastSpeed + m_changeMax;
		} else if (input < lastSpeed - m_changeMin) {
			input = lastSpeed - m_changeMin;
		}

		return input * sign;
	}
	
}
