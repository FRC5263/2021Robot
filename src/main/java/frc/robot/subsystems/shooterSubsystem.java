// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.MotorSubsystem;
import frc.robot.consoleColors;

public class shooterSubsystem extends SubsystemBase {
  SpeedController shooter;
  SpeedController motor;
  SpeedController rightMotor;
  SpeedController leftMotor;
  
  /**configures a single motor shooter */
  public shooterSubsystem(SpeedController motor) {
    System.out.print(consoleColors.WHITE_BACKGROUND + consoleColors.BLACK + "Initializing new single motor shooter" + consoleColors.RESET + "\n");
    this.motor = motor;
  }
  
  /**configures dual motor shooter */
  public shooterSubsystem(SpeedController rightMotor, SpeedController leftMotor) {
    this.rightMotor = rightMotor;
    this.leftMotor = leftMotor;
  }

  /**shoot using a single motor shooter */
  public void shootSingleMotor(double speed) {
    motor.set(speed);
  }

  /**shoot using a dual motor shooter */
  public void shootDualMotor(double speed) {
    rightMotor.set(speed);
    leftMotor.set(speed);
  }

@Override
  public void periodic() {
  // This method will be called once per scheduler run
  }
}
