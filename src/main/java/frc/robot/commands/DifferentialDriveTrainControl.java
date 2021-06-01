// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.subsystems.DriveTrainSubsystem;

public class DifferentialDriveTrainControl extends CommandBase {
  DriveTrainSubsystem differentialDriveTrain;
  XboxController controller0 = new XboxController(0);


  /** Creates a new DifferentialControl. */
  public DifferentialDriveTrainControl(DriveTrainSubsystem drivetrain) {
    this.differentialDriveTrain  = drivetrain;
  }

// Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftSpeed = controller0.getRawAxis(1);
    double rightSpeed = controller0.getRawAxis(5);
    differentialDriveTrain.DriveDifferential(leftSpeed * -1, rightSpeed * -1);

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
