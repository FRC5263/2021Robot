// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class shooterSubsystem extends SubsystemBase {
  SpeedController shooter;
  SpeedController motor;
  private edu.wpi.first.wpilibj.SpeedController shooterSubsystem;
  
  public shooterSubsystem(SpeedController motor) {
    this.motor = motor;
    this.shooterSubsystem = new SpeedControllerGroup(motor);
  }

  public void shootBall(double speed) {
    shooter.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
