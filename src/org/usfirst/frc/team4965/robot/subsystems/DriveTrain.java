package org.usfirst.frc.team4965.robot.subsystems;

import org.usfirst.frc.team4965.robot.RobotMap;
import org.usfirst.frc.team4965.robot.commands.JoystickDrive;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Ultrasonic;

/**
 *
 */
public class DriveTrain extends Subsystem {
	public static DriveTrain instance;
    VictorSP frontLeft, frontRight, backLeft, backRight;
    RobotDrive drive;
    Ultrasonic ultrasonic;
    AnalogGyro gyro;
    
    public static boolean ReverseDrive;
	
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
    	
    	ultrasonic = new Ultrasonic(RobotMap.UltrasonicPing, RobotMap.UltrasonicEcho);
    	ultrasonic.setAutomaticMode(true);
    	
    	gyro = new AnalogGyro(RobotMap.Gyro);
    	
    	drive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        drive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        drive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        
        ReverseDrive = false;
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
    
    public double getSonarDistance()
    {
    	return ultrasonic.getRangeInches();
    }
    
    public double getAngle()
    {
    	return gyro.getAngle();
    }
    
    public void resetGyro()
    {
    	gyro.reset();
    }
    
    public void driveStraight(double power, double Kp)
    {
    	gyro.reset();
    	drive.drive(power, gyro.getAngle() * Math.abs(Kp));
    	Timer.delay(.004);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new JoystickDrive());
    }
}

