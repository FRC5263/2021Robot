// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;

public class MechanumControl extends CommandBase {

  private MechanumDrivetrainSubsystem driveTrain;
  private XboxController controller = new XboxController(0);



  
  /** Creates a new MechanumControl. */
  public MechanumControl(MechanumDrivetrainSubsystem driveTrain) {
    this.driveTrain = driveTrain;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //System.out.print("sanity checks");
    //left stick forward and backward and right stick rotation
    double xSpeed = controller.getRawAxis(0);
    double ySpeed = controller.getRawAxis(1);
    double zRotation = controller.getRawAxis(4);
    driveTrain.DriveMechanum(xSpeed, ySpeed, zRotation);
    controller.setRumble(RumbleType.kRightRumble, 1);


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
