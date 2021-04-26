// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import frc.robot.consoleColors;

import java.util.Map;

import edu.wpi.first.hal.simulation.DIODataJNI;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;

import java.util.HashMap;

/** this class is for making a induvidual robot object*/
public class theRobot {
    public static String DRIVETRAIN = "drivetrain";
    private Map<String, Subsystem> subsystems = new HashMap<>();
    
    /**creates a new robot */
    public void Robot(HashMap<String, Subsystem> subsystems) {
        this.subsystems.putAll(subsystems);
    }

    /**puts a subsystem into the robot object */
    public void addSubsystem(String key, Subsystem subsystem) {
        this.subsystems.put(key, subsystem);
    }
    
    /**locates subsytem in bot object */
    public Subsystem getSubsystem(String key) throws Exception {
        Subsystem subsystem = this.subsystems.get(key);
        if(subsystem != null) {
            return subsystem;
        } else {
            throw new Exception("subsystem does not exist!");
        }
    }

    public boolean hasSubsystem(String key) {
        return this.subsystems.containsKey(key);
    }

    public DigitalInput makeRobotId(Integer jumperNum) {
        DigitalInput id = new DigitalInput(jumperNum);
        System.out.print(consoleColors.WHITE_BACKGROUND + consoleColors.BLACK_BOLD + "made id on dio jumper 8\n" + consoleColors.RESET);
        return id;
    }
}