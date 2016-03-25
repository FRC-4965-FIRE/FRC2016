package org.usfirst.frc.team4965.robot.commands;

import org.usfirst.frc.team4965.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FireBall extends Command {
	Timer timer;

    public FireBall() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.launcher);
    	requires(Robot.intake);
    	
    	timer = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.reset();
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.launcher.spinWheels(1);
    	if(timer.get() >= 1)
    	{
    		Robot.intake.spinIntake(1);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(timer.get() >= 1.5)
        	return true;
        else
        	return false; 
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.launcher.stopWheels();
    	Robot.intake.stopIntake();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.launcher.stopWheels();
    	Robot.intake.stopIntake();
    }
}
