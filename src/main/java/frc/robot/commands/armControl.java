// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.armSubsystem;
import edu.wpi.first.wpilibj.XboxController;

public class armControl extends CommandBase {
  armSubsystem arm;
  XboxController controller;


  /** Creates a new armControl object */
  public armControl(armSubsystem arm) {
    this.arm = arm;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    boolean armUpButtonPressed = controller.getRawButton(3);
    boolean armDownButtonPressed = controller.getRawButton(0);
    boolean fingerOpenButtonPressed = controller.getRawButton(4);
    boolean fingerCloseButtonPressed = controller.getRawButton(5);

    //checks if the buttons are pressed down
    if (armUpButtonPressed = true) {
      arm.moveArm(-.5);
    } else if (armDownButtonPressed = true) {
      arm.moveArm(.5);
    } else if (armDownButtonPressed = true && (armUpButtonPressed = true)) {
      arm.moveArm(0);
    }

    if (fingerOpenButtonPressed = true) {
      arm.moveFinger(.5);
    } else if (fingerCloseButtonPressed = true) {
      arm.moveFinger(-.5);
    } else if (fingerCloseButtonPressed = true && (fingerOpenButtonPressed = true)) {

    }
  }
  
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
