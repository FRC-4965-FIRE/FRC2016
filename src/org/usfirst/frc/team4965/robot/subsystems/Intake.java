package org.usfirst.frc.team4965.robot.subsystems;

import org.usfirst.frc.team4965.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {
    public static Intake instance;
    Victor intakeArm, intakeRoller;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private Intake()
	{
		intakeArm = new Victor(RobotMap.IntakeArm);
		intakeRoller = new Victor(RobotMap.IntakeRoller);
	}
	
	public static Intake getInstance()
	{
		if(instance == null)
    		instance = new Intake();
    	
    	return instance;
	}
	
	void moveArm(double speed)
	{
		intakeArm.set(speed);
	}
	
	void spinIntake(double speed)
	{
		intakeRoller.set(speed);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

