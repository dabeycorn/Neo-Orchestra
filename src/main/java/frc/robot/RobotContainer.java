// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

public class RobotContainer {

  // * Initalize orchestra "instruments"
  //      * Bass motors (Both shooter motors)
  private OrchestraSubsystem leftBassMotor = new OrchestraSubsystem(0, null);
  private OrchestraSubsystem rightBassMotor = new OrchestraSubsystem(0, null);
  //      * Melody motors (Both roller motors)
  private OrchestraSubsystem ampMelodyMotor = new OrchestraSubsystem(0, null);
  private OrchestraSubsystem intakeMelodyMotor = new OrchestraSubsystem(0, null);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {}

  private void readMusicFromJson() {
    
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
