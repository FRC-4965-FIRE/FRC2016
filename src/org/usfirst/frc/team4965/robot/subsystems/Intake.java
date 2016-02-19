package org.usfirst.frc.team4965.robot.subsystems;

import org.usfirst.frc.team4965.robot.RobotMap;

//import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {
    public static Intake instance;
    VictorSP intakeRoller;
    //DigitalInput intakeIn, intakeOut;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private Intake()
	{
		//intakeArm = new Victor(RobotMap.IntakeArm);
		intakeRoller = new VictorSP(RobotMap.IntakeRoller);
		//intakeIn = new DigitalInput(RobotMap.IntakeInLimit);
		//intakeOut = new DigitalInput(RobotMap.IntakeOutLimit);
	}
	
	public static Intake getInstance()
	{
		if(instance == null)
    		instance = new Intake();
    	
    	return instance;
	}
	
	/*public void moveArm(double speed)
	{
		intakeArm.set(speed);
	}*/
	
	public void spinIntake(double speed)
	{
		intakeRoller.set(speed);
	}
	
	public void stopIntake()
	{
		intakeRoller.set(0);
	}
	
	/*public boolean isIn()
	{
		return intakeIn.get();
	}
	
	public boolean isOut()
	{
		return intakeOut.get();
	}*/

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

