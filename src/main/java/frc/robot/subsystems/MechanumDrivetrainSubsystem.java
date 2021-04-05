// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

public class MechanumDrivetrainSubsystem extends SubsystemBase {
  //creates placeholder variables for the subsystem
  private SpeedController frontLeftMotor;
  private SpeedController frontRightMotor;
  private SpeedController rearLeftMotor;
  private SpeedController rearRightMotor;
  private MecanumDrive driveTrain;


  /** Creates a new MechanumDrivetrainSubsystem.
   * use DriveMechanum to make the drive train move
   * @param frontLeftMotor the front left motor
   * @param frontRightMotor the front right motor
   * @param rearRightMotor the rear right motor
   * @param rearLeftMotor the rear left motor
   */
  public MechanumDrivetrainSubsystem(SpeedController frontLeftMotor, SpeedController frontRightMotor, SpeedController rearLeftMotor, SpeedController rearRightMotor) {
    this.frontLeftMotor = frontLeftMotor;
    this.frontRightMotor = frontRightMotor;
    this.rearRightMotor = rearRightMotor;
    this.rearLeftMotor = rearLeftMotor;

    this.driveTrain = new MecanumDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, r);
    System.out.print("New Mechanum Drive Train Initilized\n");
  }

  public void DriveMechanum(double xSpeed, double ySpeed, double zRotation) {
    driveTrain.driveCartesian(ySpeed, xSpeed, zRotation);
    System.out.print("driving");
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
