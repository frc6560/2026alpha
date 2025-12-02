package frc.robot.subsystems.vision;

import java.util.HashMap;
import edu.wpi.first.math.Pair;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Pose3d;
import frc.robot.utility.LimelightHelpers;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Vision extends SubsystemBase{
    private final String[] cameraNames;
    private final HashMap<String, Pose2d> cameraPoses = new HashMap<>();
    private final HashMap<String, Double> cameraStdDevs = new HashMap<>();

    public Vision(String[] cameraNames) {
        this.cameraNames = cameraNames;
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        // Update vision data here, use all filters, stuff
        for(String cameraName : cameraNames){

            // hi do nothing here for now
        }
    }


    /** Returns a set of two values per camera: the Pose2d of the robot on the field as determined by the limelight, 
     * and the standard deviation to feed into our Kalman filter
     * @param cameraName The name of the camera to get data from
     * @return A pair containing the Pose2d and standard deviation
     */
    public Pair<Pose2d, Double> getLimelightData(String cameraName){
        return new Pair<>(cameraPoses.get(cameraName), cameraStdDevs.get(cameraName));
    }

    /** Returns the total latency of the camera pipeline
     * @param cameraName The name of the camera to get data from
     * @return The total latency in milliseconds
     */
    public double getCameraLatency(String cameraName){
        return LimelightHelpers.getLatency_Capture(cameraName) + LimelightHelpers.getLatency_Pipeline(cameraName);
    }
}
