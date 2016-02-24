package org.usfirst.frc.team4965.robot;

import org.usfirst.frc.team4965.robot.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	
	Joystick controllerOne = new Joystick(0);
	Joystick controllerTwo = new Joystick(1);
	
	JoystickButton JoyOne_ButtonOne = new JoystickButton(controllerOne, 1);
	
	JoystickButton JoyTwo_ButtonOne = new JoystickButton(controllerTwo, 1);
	JoystickButton JoyTwo_ButtonTwo = new JoystickButton(controllerTwo, 2);
	JoystickButton JoyTwo_ButtonThree = new JoystickButton(controllerTwo, 3);
	JoystickButton JoyTwo_ButtonFour = new JoystickButton(controllerTwo, 4);
	
	public OI()
	{
		JoyOne_ButtonOne.whenPressed(new ReverseDrive());
		
		JoyTwo_ButtonOne.whileHeld(new IntakeBall());
		JoyTwo_ButtonTwo.whileHeld(new ReverseIntake());
		JoyTwo_ButtonThree.whenPressed(new FireBall());
		JoyTwo_ButtonFour.whileHeld(new SpinLauncher());
	}
	
	public double leftStickY()
	{
		if(controllerOne.getRawAxis(1) < .2 && controllerOne.getRawAxis(1) > -.2)
		{
			return 0;
		}
		else if(controllerOne.getRawAxis(1) < 0)
		{	
			return -Math.pow(controllerOne.getRawAxis(1), 2);
		}
		else 
		{
			return Math.pow(controllerOne.getRawAxis(1), 2);
		}
	}
	
	public double rightStickY()
	{
		if(controllerOne.getRawAxis(3) < .2 && controllerOne.getRawAxis(3) > -.2)
		{
			return 0;
		}
		else if(controllerOne.getRawAxis(3) < 0)
		{	
			return -Math.pow(controllerOne.getRawAxis(3), 2);
		}
		else 
		{
			return Math.pow(controllerOne.getRawAxis(3), 2);
		}
	}
	
	public double flightStickY()
	{
		if(controllerOne.getY() < .2 && controllerOne.getY() > -.2)
		{
			return 0;
		}
		else if(controllerOne.getY() < 0)
		{	
			return -Math.pow(controllerOne.getY(), 2);
		}
		else 
		{
			return Math.pow(controllerOne.getY(), 2);
		}
	}
	
	public double joyTwist()
	{
		return controllerOne.getRawAxis(3);
	}
	
	public double throttle()
    {
        return ((-controllerOne.getRawAxis(2)) + 1) / 2;
    }
    
}

