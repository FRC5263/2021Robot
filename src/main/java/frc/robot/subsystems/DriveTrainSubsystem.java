// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.drive.*;
import frc.robot.consoleColors;

public class DriveTrainSubsystem extends SubsystemBase {
  
  //variables for the drivetrain objects
  SpeedController leftMotor;
  SpeedController rightMotor;
  SpeedController frontRightMotor;
  SpeedController frontLeftMotor;
  SpeedController rearRightMotor;
  SpeedController rearLeftMotor;
  MecanumDrive mechanumDrivetrain;
  DifferentialDrive differentialDrivetrain;



  /** Creates a new Mechanum Drive Train object*/
  public DriveTrainSubsystem(SpeedController frontRightMotor, SpeedController frontLeftMotor, SpeedController rearRightMotor, SpeedController rearLeftMotor) {
    //outputs to console that a mechanum drive train is being initilized
    System.out.print(consoleColors.WHITE_BACKGROUND + consoleColors.BLACK + "Initializing a new Mechanum Drive Train" + consoleColors.RESET + "\n");

    //makes variables for speedcontollers
    this.frontLeftMotor = frontLeftMotor;
    this.frontRightMotor = frontRightMotor;
    this.rearRightMotor = rearRightMotor;
    this.rearLeftMotor = rearLeftMotor;

    //creates a MecanumDrive Object with the SpeedController variables
    this.mechanumDrivetrain = new MecanumDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);

    //outputs to console that a mechanum drivetrain has been initialized
    System.out.print(consoleColors.GREEN_BACKGROUND + consoleColors.BLACK + "New Mechanum Drive Train initialized" + consoleColors.RESET + "\n");
  }

  /** Creates a new Dual Motor Differential Drive Train */
  public DriveTrainSubsystem(SpeedController rightMotor, SpeedController leftMotor) {
    //outputs to console the a differential drive train is being initialized
    System.out.print(consoleColors.WHITE_BACKGROUND + consoleColors.BLACK + "Initializing a new Dual Motor Differential Drive Train" + consoleColors.RESET + "\n");
    
    //makes variables for speed controllers
    this.rightMotor = rightMotor;
    this.leftMotor = leftMotor;

    //creates a DifferentialDrive Object with the SpeedController variables
    this.differentialDrivetrain = new DifferentialDrive(leftMotor, rightMotor);

    ///outputs to console that a Differential Drive Train has beed initialized
    System.out.print(consoleColors.GREEN_BACKGROUND + consoleColors.BLACK + "New Dual Motor Differential Drive Train initialized" + consoleColors.RESET + "\n");
  }

  /**use this function to make a Mechanum Drive Train move */
  public void DriveMechanum(double xSpeed, double ySpeed, double zRotation) {
    mechanumDrivetrain.driveCartesian(ySpeed, xSpeed, zRotation);
  }


  /**use this function to make a Differential Drive Train move */
  public void DriveDifferential(double leftSpeed, double rightSpeed) {
    differentialDrivetrain.tankDrive(leftSpeed, rightSpeed);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
