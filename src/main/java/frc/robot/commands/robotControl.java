// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.commands.DifferentialDriveTrainControl;
import frc.robot.commands.armControl;
import frc.robot.commands.shooterControl;
import frc.robot.commands.intakeControl;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.robotObject;

public class robotControl extends CommandBase {
  XboxController controller;
  robotObject robot;
  

  /**this class controlls the whole class */
  public robotControl(robotObject robot) {
    this.robot = robot;
  }

  //checks for subsystems in the hashmap


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
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
