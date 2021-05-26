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
    boolean leftButtonPressed = controller.getRawButton(4);
    boolean rightButtonPressed = controller.getRawButton(5);
    if (leftButtonPressed = true) {
      arm.moveArm(-.5);
    } else if (rightButtonPressed = true) {
      arm.moveArm(.5);
    } else {
      arm.moveArm(0);
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
