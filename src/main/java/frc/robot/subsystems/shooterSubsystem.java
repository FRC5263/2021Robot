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
  SpeedController kicker;
  
  /**configures a single motor shooter */
  public shooterSubsystem(SpeedController motor) {
    System.out.print(consoleColors.WHITE_BACKGROUND + consoleColors.BLACK + "Initializing new single motor shooter" + consoleColors.RESET + "\n");
    this.motor = motor;
    System.out.print(consoleColors.GREEN_BACKGROUND + consoleColors.BLACK + "New single motor shooter initialized" + consoleColors.RESET + "\n");
  }
  
  /**configures dual motor shooter */
  public shooterSubsystem(SpeedController rightMotor, SpeedController leftMotor, SpeedController kicker) {
    System.out.print(consoleColors.WHITE_BACKGROUND + consoleColors.BLACK + "Initializing a new dual motor shooter" + consoleColors.RESET + "\n");
    this.rightMotor = rightMotor;
    this.leftMotor = leftMotor;
    this.kicker = kicker;
    System.out.print(consoleColors.GREEN_BACKGROUND + consoleColors.BLACK + "New dual motor shooter initialized" + consoleColors.RESET + "\n");
  }

  /**shoot using a single motor shooter */
  public void shootSingleMotor(double shootSpeed) {
    motor.set(shootSpeed);
  }

  /**shoot using a dual motor shooter */
  public void shootDualMotor(double shootSpeed) {
    rightMotor.set(shootSpeed);
    leftMotor.set(shootSpeed);
  }

  public void moveKicker() {
    
  }

@Override
  public void periodic() {
  // This method will be called once per scheduler run
  }
}
