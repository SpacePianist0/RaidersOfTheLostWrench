package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.acmerobotics.roadrunner.trajectory.constraints.TrajectoryAccelerationConstraint;
import com.acmerobotics.roadrunner.trajectory.constraints.TrajectoryVelocityConstraint;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;
import org.openftc.apriltag.AprilTagDetection;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvInternalCamera;
import org.openftc.easyopencv.OpenCvInternalCamera2;

import java.util.ArrayList;

@Autonomous(name="Autouno", group="Autouno")

public class Autouno extends LinearOpMode {
    private DcMotor frontLeft;
    private DcMotor backLeft;
    private DcMotor frontRight;
    private DcMotor backRight;
    private DcMotor JimmysLimb;
    private CRServo serve;
    private CRServo oh;
    private ElapsedTime runtime = new ElapsedTime();
    private int rehehehe = 0;

    public void forward(double speed, int tim) {
        frontLeft.setPower(-speed);
        frontRight.setPower(-speed);
        backLeft.setPower(speed);
        backRight.setPower(speed);
        sleep(tim);
    }

    public void stop(int tim) {
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
        sleep(tim);
    }

    public void strafe(double speed, int tim) {
        frontLeft.setPower(-speed);
        frontRight.setPower(speed);
        backLeft.setPower(-speed);
        backRight.setPower(speed);
        sleep(tim);
    }

    public void section1() {
        forward(0.35, 100);
        stop(1000);
        strafe(-0.35, 1800);
        stop(1000);
        forward(0.35, 1800);
        stop(999999999);
    }

    public void section2() {
        JimmysLimb.setPower(0.5);
        sleep(100);
        JimmysLimb.setPower(0.15);
        frontLeft.setPower(-0.35);
        frontRight.setPower(-0.35 - 0.05);
        backLeft.setPower(0.35);
        backRight.setPower(0.35);
        sleep(2500);
        frontLeft.setPower(0.35);
        frontRight.setPower(-0.35 - 0.05);
        backLeft.setPower(-0.35);
        backRight.setPower(0.35);
        sleep(500);
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
        JimmysLimb.setPower(1);
        sleep(1700);
        JimmysLimb.setPower(0.15);
        frontLeft.setPower(-0.2 - 0.05);
        frontRight.setPower(-0.2);
        backLeft.setPower(0.2);
        backRight.setPower(0.2);
        sleep(600);
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
        oh.setPower(-1);
        sleep(2000);
        oh.setPower(0);
        frontLeft.setPower(0.2);
        frontRight.setPower(0.2 + 0.05);
        backLeft.setPower(-0.2);
        backRight.setPower(-0.2);
        sleep(600);
        JimmysLimb.setPower(0);
        frontLeft.setPower(-0.35);
        frontRight.setPower(0.35 + 0.05);
        backLeft.setPower(0.35);
        backRight.setPower(-0.35);
        sleep(600);
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
        stop(100);
//Perry, good luck! Ms. Shields
    }

    public void section3() {
        frontLeft.setPower(-0.35);
        frontRight.setPower(-0.35 - 0.05);
        backLeft.setPower(0.35);
        backRight.setPower(0.35);
        sleep(100);
        stop(1000);
        frontLeft.setPower(-0.35);
        frontRight.setPower(0.35 - 0.05);
        backLeft.setPower(-0.35);
        backRight.setPower(0.35);
        sleep(2200);
        stop(1000);
        frontLeft.setPower(-0.35);
        frontRight.setPower(-0.35 - 0.05);
        backLeft.setPower(0.35);
        backRight.setPower(0.35);
        sleep(1200);
        stop(999999999);
    }

    public void spinLeftRaw(double power) {
        frontRight.setPower(power * -1);
        backRight.setPower(power * -1);
        frontLeft.setPower(power);
        backLeft.setPower(power);
    }

    public void spinRightRaw(double power) {
        frontRight.setPower(power);
        backRight.setPower(power);
        frontLeft.setPower(power * -1);
        backLeft.setPower(power * -1);
    }

    public void strafeLeftRaw(double power) {
        frontRight.setPower(power);
        backRight.setPower(power * -1);
        frontLeft.setPower(power * -1);
        backLeft.setPower(power);
    }

    public void strafeRightRaw(double power) {
        frontRight.setPower(power * -1);
        backRight.setPower(power);
        frontLeft.setPower(power);
        backLeft.setPower(power * -1);
    }

    public void backwardRaw(double power) {
        frontRight.setPower(power * -1);
        backRight.setPower(power * -1);
        frontLeft.setPower(power * -1);
        backLeft.setPower(power * -1);
    }

    public void forwardRaw(double power) {
        frontRight.setPower(power);
        backRight.setPower(power);
        frontLeft.setPower(power);
        backLeft.setPower(power);
    }

