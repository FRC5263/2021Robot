// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.SpeedController;
import frc.robot.consoleColors;

public class armSubsystem extends SubsystemBase {
  SpeedController arm;

  /** creates arm object*/
  public armSubsystem(SpeedController motor) {
    System.out.print(consoleColors.WHITE_BACKGROUND + consoleColors.BLACK + "Initializing new Arm" + consoleColors.RESET + "\n");
    this.arm = motor;
    System.out.print(consoleColors.GREEN_BACKGROUND + consoleColors.BLACK + "New Arm initialized" + consoleColors.RESET + "\n");
  }

  /**moves arm */
  public void moveArm(double speed) {
    arm.set(speed * .5);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
