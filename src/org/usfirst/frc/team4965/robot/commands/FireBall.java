package org.usfirst.frc.team4965.robot.commands;

import org.usfirst.frc.team4965.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FireBall extends Command {
	Timer time;

    public FireBall() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.launcher);
    	requires(Robot.intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	time = new Timer();
    	time.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	time.start();
    	Robot.launcher.spinWheels(1);
    	if(time.get() == .5)
    	{
    		Robot.intake.spinIntake(1);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(time.get() == 1)
        {
        	return true;
        }
        
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
