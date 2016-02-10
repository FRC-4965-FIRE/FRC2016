package org.usfirst.frc.team4965.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {
    public static Intake instance;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private Intake()
	{
		
	}
	
	public static Intake getInstance()
	{
		if(instance == null)
    		instance = new Intake();
    	
    	return instance;
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

