// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.shooterSubsystem;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;

public class shooterControl extends CommandBase {
  XboxController controller = new XboxController(0);
  shooterSubsystem shooter;
  GenericHID.Hand hand;
  boolean dualMotor;

  /**creates a new shooterControl */
  public shooterControl(shooterSubsystem shooter, boolean dualMotor) {
    this.shooter = shooter;
    this.dualMotor = dualMotor;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double shootSpeed = controller.getRawAxis(3);
    controller.setRumble(RumbleType.kLeftRumble, shootSpeed);
    if(dualMotor == true) {
      shooter.shootDualMotor(shootSpeed);
    } else {
      shooter.shootSingleMotor(shootSpeed);
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
