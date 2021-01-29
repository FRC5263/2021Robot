/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class DrivetrainsSubsystem extends SubsystemBase {
  private MecanumDrive mecanumDriveTrain;
  private DifferentialDrive differentialDriveTrain;
  /*private AHRS navx;*/
  private Encoder frontRightEncoder;
  private Encoder frontLeftEncoder;
  private Encoder backRightEncoder;
  private Encoder backLeftEncoder;
  private SpeedController frontRightMotor;
  private SpeedController frontLeftMotor;
  private SpeedController backRightMotor;
  private SpeedController backLeftMotor;
  /**
   * Creates a new DrivetrainsSubsystem.
   */
  public DrivetrainsSubsystem(MecanumDrive mecanumDriveTrain, DifferentialDrive differentialDriveTrain) {
    mecanumDriveTrain.getClass();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
