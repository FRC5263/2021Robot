// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import java.util.HashMap;
import frc.robot.consoleColors;
import java.util.Map;

public class robotObject extends SubsystemBase {
  public static String DRIVETRAIN = "drivetrain";
  public static String SHOOTER = "shooter";
  public static String ARM = "arm";
  private Map<String, Subsystem> subsystems = new HashMap<>();


	/**creates a new robot */
    public robotObject(HashMap<String, Subsystem> subsystems) {
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
        throw new Exception(consoleColors.RED_BOLD + "subsystem does not exist!" + consoleColors.RESET);
    }
  }

  public boolean hasSubsystem(String key) {
    return this.subsystems.containsKey(key);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
