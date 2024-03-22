// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.io.FileReader;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;

import java.io.FileReader; 
import java.util.Iterator; 
import java.util.Map; 
  
public class OrchestraModule extends SubsystemBase {

  // Creates New motor
  private CANSparkMax instrument;

  /** 
   * Creates a new orchestraModule.
   * @param MotorID Motor ID (duh)
   * @param idleMode Either kbreak or kCoast, kCoast might sound cool idk try it
  */
  public OrchestraModule(int MotorID, IdleMode idleMode) {
    instrument = new CANSparkMax(MotorID, MotorType.kBrushless);
    instrument.setIdleMode(idleMode);
  }

  /**
   * This command will play a specified note for a certain duration
   * @param note The note that user wants to play, A to A-flat 0-12
   * @param voltage Amount of voltage passed through the motor
   * @param noteDuration How long the note should be
   */
  public Command PlayNote(int note, double voltage, double noteDuration) {
    // * Starting note is A, frequency is 55.00
    // * A - A-flat 0-12
    double frequency = 440 * Math.pow(2, (note - 69)/12);

    return this.runOnce(() -> 
    instrument.setVoltage(voltage))
    .andThen(new WaitCommand(0.5/frequency))
    .andThen(runOnce(() -> instrument.setVoltage(-voltage)))
    .andThen(new WaitCommand(0.5/frequency))
    .repeatedly()
    .withTimeout(noteDuration)
    .andThen(runOnce(() -> instrument.stopMotor()));
  } 


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
