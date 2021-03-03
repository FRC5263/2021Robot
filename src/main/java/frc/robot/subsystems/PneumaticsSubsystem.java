/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;

public class PneumaticsSubsystem extends SubsystemBase {
  /**
   * Creates a new PneumaticsSubsystem.
   */
  public PneumaticsSubsystem(Compressor compressor, Solenoid Solenoid) {
    Compressor c = new Compressor(0);

    c.setClosedLoopControl(true);
    c.setClosedLoopControl(false);
    
    boolean enabled = c.enabled();
    boolean pressureSwitch = c.getPressureSwitchValue();
    double current = c.getCompressorCurrent();

//DoubleSolenoid code
DoubleSolenoid doubleSolenoid = new DoubleSolenoid(1, 2);



    doubleSolenoid.set(kOff);
    doubleSolenoid.set(kForward);
    doubleSolenoid.set(DoubleSolenoid.Value.kReverse);


// Initialize the Solenoid so it knows where to start.  
//solenoidOne.set(kReverse);

double scale = 250, offset = -25;
AnalogPotentiometer pressureTransducer = new AnalogPotentiometer(/* the AnalogIn port*/ 2, scale, offset);

// scaled values in psi units
double psi = pressureTransducer.get();
//Toggles SolenoidOne Reverse, Forward or Off
XboxController m_controller = new XboxController(0);


    class RobotContainer {
public RobotContainer() {
  
  // Configure the button bindings
  configureButtonBindings();
}

/**
 * Use this method to define your button->command mappings.  Buttons can be created by
 * instantiating a {@link GenericHID} or one of its subclasses ({@link
 * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
 * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
 */
private void configureButtonBindings() {


if (m_controller.getYButtonPressed()) {
  // solenoidOne.toggle();
  doubleSolenoid.set(kReverse);
   
}
if (m_controller.getXButtonPressed()) {
    // solenoidOne.toggle();
    doubleSolenoid.set(kForward);
     
  }
  if (m_controller.getAButtonPressed()) {
    // solenoidOne.toggle();
    doubleSolenoid.set(kOff);
  
  }
}
}

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}