package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.Pigeon2;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;

public class SwerveWheel {

    private Joystick driverController;
    private PIDController directionController;
    private Pigeon2 gyro = new Pigeon2(Constants.pigeon);


public SwerveWheel(CANSparkMax motorSpeed, CANSparkMax motorDirection){
    
 //directionController = new PIDController(P, I, D);
}
    
private static double closestAngle(double a, double b){
// get direction
 double modulo1 = Math.sqrt(Math.pow(b, 2) + Math.pow(360.0, 2));
 double modulo2 = Math.sqrt(Math.pow(a, 2) + Math.pow(360.0, 2));

 double dir = modulo1 - modulo2;

 if (Math.abs(dir) > 180.0){
 dir = -(Math.signum(dir) * 360.0) + dir;
        
}
return dir;

}

public void setDirection(double setpoint){
    directionController.reset();
    setpoint = driverController.getPOV();
    // use the fastest way
    double currentAngle = gyro.getAngle();
    SmartDashboard.getNumber("gyro", gyro.getAngle());
    directionController.setSetpoint(currentAngle + closestAngle(currentAngle, setpoint));
}

public void setSpeed(double speed){
//.set(speed);
}

}
