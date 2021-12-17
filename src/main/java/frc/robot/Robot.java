package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
  }

  @Override
  public void teleopPeriodic() {
    double arm = driver.getY(Hand.kLeft);
    armA.set(ControlMode.PercentOutput, arm);
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
