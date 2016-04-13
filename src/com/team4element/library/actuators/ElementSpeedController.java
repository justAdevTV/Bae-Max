package com.team4element.library.actuators;

import edu.wpi.first.wpilibj.SpeedController;

public class ElementSpeedController implements SpeedController {
	protected SpeedController[] m_controllers;
	protected boolean m_invert = false;

	public ElementSpeedController(SpeedController controller) {
		m_controllers = new SpeedController[] { controller };
	}

	public void setInverted(boolean inverted) {
		m_invert = inverted;
	}

	public boolean getInverted() {
		return m_invert;
	}

	protected double sign() {
		return (m_invert ? -1.0 : 1.0);
	}

	@Override
	public void pidWrite(double output) {
		for (SpeedController controller : m_controllers) {
			controller.pidWrite(sign() * output);
		}
	}

	@Override
	public double get() {
		return m_controllers[0].get() * sign();
	}

	@Override
	public void set(double speed, byte syncGroup) {
		for (SpeedController controller : m_controllers) {
			controller.set(speed * sign(), syncGroup);
		}
	}

	@Override
	public void set(double speed) {
		for (SpeedController controller : m_controllers) {
			controller.set(speed * sign());
		}
	}

	@Override
	public void disable() {
		for (SpeedController controller : m_controllers) {
			controller.disable();
		}
	}

	public void stopMotor() {
		for (SpeedController controller : m_controllers) {
			controller.set(0);
		}
	}
}
