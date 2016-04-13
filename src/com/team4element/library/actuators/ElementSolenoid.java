package com.team4element.library.actuators;

import edu.wpi.first.wpilibj.Solenoid;

public class ElementSolenoid extends Solenoid{

	public ElementSolenoid(int channel) {
		super(channel);
	}
	
	public ElementSolenoid(int moduleNumber, int channel) {
		super(moduleNumber, channel);
	}
	
}
