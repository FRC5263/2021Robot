// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.commands.DifferentialDriveTrainControl;
import frc.robot.commands.armControl;
import frc.robot.commands.shooterControl;
import frc.robot.commands.intakeControl;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.armSubsystem;
import frc.robot.subsystems.robotObject;

public class robotControl extends CommandBase {
  XboxController controller = new XboxController(0);
  robotObject robot;
  DriveTrainSubsystem driveTrain;
  armSubsystem arm;

  /**this class controlls the whole class */
  public robotControl(robotObject robot) {
    this.robot = robot;
  }

  public robotControl(DriveTrainSubsystem driveTrain, armSubsystem arm) {
    this.driveTrain = driveTrain;
    this.arm = arm;
  }

  //checks for subsystems in the hashmap


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //drivetrain
    double leftSpeed = controller.getRawAxis(1);
    double rightSpeed = controller.getRawAxis(5);
    driveTrain.DriveDifferential(leftSpeed * -1, rightSpeed * -1);

    //arm
    boolean armUpButtonPressed = controller.getRawButton(4);
    boolean armDownButtonPressed = controller.getRawButton(1);
    boolean fingerOpenButtonPressed = controller.getRawButton(5);
    boolean fingerCloseButtonPressed = controller.getRawButton(6);

    //--checks if the buttons are pressed down
    if (armUpButtonPressed == true) {
      arm.moveArm(-.15);
    } else if (armDownButtonPressed == true) {
      arm.moveArm(.15);
    } else if (armDownButtonPressed == true && (armUpButtonPressed == true)) {
      arm.moveArm(0);
    }

    if (fingerOpenButtonPressed == true) {
      arm.moveFinger(.5);
    } else if (fingerCloseButtonPressed == true) {
      arm.moveFinger(-.5);
    } else if (fingerCloseButtonPressed == true && (fingerOpenButtonPressed == true)) {
      arm.moveFinger(0);
    } else if (fingerCloseButtonPressed == false && (fingerOpenButtonPressed == false)) {
      arm.moveFinger(0);
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
