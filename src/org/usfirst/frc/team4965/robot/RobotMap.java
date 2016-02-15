package org.usfirst.frc.team4965.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	//pwm 
	public static final int PWM_ZERO  = 0;
	public static final int PWM_ONE   = 1;
	public static final int PWM_TWO   = 2;
	public static final int PWM_THREE = 3;
	public static final int PWM_FOUR  = 4;
	public static final int PWM_FIVE  = 5;
	public static final int PWM_SIX   = 6;
	public static final int PWM_SEVEN = 7;
	
	//drivetrain
	public static final int FrontLeft  = PWM_ZERO;
	public static final int BackLeft   = PWM_ONE;
	public static final int FrontRight = PWM_TWO;
	public static final int BackRight  = PWM_THREE;
	
	//launcher
	public static final int LauncherLeft  = PWM_FOUR;
	public static final int LauncherRight = PWM_FIVE;
	
	//intake
	public static final int IntakeArm    = PWM_SIX;
	public static final int IntakeRoller = PWM_SEVEN;
}
