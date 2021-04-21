// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Joystick;

public class MechanumDriveTrainControl extends CommandBase {
  DriveTrainSubsystem mechanumDrive;
  XboxController controller0 = new XboxController(0);


  /** Creates a new driveTrainControl for a Mechanum Drive Train. */
  public MechanumDriveTrainControl(DriveTrainSubsystem mechanumDrivetrain) {
    this.mechanumDrive = mechanumDrivetrain;
  }





// Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double xSpeed = controller0.getRawAxis(0);
    double ySpeed = controller0.getRawAxis(1);
    double zRotation = controller0.getRawAxis(4);
    
    mechanumDrive.DriveMechanum(xSpeed*-1, ySpeed, zRotation);
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
