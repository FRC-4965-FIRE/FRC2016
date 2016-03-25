package org.usfirst.frc.team4965.robot.commands;

import org.usfirst.frc.team4965.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnToAngle extends Command {
	double angle;
	double power;
	boolean turnRight;

    public TurnToAngle(double angle, double power, boolean turnRight) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	
    	this.angle = angle;
    	this.power = power;
    	this.turnRight = turnRight;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.resetGyro();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(turnRight)
    		Robot.drivetrain.tankDrive(-power, power);
    	else
    		Robot.drivetrain.tankDrive(power, -power);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(turnRight && Robot.drivetrain.getAngle() >= angle)
        	return true;
        else if(!turnRight && Robot.drivetrain.getAngle() <= angle)
        	return true;
        else
        	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.tankDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.drivetrain.tankDrive(0, 0);
    }
}
