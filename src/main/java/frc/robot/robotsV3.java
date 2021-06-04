// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Spark;
import frc.robot.commands.robotControl;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.armSubsystem;
import frc.robot.subsystems.intakeSubsystem;
import frc.robot.subsystems.shooterSubsystem;

/** Add your docs here. */
public class robotsV3 extends Robot{
    static DigitalInput dio9 = new DigitalInput(9);
    static DigitalInput dio8 = new DigitalInput(8);

    /*
     * public static robotObject createSeniorTeam() { return new robotObject( new
     * HashMap<String, Subsystem>() { {put(robotObject.DRIVETRAIN, new
     * DriveTrainSubsystem(new PWMTalonSRX(1), new PWMTalonSRX(1)));}
     * {put(robotObject.SHOOTER, new shooterSubsystem(new PWMTalonSRX(1)));}
     * {put(robotObject.INTAKE, new intakeSubsystem(new PWMTalonSRX(1)));} } ); }
     */

    public static robotControl getBot() {
        if (dio9.get() == false) {
            System.out.print("running on dio 9 config");
            return new robotControl(new DriveTrainSubsystem(new WPI_TalonSRX(7), new WPI_VictorSPX(10)), new armSubsystem(new Spark(8), new Spark(9)), new shooterSubsystem(new WPI_TalonSRX(5), new WPI_TalonSRX(2), new WPI_TalonSRX(4)), true);
        } else if (dio8.get() == false) {
            System.out.print("running on dio 8 config");
            return new robotControl(new DriveTrainSubsystem(new Spark(8), new Spark(0)), new intakeSubsystem(new Jaguar(3)), new shooterSubsystem(new Spark(7)), false);
        } else if (dio8.get() == true && (dio9.get() == true)) {
            System.out.print("not a recognised robot");
            return null;
        } else {
            return null;
        }
    }
}
