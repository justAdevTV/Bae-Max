package com.team4element.library;

public class BangBangController {

	private double m_setPoint = 0;
	private double m_plusSetPoint;
	private double m_minusSetPoint;
	private double m_forwardOutput;
	private double m_backwardOutput;
	private double m_tollerance;

	public BangBangController() {

		m_forwardOutput = .5;
		m_backwardOutput = -.5;
	}

	public void setOutput(double output) {
		if (output > 1) {
			output = 1;
		} else if (output < -1) {
			output = -1;
		}

		m_forwardOutput = output;
		m_backwardOutput = -output;
	}

	public double getBackwardOutput() {
		return m_backwardOutput;
	}

	public void setBackwardOutput(double backwardOutput) {
		if (backwardOutput > 1) {
			backwardOutput = 1;
		} else if (backwardOutput < -1) {
			backwardOutput = -1;
		}

		m_backwardOutput = backwardOutput;
	}

	public double getForwardOutput() {
		return m_forwardOutput;
	}

	public void setForwardOutput(double forwardOutput) {
		if (forwardOutput > 1) {
			forwardOutput = 1;
		} else if (forwardOutput < -1) {
			forwardOutput = -1;
		}

		m_forwardOutput = forwardOutput;
	}

	public void setAbsoluteTolerance(double tolerance) {
		m_tollerance = tolerance;
	}

	public void setPercentTolerance(double tolerance) {
		tolerance /= 100;

		if (tolerance > 1) {
			tolerance = 1;
		} else if (tolerance < -1) {
			tolerance = -1;
		}
		m_tollerance = m_setPoint * tolerance;
	}

	public void setSetPoint(double setPoint) {
		m_setPoint = setPoint;
		m_forwardOutput = setPoint + m_tollerance;
		m_backwardOutput = setPoint - m_tollerance;
	}

	public double getSetPoint() {
		return m_setPoint;
	}

	public double getOutput(double input) {
		if (input < m_minusSetPoint) {
			return m_forwardOutput;
		} else if (input > m_plusSetPoint) {
			return m_backwardOutput;
		} else {
			return 0;
		}
	}

}
