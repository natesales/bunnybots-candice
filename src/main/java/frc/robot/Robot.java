package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.NeutralMode;

public class Robot extends TimedRobot {
  private TalonSRX armA = new TalonSRX(1);
  // private TalonSRX armB = new TalonSRX(2);
  private XboxController driver = new XboxController(0);

  @Override
  public void robotInit() {
    armA.setInverted(false);
    // armB.setInverted(false);

    // armB.follow(armA);

    armA.configForwardSoftLimitEnable(false);
    armA.configReverseSoftLimitEnable(false);

    armA.configPeakCurrentLimit(5);
    armA.configPeakCurrentDuration(500);

    armA.setNeutralMode(NeutralMode.Brake);
    // armB.setNeutralMode(NeutralMode.Brake);
  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    armA.setSelectedSensorPosition(0);
  }

  @Override
  public void teleopPeriodic() {
    double armPos = armA.getSelectedSensorPosition();
    double armStick = driver.getY(Hand.kLeft);

    SmartDashboard.putNumber("arm/encoder", armPos);
    SmartDashboard.putNumber("arm/stick", armStick);
    SmartDashboard.putNumber("arm/current", armA.getStatorCurrent());

    if (armStick < 0 && armPos <= 1500) {
      armA.set(ControlMode.PercentOutput, armStick);
    } else if (armStick > 0 && armPos >= -10) {
      armA.set(ControlMode.PercentOutput, armStick);
    } else {
      armA.set(ControlMode.PercentOutput, 0.0);
    }
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }
}
