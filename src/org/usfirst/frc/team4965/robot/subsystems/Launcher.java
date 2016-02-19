package org.usfirst.frc.team4965.robot.subsystems;

import org.usfirst.frc.team4965.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Launcher extends Subsystem {
	public static Launcher instance;
    VictorSP launcherLeft, launcherRight;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    private Launcher()
    {
    	launcherLeft = new VictorSP(RobotMap.LauncherLeft);
    	launcherRight = new VictorSP(RobotMap.LauncherRight);
    }
    
    public static Launcher getInstance()
    {
    	if(instance == null)
    		instance = new Launcher();
    	
    	return instance;
    }
    
    public void spinWheels(double speed)
    {
    	launcherLeft.set(speed);
    	launcherRight.set(-speed);
    }
    
    public void stopWheels()
    {
    	launcherLeft.set(0);
    	launcherRight.set(0);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

