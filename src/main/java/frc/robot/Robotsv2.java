// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PWM;

import java.util.HashMap;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.robotObject;
import frc.robot.subsystems.DriveTrainSubsystem;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import frc.robot.subsystems.shooterSubsystem;
import frc.robot.subsystems.armSubsystem;
import frc.robot.subsystems.intakeSubsystem;
import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.consoleColors;
import edu.wpi.first.wpilibj.Spark;

/** Add your docs here. */
public class Robotsv2 {
    DigitalInput dio9 = new DigitalInput(9);
    Boolean notSeniorTeam = !dio9.get();
    DigitalInput dio8 = new DigitalInput(8);
    Boolean seniorTeam = !dio8.get();
 
    public static robotObject createNotSeniorTeam() {
        return new robotObject(
            new HashMap<String, Subsystem>() {
                {put(robotObject.DRIVETRAIN, new DriveTrainSubsystem(new PWMTalonSRX(7), new PWMVictorSPX(10)));}
                {put(robotObject.SHOOTER, new shooterSubsystem(new PWMTalonSRX(5), new PWMTalonSRX(2), new PWMTalonSRX(4)));}
                {put(robotObject.ARM, new armSubsystem(new PWMTalonSRX(3), new Spark(9)));}
            }
        );
    }

    public static robotObject createSeniorTeam() {
        return new robotObject(
            new HashMap<String, Subsystem>() {
                {put(robotObject.DRIVETRAIN, new DriveTrainSubsystem(new PWMTalonSRX(1), new PWMTalonSRX(1)));}
                {put(robotObject.SHOOTER, new shooterSubsystem(new PWMTalonSRX(1)));}
                {put(robotObject.INTAKE, new intakeSubsystem(new PWMTalonSRX(1)));}
            }
        );
    }

    public static robotObject getRobotByHardware() {
        //dio true = not connected, dio false = connected
        DigitalInput dio9 = new DigitalInput(9);
        DigitalInput dio8 = new DigitalInput(8);
        Boolean dio9Connected = !dio9.get();
        dio9.close();
        Boolean dio8Connected = !dio8.get();
        dio8.close();

        if (dio9Connected == false) {
            System.out.print(consoleColors.WHITE_BACKGROUND + consoleColors.GREEN_BOLD + "running on bot 1" + consoleColors.RESET + "\n");
            return createNotSeniorTeam();
        } else if (dio8Connected == false) {
            System.out.print(consoleColors.WHITE_BACKGROUND + consoleColors.GREEN_BOLD + "running on bot 2" + consoleColors.RESET + "\n");
            return createSeniorTeam();
        } else {
            System.out.print(consoleColors.WHITE_BACKGROUND + consoleColors.GREEN_BOLD + "not a valid robot" + consoleColors.RESET + "\n");
            return null;
        }
    }

    public static Boolean getSeniorBot() {
        DigitalInput dio8 = new DigitalInput(8);
        return null;
    }

    public static Boolean getShaqBot() {
        return null;
    }
}
