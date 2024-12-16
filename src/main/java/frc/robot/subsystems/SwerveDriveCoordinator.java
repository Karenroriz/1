package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.Joystick;

public class SwerveDriveCoordinator {

    SwerveWheel leftFrontWheel;
    SwerveWheel leftBackWheel;
    SwerveWheel rightBackWheel;
    SwerveWheel rightFrontWheel;
    private Joystick driverController;

    public void Drive(CANSparkMax motorLeftFrontSpeed, CANSparkMax motorLeftFrontDirection, CANSparkMax motorLeftBackSpeed, CANSparkMax motorLeftBackDirection, 
    CANSparkMax motorRightFrontSpeed, CANSparkMax motorRightFrontDirection, CANSparkMax motorRightBackSpeed, CANSparkMax motorRightBackDirection){

    leftFrontWheel = new SwerveWheel(motorLeftFrontSpeed, motorLeftFrontDirection);
    leftBackWheel = new SwerveWheel(motorLeftBackSpeed, motorLeftBackDirection);
    rightFrontWheel = new SwerveWheel(motorRightFrontSpeed, motorRightFrontDirection);
    rightBackWheel = new SwerveWheel(motorRightBackSpeed, motorRightBackDirection);
    }
    public SwerveDriveCoordinator(SwerveWheel leftFrontWheel, SwerveWheel leftBackWheel, SwerveWheel rightFrontWheel, SwerveWheel rightBackWheel)
    {
        this.leftFrontWheel = leftFrontWheel;
        this.leftBackWheel = leftBackWheel;
        this.rightFrontWheel = rightFrontWheel;
        this.rightBackWheel = rightBackWheel;
    }

    public void translate(double direction, double power)
{
    leftFrontWheel.setDirection(driverController.getPOV());
    leftBackWheel.setDirection(driverController.getPOV());
    rightFrontWheel.setDirection(driverController.getPOV());
    rightBackWheel.setDirection(driverController.getPOV());

    leftFrontWheel.setSpeed(0.25);
    leftBackWheel.setSpeed(0.25);
    rightFrontWheel.setSpeed(0.25);
    rightBackWheel.setSpeed(0.25);
}

public void inplaceTurn(double power)
{
    leftFrontWheel.setDirection(135.0);
    leftBackWheel.setDirection(45.0);
    rightFrontWheel.setDirection(-45.0);
    rightBackWheel.setDirection(-135.0);

    leftFrontWheel.setSpeed(0.25);
    leftBackWheel.setSpeed(0.25);
    rightFrontWheel.setSpeed(0.25);
    rightBackWheel.setSpeed(0.25);
}
}

