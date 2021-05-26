// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.SpeedController;
import frc.robot.consoleColors;

public class intakeSubsystem extends SubsystemBase {
  SpeedController intake;

  /**creates new intake */
  public intakeSubsystem(SpeedController motor) {
    System.out.print(consoleColors.WHITE_BACKGROUND + consoleColors.BLACK + "Initializing new Intake" + consoleColors.RESET + "\n");
    this.intake = motor;
    System.out.print(consoleColors.GREEN_BACKGROUND + consoleColors.BLACK + "New Intake initialized" + consoleColors.RESET + "\n");
  }

  /**spins intake motor */
  public void spinIntake(double speed) {
    intake.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
