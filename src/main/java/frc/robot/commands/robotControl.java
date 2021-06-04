package frc.robot.commands;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.commands.DifferentialDriveTrainControl;
import frc.robot.commands.armControl;
import frc.robot.commands.shooterControl;
import frc.robot.commands.intakeControl;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.armSubsystem;
import frc.robot.subsystems.intakeSubsystem;
import frc.robot.subsystems.shooterSubsystem;

public class robotControl extends CommandBase {
  XboxController controller = new XboxController(0);
  Joystick driver = new Joystick(1);
  DriveTrainSubsystem driveTrain;
  armSubsystem arm;
  shooterSubsystem shooter;
  Boolean dualMotorShooter;
  intakeSubsystem intake;
  Timer timer = new Timer();
  private int config;


  public robotControl(DriveTrainSubsystem driveTrain) {
    this.driveTrain = driveTrain;
  }

  /**this class controls a driveTrain and arm */
  public robotControl(DriveTrainSubsystem driveTrain, armSubsystem arm) {
    this.driveTrain = driveTrain;
    this.arm = arm;
  }

  /** this class controls a shaq bot hardware config */
  public robotControl(DriveTrainSubsystem driveTrain, armSubsystem arm, shooterSubsystem shooter, Boolean dualMotorShooter) {
    this.driveTrain = driveTrain;
    this.arm = arm;
    this.shooter = shooter;
    this.dualMotorShooter = dualMotorShooter;
    config = 1;
  }

  public robotControl(DriveTrainSubsystem driveTrain, intakeSubsystem intake, shooterSubsystem shooter, Boolean dualMotorShooter) {
    this.driveTrain = driveTrain;
    this.intake = intake;
    this.shooter = shooter;
    this.dualMotorShooter = dualMotorShooter;
    config = 2;
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //drivetrain
    double leftSpeed = driver.getRawAxis(1);
    double rightSpeed = driver.getRawAxis(5);

    //checks for robotControl config, one is robotcontrol drivetrain, arm, and dualmotor shooter. config 2 is drivetrain, intake, singlemotor shooter
    if (config == 1) {

      //drivetrain
      driveTrain.DriveDifferential(leftSpeed * -1, rightSpeed * -1);

      //shooter 
      double shootSpeed = controller.getRawAxis(2);

      //--checks for inputs and exectutes code
      if(dualMotorShooter == true) {
        shooter.shootDualMotor(shootSpeed*-1);
        controller.setRumble(RumbleType.kLeftRumble, shootSpeed*-1.2);
      } else {
        shooter.shootSingleMotor(shootSpeed);
        controller.setRumble(RumbleType.kLeftRumble, shootSpeed*-1.2);
      }

      //shooter actuator
      
      if (controller.getRawButton(4) == true) {
        shooter.moveKicker(1);
      } else if (controller.getRawButton(1) == true) {
        shooter.moveKicker(-1);
      } else if (controller.getRawButton(1) == true && (controller.getRawButton(4) == true)) {
        shooter.moveKicker(0);
      } else if (controller.getRawButton(1) == false && (controller.getRawButton(4) == false)) {
        shooter.moveKicker(0);
      }

      //arm
      arm.moveArm(controller.getRawAxis(1));
      boolean fingerOpenButtonPressed = controller.getRawButton(5);
      boolean fingerCloseButtonPressed = controller.getRawButton(6);

      //--checks if the button for the finger is pressed
      
      if (fingerOpenButtonPressed == true) {
       arm.moveFinger(.5);
      } else if (fingerCloseButtonPressed == true) {
        arm.moveFinger(-.5);
      } else if (fingerCloseButtonPressed == true && (fingerOpenButtonPressed == true)) {
        arm.moveFinger(0);
      } else if (fingerCloseButtonPressed == false && (fingerOpenButtonPressed == false)) {
        arm.moveFinger(0);
      }
    } else if (config == 2) {

      //drivetrain
      driveTrain.DriveDifferential(leftSpeed * 1, rightSpeed * 1);

      //shooter
      shooter.shootSingleMotor(controller.getRawAxis(3));
      controller.setRumble(RumbleType.kLeftRumble, controller.getRawAxis(3));

      //intake
      
      controller.setRumble(RumbleType.kRightRumble, controller.getRawAxis(2)*2);
      intake.spinIntake(controller.getRawAxis(5));
    }
  }


  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}