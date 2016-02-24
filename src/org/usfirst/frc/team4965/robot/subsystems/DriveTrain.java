package org.usfirst.frc.team4965.robot.subsystems;

import org.usfirst.frc.team4965.robot.RobotMap;
import org.usfirst.frc.team4965.robot.commands.JoystickDrive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
	public static DriveTrain instance;
    VictorSP frontLeft, frontRight, backLeft, backRight;
    RobotDrive drive;
    
    public static boolean ReverseDrive = false;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private DriveTrain()
    {
    	super("DriveTrain");
    	
    	frontLeft = new VictorSP(RobotMap.FrontLeft);
    	frontRight = new VictorSP(RobotMap.FrontRight);
    	backLeft = new VictorSP(RobotMap.BackLeft);
    	backRight = new VictorSP(RobotMap.BackRight);
    	
    	drive = new RobotDrive(frontLeft, backLeft, frontRight, backRight);
    	
    	drive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        drive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        drive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
    }
    
    public static DriveTrain getInstance()
    {
    	if(instance == null)
    		instance = new DriveTrain();
    	
    	return instance;
    }
    
    public void tankDrive(double leftSpeed, double rightSpeed)
    {
    	if(ReverseDrive)
    		drive.tankDrive(-leftSpeed, -rightSpeed);
    	else	
    		drive.tankDrive(leftSpeed, rightSpeed);
    }
    
    public void joystickDrive(double linearSpeed, double rotationSpeed, double throttle)
    {
    	if(ReverseDrive)
    		drive.arcadeDrive(-linearSpeed*throttle, rotationSpeed*throttle);
    	else
    		drive.arcadeDrive(linearSpeed*throttle, rotationSpeed*throttle);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new JoystickDrive());
    }
}

