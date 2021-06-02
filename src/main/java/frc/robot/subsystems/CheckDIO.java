// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/** checks for a closed curicut on a given dio port */
public class CheckDIO extends SubsystemBase{
    int channel;

    public static Boolean CheckDIO(int channel) {
        DigitalInput dio = new DigitalInput(channel);
        Boolean dioConnected = !dio.get();
        dio.close();
        if (dioConnected == false) {
            System.out.print("cable connected on dio" + channel + "\n");
            return true;
        } else if (dioConnected == true) {
            return false;
        } else {
            return false;
        }
    }

}
