// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.Map;

import edu.wpi.first.wpilibj2.command.Subsystem;

import java.util.HashMap;

/** this class is for making a induvidual robot object*/
public class theRobot {
    public static String DRIVETRAIN = "drivetrain";
    private Map<String, Subsystem> subsystems = new HashMap<>();
    
    
    /**creates a new robot */
    public void Robot(HashMap<String, Subsystem> subsystems) {
        
    }
}