package org.usfirst.frc.team4965.robot.commands;

import org.usfirst.frc.team4965.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveForTime extends Command {
	Timer timer;
	double time1;
	
    public DriveForTime(double time) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	time1 = time;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer = new Timer();
    	timer.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	timer.start();
    	Robot.drivetrain.tankDrive(.25, .25);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(timer.get() == time1)
        {
        	return true;
        }
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
