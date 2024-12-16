package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Drive;

public class ResetDirection extends Command {
    Drive m_drive;

    double[] angles = new double[3];
    boolean[] corrected = new boolean[3];

    public ResetDirection(Drive s_drive){
        this.m_drive = new Drive();
        addRequirements(m_drive);
    }


    @Override
    public void initialize() {
        // TODO Auto-generated method stub

        corrected = new boolean[]{false,false,false,false};
        super.initialize();
    }
    

    @Override
    public void execute() {
        angles = m_drive.angle;

        if(angles[0] > 0.1){
            m_drive.motorLeftFrontDirection.set(0.05);
        }else if(angles[0] < -0.1){
            m_drive.motorLeftFrontDirection.set(-0.05);
        }else{
            corrected[0] = true;
        }

        if(angles[1] > 0.1){
            m_drive.motorLeftBackDirection.set(0.05);
        }else if(angles[1] < -0.1){
            m_drive.motorLeftBackDirection.set(-0.05);
        }

        if(angles[2] > 0.1){
            m_drive.motorRightFrontDirection.set(0.05);
        }else if(angles[2] < -0.1){
            m_drive.motorRightFrontDirection.set(-0.05);
        }

        if(angles[3] > 0.1){
            m_drive.motorRightBackDirection.set(0.05);
        }else if(angles[3] < -0.1){
            m_drive.motorRightBackDirection.set(-0.05);
        }

        isFinished();
    }
    
    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
    }


    @Override
    public boolean isFinished() {
        for(boolean b : corrected) if(!b) return false;
        return true;
    }

    
    
}
