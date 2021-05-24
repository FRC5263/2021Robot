/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;


public class MotorSubsystem extends SubsystemBase {
  
  private SpeedController motor;
  private double scalarPower = 1.0;
  private SpeedController motor1;
  private SpeedController motor2;
  private SpeedController dualMotor;

  /**creates single motor MotorSubsytem */
  public MotorSubsystem(SpeedController motor) {
    this.motor = motor;
  }

  /**creates dual motor MotorSubsystem */
  public MotorSubsystem(SpeedController motor1, SpeedController motor2) {
    this.motor1 = motor1;
    this.motor2 = motor2;
    this.dualMotor = new SpeedControllerGroup(motor1, motor2);
  }

  public void powerMotor(double speed) {
    motor.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