    public void forwardRaw() {
        forwardRaw(1);
    }

    public void backwardRaw() {
        backwardRaw(1);
    }

    public void strafeLeftRaw() {
        strafeLeftRaw(1);
    }

    public void spinLeftRaw() {
        spinLeftRaw(1);
    }

    public void spinRightRaw() {
        spinRightRaw(1);
    }

    public void Run_without_encoder() {
        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public void Run_using_encoder() {
        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void Run_to_position() {
        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void Stop_and_reset_encoder() {
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    private void forwardE(int distance, double speed) {
        Stop_and_reset_encoder();
        frontLeft.setTargetPosition(distance);
        frontRight.setTargetPosition(distance);
        backLeft.setTargetPosition(distance);
        backRight.setTargetPosition(distance);
        while (frontLeft.isBusy()) {
            forwardRaw(speed);
        }
        Run_to_position();
    }

    OpenCvCamera camera;
    AprilTagDetectionPipeline aprilTagDetectionPipeline;

    static final double FEET_PER_METER = 3.28084;

    // Lens intrinsics
    // UNITS ARE PIXELS
    // NOTE: this calibration is for the C920 webcam at 800x448.
    // You will need to do your own calibration for other configurations!
    double fx = 578.272;
    double fy = 578.272;
    double cx = 402.145;
    double cy = 221.506;

    // UNITS ARE METERS
    double tagsize = 0.166;

    int numFramesWithoutDetection = 0;

    final float DECIMATION_HIGH = 3;
    final float DECIMATION_LOW = 2;
    final float THRESHOLD_HIGH_DECIMATION_RANGE_METERS = 1.0f;
    final int THRESHOLD_NUM_FRAMES_NO_DETECTION_BEFORE_LOW_DECIMATION = 4;

    @Override
    public void runOpMode() {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
        Pose2d startPose = new Pose2d(0, 0, Math.toRadians(0));
        Trajectory traj1 = drive.trajectoryBuilder(startPose)
                .forward(57)
                .build();
        Trajectory traj2 = drive.trajectoryBuilder(traj1.end())
                .strafeRight(12)
                .build();
        Trajectory traj3 = drive.trajectoryBuilder(traj2.end())
                .forward(8)
                .build();
        Trajectory traj4 = drive.trajectoryBuilder(traj3.end())
                .back(5)
                .build();
        Trajectory traj5 = drive.trajectoryBuilder(traj4.end())
                .strafeLeft(13)
                .build();
        Trajectory traj6 = drive.trajectoryBuilder(traj5.end())
                .forward(13)
                .build();
        Trajectory traj7 = drive.trajectoryBuilder(traj6.end())
                .back(13)
                .build();
        Trajectory traj8 = drive.trajectoryBuilder(traj7.end())
                .back(25)
                .build();
        Trajectory zone1 = drive.trajectoryBuilder(traj6.end())
                    .strafeLeft(23)
                .build();
        Trajectory zone2 = drive.trajectoryBuilder(traj6.end())
                .strafeLeft(1)
                .build();
        Trajectory zone3 = drive.trajectoryBuilder(traj6.end())
                .strafeRight(23)
                .build();

        Trajectory sploin = drive.trajectoryBuilder(startPose)
                .splineTo(new Vector2d(20, 3), 0)
                .splineTo(new Vector2d(40, -3), 0)
                .splineTo(new Vector2d(60, -3), 0)
                .splineTo(new Vector2d(80, 3), 0)
                .build();

        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        camera = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "wishywatchy"), cameraMonitorViewId);
        aprilTagDetectionPipeline = new AprilTagDetectionPipeline(tagsize, fx, fy, cx, cy);

        camera.setPipeline(aprilTagDetectionPipeline);
        camera.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener() {
            @Override
            public void onOpened() {
                camera.startStreaming(800, 448, OpenCvCameraRotation.UPRIGHT);
            }

            @Override
            public void onError(int errorCode) {

            }
        });
        while (opModeInInit()) {
        // Calling getDetectionsUpdate() will only return an object if there was a new frame
        // processed since the last time we called it. Otherwise, it will return null. This
        // enables us to only run logic when there has been a new frame, as opposed to the
        // getLatestDetections() method which will always return an object.
        ArrayList<AprilTagDetection> detections = aprilTagDetectionPipeline.getDetectionsUpdate();

        // If there's been a new frame...
            if (detections != null) {
                telemetry.addData("FPS", camera.getFps());
                telemetry.addData("Overhead ms", camera.getOverheadTimeMs());
                telemetry.addData("Pipeline ms", camera.getPipelineTimeMs());
                telemetry.addData("zone sensed: ", rehehehe);

                // If we don't see any tags
                if (detections.size() == 0) {
                    numFramesWithoutDetection++;

                    // If we haven't seen a tag for a few frames, lower the decimation
                    // so we can hopefully pick one up if we're e.g. far back
                    if (numFramesWithoutDetection >= THRESHOLD_NUM_FRAMES_NO_DETECTION_BEFORE_LOW_DECIMATION) {
                        aprilTagDetectionPipeline.setDecimation(DECIMATION_LOW);
                    }
                }
                // We do see tags!
                else {
                    numFramesWithoutDetection = 0;

                    // If the target is within 1 meter, turn on high decimation to
                    // increase the frame rate
                    if (detections.get(0).pose.z < THRESHOLD_HIGH_DECIMATION_RANGE_METERS) {
                        aprilTagDetectionPipeline.setDecimation(DECIMATION_HIGH);
                    }

                    for (AprilTagDetection detection : detections) {
                        telemetry.addLine(String.format("\nDetected tag ID=%d", detection.id));
                        telemetry.addLine(String.format("Translation X: %.2f feet", detection.pose.x * FEET_PER_METER));
                        telemetry.addLine(String.format("Translation Y: %.2f feet", detection.pose.y * FEET_PER_METER));
                        telemetry.addLine(String.format("Translation Z: %.2f feet", detection.pose.z * FEET_PER_METER));
                        telemetry.addLine(String.format("Rotation Yaw: %.2f degrees", Math.toDegrees(detection.pose.yaw)));
                        telemetry.addLine(String.format("Rotation Pitch: %.2f degrees", Math.toDegrees(detection.pose.pitch)));
                        telemetry.addLine(String.format("Rotation Roll: %.2f degrees", Math.toDegrees(detection.pose.roll)));
                        telemetry.update();
                        if (detection.id == 1) {
                            rehehehe = 1;
                        }
                        if (detection.id == 2) {
                            rehehehe = 2;
                        }
                        if (detection.id == 3) {
                            rehehehe = 3;
                        }
                    }
                }
                telemetry.update();
            }
            sleep(20);
        }
        waitForStart();
        telemetry.setMsTransmissionInterval(50);
            telemetry.addData("rehehehe: ", rehehehe);
            frontLeft = hardwareMap.get(DcMotor.class, "frontleft");
            backLeft = hardwareMap.get(DcMotor.class, "backleft");
            frontRight = hardwareMap.get(DcMotor.class, "frontright");
            backRight = hardwareMap.get(DcMotor.class, "backright");
            JimmysLimb = hardwareMap.get(DcMotor.class, "LimboJim");
            serve = hardwareMap.get(CRServo.class, "spinnyjoe");
            oh = hardwareMap.get(CRServo.class, "spinnyjen");
            telemetry.addData("Status", "Initialized");
            telemetry.update();

            if(isStopRequested()) return;

            //telemetry.addData("uh oh! an issue!", "seems like 'rehehehehe' didn't scan the tags! Oh frick! no bueno! Abort!");
//            JimmysLimb.setPower(1);
//            sleep(300);
//            JimmysLimb.setPower(0.15);
//            drive.followTrajectory(traj1);
//            drive.followTrajectory(traj2);
//            JimmysLimb.setPower(1);
//            sleep(2000);
//            JimmysLimb.setPower(0.15);
//            oh.setPower(-1);
//            sleep(1000);
//            drive.followTrajectory(traj3);
//            drive.followTrajectory(traj4);
//            JimmysLimb.setPower(0);
//            sleep(1000);
//            JimmysLimb.setPower(0.15);
//            drive.followTrajectory(traj5);
            //drive.turn(Math.toRadians(90));
            //drive.followTrajectory(traj6);
            //oh.setPower(1);
            //sleep(1000);
            //JimmysLimb.setPower(1);
            //sleep(100);
            //drive.followTrajectory(traj7);
            //drive.turn(Math.toRadians(-90));
            //TODO: Repeat trajectory _2_ through _7_ then set up for another cone
            //TODO: Repeat trajectory _2_ through _4_ and drop fully to ground. DO NOT turn ninety degrees
            if(rehehehe == 1) {
                telemetry.addData("message for danny:     ", "knock knock, who's there?, weather, weather who? I dont know whether or not you heard me knock."); //drive.followTrajectory(zone1);
            }
            if(rehehehe == 2) {
                telemetry.addData("message for danny:     ", "Am I funny?");
            }
            if(rehehehe == 3) {
                telemetry.addData("message for danny:     ", "lol, I'm not funny"); //drive.followTrajectory(zone3);
            }
            if(rehehehe == 0) {
                telemetry.addData("Uh oh! an issue has ocured! rehehehe = ", rehehehe);
            }
            telemetry.update();
            sleep(1000000);
        }
    }
