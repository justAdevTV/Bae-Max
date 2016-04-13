package com.team4element.library.utilities;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.RumbleType;
import edu.wpi.first.wpilibj.Timer;

public class Rumble {

	private Joystick m_controller;
	private float m_rumbleMagnitude = .75f;
	private double m_timerDelay = .15;
	
	public Rumble(Joystick controller){
		this.m_controller = controller;
	}
	
	public void setRumbleMagnitude(double rumbleMagnitude){
		this.m_rumbleMagnitude = (float) rumbleMagnitude;
	}
	
	public void setRumbleMagnitude(float rumbleMagnitude){
		this.m_rumbleMagnitude = rumbleMagnitude;
	}
	
	public float getRumbleMagnitude(){
		return m_rumbleMagnitude;
	}
	
	public void setTimerDelay(double timerDelay){
		this.m_timerDelay = timerDelay;
	}
	
	public double getTimerDelay(){
		return m_timerDelay;
	}
	
	public void runRumble(){
		m_controller.setRumble(RumbleType.kLeftRumble, m_rumbleMagnitude);
		m_controller.setRumble(RumbleType.kRightRumble, m_rumbleMagnitude);

		Timer.delay(m_timerDelay);

		m_controller.setRumble(RumbleType.kLeftRumble, 0);
		m_controller.setRumble(RumbleType.kRightRumble, 0);
	}
	
}
