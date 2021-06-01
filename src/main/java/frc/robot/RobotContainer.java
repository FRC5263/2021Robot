/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.util.WPILibVersion;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.armSubsystem;
import frc.robot.subsystems.intakeSubsystem;
import frc.robot.subsystems.shooterSubsystem;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import frc.robot.Robot;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.Spark;
import frc.robot.commands.robotControl;
import edu.wpi.first.wpilibj.DigitalInput;


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  //declares variables for dio 9 and 8 and then checks if there is somthing plugged in
  private DigitalInput dio9 = new DigitalInput(9);
  private DigitalInput dio8 = new DigitalInput(8);
  
  if (seniorTeam = true) {
  }


  private SpeedController rightMotor = new WPI_TalonSRX(7);
  private SpeedController leftMotor = new WPI_VictorSPX(10);
  private DriveTrainSubsystem differentialDrivetrain = new DriveTrainSubsystem(rightMotor, leftMotor);
  private DifferentialDriveTrainControl driveTrainControl = new DifferentialDriveTrainControl(differentialDrivetrain);
  private armSubsystem arm = new armSubsystem(new WPI_TalonSRX(3), new Spark(9));
  private armControl armController = new armControl(arm);
  private Command m_teleOp = new robotControl(differentialDrivetrain, arm);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {



    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
  public Command getTeleOpCommand() {
    return m_teleOp;
  }
}


