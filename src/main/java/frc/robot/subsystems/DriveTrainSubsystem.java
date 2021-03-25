// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.drive.*;

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
    System.out.print("Initializing a new Mechanum Drive Train\n");

    //makes variables for speedcontollers
    this.frontLeftMotor = frontLeftMotor;
    this.frontRightMotor = frontRightMotor;
    this.rearRightMotor = rearRightMotor;
    this.rearLeftMotor = rearLeftMotor;

    //creates a MecanumDrive Object with the SpeedController variables
    this.mechanumDrivetrain = new MecanumDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);

    //outputs to console that a mechanum drivetrain has been initialized
    System.out.print("New Mechanum Drive Train initialized\n");
  }

  /** Creates a new Dual Motor Differential Drive Train */
  public DriveTrainSubsystem(SpeedController rightMotor, SpeedController leftMotor) {
    //outputs to console the a differential drive train is being initialized
    System.out.print("Initializing a new Dual Motor Differential Drive Train\n");
    
    //makes variables for speed controllers
    this.rightMotor = rightMotor;
    this.leftMotor = leftMotor;

    //creates a DifferentialDrive Object with the SpeedController variables
    this.differentialDrivetrain = new DifferentialDrive(leftMotor, rightMotor);

    ///outputs to console that a Differential Drive Train has beed initialized
    System.out.print("New Dual Motor Differential Drive Train initialized");
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
