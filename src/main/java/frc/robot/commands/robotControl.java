package frc.robot.commands;
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
  DriveTrainSubsystem driveTrain;
  armSubsystem arm;
  shooterSubsystem shooter;
  Boolean dualMotorShooter;
  intakeSubsystem intake;
  Timer timer = new Timer();


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
  }

  public robotControl(DriveTrainSubsystem driveTrain, intakeSubsystem intake, shooterSubsystem shooter, Boolean dualMotorShooter) {
    this.driveTrain = driveTrain;
    this.intake = intake;
    this.shooter = shooter;
    this.dualMotorShooter = dualMotorShooter;
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //drivetrain
    double leftSpeed = controller.getRawAxis(1);
    double rightSpeed = controller.getRawAxis(5);
    driveTrain.DriveDifferential(leftSpeed * -1, rightSpeed * -1);

    //arm
    boolean armUpButtonPressed = controller.getRawButton(4);
    boolean armDownButtonPressed = controller.getRawButton(1);
    boolean fingerOpenButtonPressed = controller.getRawButton(5);
    boolean fingerCloseButtonPressed = controller.getRawButton(6);

    //--checks if the buttons are pressed down

    if(armUpButtonPressed == false && (armDownButtonPressed == false)) {
      arm.moveArm(0);
    } else {
      if (armUpButtonPressed == true) {
        arm.moveArm(-1);
        System.out.println("Going Up");
      } else if (armDownButtonPressed == true) {
        arm.moveArm(1);
        System.out.println("Going Down");
      } else if (armDownButtonPressed == true && (armUpButtonPressed == true)) {
        arm.moveArm(0);
      } else if (armUpButtonPressed == false && (armUpButtonPressed == false)) {
        arm.moveArm(0);
      }
    }
      
    if (fingerOpenButtonPressed == true) {
      arm.moveFinger(.5);
    } else if (fingerCloseButtonPressed == true) {
      arm.moveFinger(-.5);
    } else if (fingerCloseButtonPressed == true && (fingerOpenButtonPressed == true)) {
      arm.moveFinger(0);
    } else if (fingerCloseButtonPressed == false && (fingerOpenButtonPressed == false)) {
      arm.moveFinger(0);
    }

    //shooter 
    double shootSpeed = controller.getRawAxis(2);
    double kickerActuate = controller.getRawAxis(3);

    //--checks for inputs and exectutes code
    if(dualMotorShooter == true) {
      shooter.shootDualMotor(shootSpeed);
      controller.setRumble(RumbleType.kLeftRumble, shootSpeed*1.2);
    } else {
      shooter.shootSingleMotor(shootSpeed);
      controller.setRumble(RumbleType.kLeftRumble, shootSpeed*1.2);
    }

    //--moves kicker
    if (kickerActuate > .2) {
      timer.start();
      //--times kicker motor
      while (timer.hasElapsed(.1) == false) {
        shooter.moveKicker(1);
      } while (timer.hasElapsed(.1) == true && (timer.hasElapsed(.2) == false)) {
        shooter.moveKicker(-1);
      } if (timer.hasElapsed(.25) == true) {
        timer.stop();
      }
    }

    //intake
    double intakeIn = controller.getPOV(0);
    double intakeOut = controller.getPOV(180);

    if (controller.getPOV() == 0) {
      intake.spinIntake(1);
    } else if (controller.getPOV() == 180) {
      intake.spinIntake(-1);
    } else if (controller.getPOV() != 180 && (controller.getPOV() != 0)) {
      intake.spinIntake(0);
    } else if (controller.getPOV() == 180 && (controller.getPOV() == 0)) {
      intake.spinIntake(0);
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