
package org.usfirst.frc.team4965.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4965.robot.commands.*;
import org.usfirst.frc.team4965.robot.subsystems.DefenseArm;
import org.usfirst.frc.team4965.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4965.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team4965.robot.subsystems.Intake;
import org.usfirst.frc.team4965.robot.subsystems.Launcher;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;
	public static DriveTrain drivetrain;
	public static Launcher launcher;
	public static Intake intake;
	public static DefenseArm defenseArm;
	
    Command autonomousCommand;
    Command teleopCommand;

    SendableChooser autoChooser;
    CameraServer server;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	drivetrain = DriveTrain.getInstance();
		launcher = Launcher.getInstance();
		intake = Intake.getInstance();
		defenseArm = DefenseArm.getInstance();
		oi = new OI();
        // instantiate the command used for the autonomous period
		autoChooser.addDefault("Low Bar", new DriveForTime(4, .5));
		autoChooser.addObject("No Auto", new ExampleCommand());
		autoChooser.addObject("Test Auto", new DriveForTime(SmartDashboard.getNumber("Auto Time", 0), 
															SmartDashboard.getNumber("Auto Power", 0)));
		autoChooser.addObject("Low Bar with Arm", new Autonomous(new DriveForTime(4, .5)));
		SmartDashboard.putData("Select Autonomous Mode", autoChooser);

        teleopCommand = new JoystickDrive();
        
        server = CameraServer.getInstance();
        server.setQuality(50);
        //the camera name (ex "cam0") can be found through the roborio web interface
        server.startAutomaticCapture("cam0");
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
    	autonomousCommand = (Command) autoChooser.getSelected();
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        Scheduler.getInstance().add(teleopCommand);
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	SmartDashboard.putBoolean("Ball Limit", intake.ballIsIn());
    	SmartDashboard.putNumber("Gyro", drivetrain.getAngle());
    	SmartDashboard.putNumber("Ultrasonic", drivetrain.getSonarDistance());
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
