package org.usfirst.frc.team4965.robot.subsystems;

import org.usfirst.frc.team4965.robot.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
	public static DriveTrain instance;
    Victor frontLeft, frontRight, backLeft, backRight;
    RobotDrive drive;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private DriveTrain()
    {
    	super("DriveTrain");
    	
    	frontLeft = new Victor(RobotMap.FrontLeft);
    	frontRight = new Victor(RobotMap.FrontRight);
    	backLeft = new Victor(RobotMap.BackLeft);
    	backRight = new Victor(RobotMap.BackRight);
    	
    	drive = new RobotDrive(frontLeft, backLeft, frontRight, backRight);
    	
    	drive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        drive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
    }
    
    public static DriveTrain getInstance()
    {
    	if(instance == null)
    		instance = new DriveTrain();
    	
    	return instance;
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

