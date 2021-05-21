// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.HashMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.robotObject;

/** This class is for defining our different robots */
public class Robots {
    static DigitalInput dio9 = new DigitalInput(9);
    static Boolean notSeniorTeam = !dio9.get();
    static DigitalInput dio8 = new DigitalInput(8);
    static Boolean seniorTeam = !dio8.get();

    public static robotObject createNotSeniorTeam() {
        return new robotObject(new HashMap<String, Subsystem>() {});
    }
    if (notSeniorTeam) {
        System.out.print(consoleColors.GREEN_BOLD + consoleColors.WHITE_BACKGROUND + "Robot identified" + consoleColors.RESET);
        SmartDashboard.putString("hardware configuration", "Team 1");
        return createNotSeniorTeam();
    } else if (seniorTeam) {
            System.out.print(consoleColors.GREEN_BOLD + consoleColors.WHITE_BACKGROUND + "Robot identified" + consoleColors.RESET);
        SmartDashboard.putString("hardware configuration", "Team 1");
        return createSeniorTeam();
    }
}
}