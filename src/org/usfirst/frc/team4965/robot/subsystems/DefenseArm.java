package org.usfirst.frc.team4965.robot.subsystems;

import org.usfirst.frc.team4965.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DefenseArm extends Subsystem {
    public static DefenseArm instance;
    VictorSP defenseArm;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    private DefenseArm()
    {
    	defenseArm = new VictorSP(RobotMap.DefenseArm);
    }
    
	public static DefenseArm getInstance()
    {
    	if(instance == null)
    		instance = new DefenseArm();
    	
    	return instance;
    }
	
	public void up()
	{
		defenseArm.set(1);
	}
	
	public void down()
	{
		defenseArm.set(-1);
	}
	
	public void stop()
	{
		defenseArm.set(0);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

