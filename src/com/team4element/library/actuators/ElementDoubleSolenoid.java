package com.team4element.library.actuators;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class ElementDoubleSolenoid extends DoubleSolenoid{

	public ElementDoubleSolenoid(int forwardChannel, int reverseChannel) {
		super(forwardChannel, reverseChannel);
	}
	
	public ElementDoubleSolenoid(int moduleNumber, int forwardChannel, int reverseChannel) {
		super(moduleNumber, forwardChannel, reverseChannel);
	}

	
	
}
