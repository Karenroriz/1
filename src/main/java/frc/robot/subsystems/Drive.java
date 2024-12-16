package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.Pigeon2;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drive extends SubsystemBase {
    
    public CANSparkMax motorLeftFrontDirection;
    public CANSparkMax motorLeftBackDirection;
    public CANSparkMax motorRightFrontDirection;
    public CANSparkMax motorRightBackDirection;
    public CANSparkMax motorLeftFrontSpeed;
    public CANSparkMax motorLeftBackSpeed;
    public CANSparkMax motorRightFrontSpeed;
    public CANSparkMax motorRightBackSpeed;

    public CANcoder encoder1;
    public CANcoder encoder2;
    public CANcoder encoder3;
    public CANcoder encoder4;
    
    public RelativeEncoder SpeedEncoder1;
    public RelativeEncoder SpeedEncoder2;
    public RelativeEncoder SpeedEncoder3;
    public RelativeEncoder SpeedEncoder4;

    public double[] angle = new double[3];


    public Drive(){

    motorLeftFrontDirection = new CANSparkMax(Constants.motorDirection1, MotorType.kBrushless);
    motorLeftBackDirection = new CANSparkMax(Constants.motorDirection2, MotorType.kBrushless);
    motorRightFrontDirection = new CANSparkMax(Constants.motorDirection3, MotorType.kBrushless);
    motorRightBackDirection = new CANSparkMax(Constants.motorDirection4, MotorType.kBrushless);

    motorLeftFrontSpeed = new CANSparkMax(Constants.motorSpeed1, MotorType.kBrushless);
    motorLeftBackSpeed = new CANSparkMax(Constants.motorSpeed2, MotorType.kBrushless);
    motorRightFrontSpeed = new CANSparkMax(Constants.motorSpeed3, MotorType.kBrushless);
    motorRightBackSpeed = new CANSparkMax(Constants.motorSpeed4, MotorType.kBrushless);

    encoder1 = new CANcoder(Constants.CAN1);
    encoder2 = new CANcoder(Constants.CAN2);
    encoder3 = new CANcoder(Constants.CAN3);
    encoder4 = new CANcoder(Constants.CAN4);

    angle[0] = encoder1.getAbsolutePosition().getValueAsDouble();
    angle[1] = encoder2.getAbsolutePosition().getValueAsDouble();
    angle[2] = encoder3.getAbsolutePosition().getValueAsDouble();
    angle[3] = encoder4.getAbsolutePosition().getValueAsDouble();
  
    SmartDashboard.putNumber("Encoder1", angle[0]);
    SmartDashboard.putNumber("Encoder2", angle[1]);
    SmartDashboard.putNumber("Encoder3", angle[2]);
    SmartDashboard.putNumber("Encoder4", angle[3]);

    
    }


    @Override
    public void periodic() {
        SmartDashboard.putNumber("FL", encoder1.getAbsolutePosition().getValueAsDouble());
        SmartDashboard.putNumber("FR", encoder2.getAbsolutePosition().getValueAsDouble());
        SmartDashboard.putNumber("BL", encoder3.getAbsolutePosition().getValueAsDouble());
        SmartDashboard.putNumber("BR", encoder4.getAbsolutePosition().getValueAsDouble());
    }

    
}
