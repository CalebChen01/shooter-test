// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.ShooterConstants.*;

public class Shooter extends SubsystemBase {
  /** Creates a new Shooter. */
  private double flywheelSpeed;
  private double hoodRotation;
  private double turretRotation;

  private final SparkMax flywheelMotor;
  private final SparkMax hoodRotationMotor;
  private final SparkMax turretRotationMotor;

  public Shooter() {
    flywheelSpeed = 0.0;
    hoodRotation = 0.0;
    turretRotation = 0.0;

    flywheelMotor = new SparkMax(FLYWHEEL_MOTOR_ID, MotorType.kBrushless);
    hoodRotationMotor = new SparkMax(HOOD_ROTATION_MOTOR_ID, MotorType.kBrushless);
    turretRotationMotor = new SparkMax(TURRET_ROTATION_MOTOR_ID, MotorType.kBrushless);

    SparkMaxConfig config = new SparkMaxConfig();
    config.voltageCompensation(12);
    config.smartCurrentLimit(DRIVE_MOTOR_CURRENT_LIMIT);
  }

  public Command shoot() {
    return Commands.run(() -> setFlywheelSpeed(0.5), this);
  }

  public Command stop() {
    return Commands.run(()-> setFlywheelSpeed(0.0), this);

  }

  public void setFlywheelSpeed(double flywheelSpeed) {
    flywheelMotor.set(flywheelSpeed);
  }

  public void setHoodRotation(double hoodRotation) {
    hoodRotationMotor.set(hoodRotation);
  }

  public void setTurretRotation(double turretRotation) {
    turretRotationMotor.set(turretRotation);
  }

  public double getFlywheelSpeed() {
    return flywheelSpeed;
  }

  public double getHoodRotation() {
    return hoodRotation;
  }

  public double getTurretRotation() {
    return turretRotation;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
