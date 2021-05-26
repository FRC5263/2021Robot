// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import java.util.HashMap;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.robotObject;
import frc.robot.subsystems.DriveTrainSubsystem;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import frc.robot.subsystems.shooterSubsystem;
import frc.robot.subsystems.armSubsystem;

/** Add your docs here. */
public class Robotsv2 {
    DigitalInput dio9 = new DigitalInput(9);
    Boolean notSeniorTeam = !dio9.get();
    DigitalInput dio8 = new DigitalInput(8);
    Boolean seniorTeam = !dio8.get();
 
    public robotObject createNotSeniorTeam() {
        return new robotObject(new HashMap<String, Subsystem>() {
            {put(robotObject.DRIVETRAIN, new DriveTrainSubsystem(new PWMTalonSRX(0), new PWMVictorSPX(0)));}
            {put(robotObject.SHOOTER, new shooterSubsystem(new PWMTalonSRX(1)));}
            {put(robotObject.ARM, new armSubsystem(new PWMTalonSRX(5)));}
            //{put()}
        }
        );
    }

    public static robotObject getRobotByHardware() {
        return null;
    }
}
