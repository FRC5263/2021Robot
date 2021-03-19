/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.subsystems.*;

public class RobotControl extends CommandBase {
  /**
   * Creates a new RobotControl.
   */

    DrivetrainsSubsystem driveTrain;
    Joystick controller0 = new Joystick(0);




  public RobotControl(DrivetrainsSubsystem driveTrain) {
    this.driveTrain = driveTrain;
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //left stick driving
    double ySpeed = controller0.getRawAxis(1);
    double xSpeed = controller0.getRawAxis(0);
    double rotationSpeed = controller0.getRawAxis(4);
    controller0.setRumble(RumbleType.kLeftRumble, ySpeed);
    controller0.setRumble(RumbleType.kRightRumble, xSpeed);
    driveTrain.driveMechanum(xSpeed, ySpeed, rotationSpeed);
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
