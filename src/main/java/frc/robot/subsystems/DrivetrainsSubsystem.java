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
  public DrivetrainsSubsystem(Boolean usingMecanumDrive, Encoder frontRightEncoder, Encoder frontLeftEncoder, Encoder backRightEncoder, Encoder backLeftEncoder, SpeedController frontRightMotor, SpeedController frontLeftMotor, SpeedController backRightMotor, SpeedController backLeftmotor) {
    this.backLeftEncoder = backLeftEncoder;
    this.backRightEncoder = backRightEncoder;
    this.frontLeftEncoder = frontLeftEncoder;
    this.frontRightEncoder = frontRightEncoder;
    this.frontLeftMotor = frontLeftMotor;
    this.frontRightMotor = frontRightMotor;
    this.backLeftMotor = backLeftMotor;
    this.backRightMotor = backRightMotor;
    
    if (usingMecanumDrive == false) {
      this.differentialDriveTrain = new DifferentialDrive(backRightMotor, backLeftmotor);

      System.out.print("New Differential Drive Train Initialized");
    } else {
      this.mecanumDriveTrain = new MecanumDrive(frontLeftMotor, backLeftMotor, frontRightMotor, backRightMotor);

      System.out.print("New Mecanum Drive Train Initialized");
    }
  }


  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
