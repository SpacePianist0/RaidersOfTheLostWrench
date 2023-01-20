package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@TeleOp

public class ControlTestOne extends LinearOpMode {

    private DcMotor frontLeft;
    private DcMotor backLeft;
    private DcMotor frontRight;
    private DcMotor backRight;
    private DcMotor JimmysLimb;
    private CRServo sir;
    private CRServo oh;

    //public void Run_without_encoder() {
    //    JimmysLimb.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    //}
    //public void Run_using_encoder() {
    //    JimmysLimb.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
    //}
    //public void Run_to_position() {
    //    JimmysLimb.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    //}
    //public void Stop_and_reset_encoder() {
    //    JimmysLimb.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    //}
    //private void lift(double Velocity){
    //    Stop_and_reset_encoder();
    //    Run_using_encoder();
    //    JimmysLimb.setVelocity(200);
    // }

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        frontLeft = hardwareMap.get(DcMotor.class, "frontleft");
        backLeft = hardwareMap.get(DcMotor.class, "backleft");
        frontRight = hardwareMap.get(DcMotor.class, "frontright");
        backRight = hardwareMap.get(DcMotor.class, "backright");
        JimmysLimb = hardwareMap.get(DcMotor.class, "LimboJim");
        sir = hardwareMap.get(CRServo.class, "spinnyjoe");
        oh = hardwareMap.get(CRServo.class, "spinnyjen");
        double speed = 1;
        waitForStart();
        while (opModeIsActive()) {


            if (gamepad1.dpad_down) {
                speed = 1;
            }
            if (gamepad1.dpad_left) {
                speed = 0.85;
            }
            if (gamepad1.dpad_up) {
                speed = 0.7;
            }
            if (gamepad1.dpad_right) {
                speed = 0.28;
            }

            // if (gamepad1.dpad_down == false){
            //     speed = speed;
            // }
            // if (gamepad1.dpad_left == false){
            //     speed = speed;
            // }
            // if (gamepad1.dpad_up == false){
            //     speed = speed;
            // }
            // if (gamepad1.dpad_right == false){
            //     speed = speed;
            // }
            backLeft.setPower((((-1 * speed * gamepad1.left_stick_y + (gamepad1.left_stick_x * -1)) - (gamepad1.right_stick_x * -1)) * speed) * 1);
            backRight.setPower((((-1 * speed * gamepad1.left_stick_y + gamepad1.left_stick_x) - gamepad1.right_stick_x) * speed) * 1);
            frontLeft.setPower((((speed * gamepad1.left_stick_y - gamepad1.left_stick_x) - gamepad1.right_stick_x) * speed) * 1);
            frontRight.setPower((((speed * gamepad1.left_stick_y - (-1 * gamepad1.left_stick_x)) - (-1 * gamepad1.right_stick_x)) * speed) * 1);

            //double speeed = -gamepad1.left_stick_y;
            //double turn = gamepad1.right_stick_x;
            //double strafe = gamepad1.left_stick_x;
            //frontLeft.setPower(speeed + turn + strafe);
            //frontRight.setPower(speeed - turn - strafe);
            //backLeft.setPower(speeed + turn - strafe);
            //backRight.setPower(speeed - turn + strafe);

            if (gamepad1.left_bumper) {
                oh.setDirection(DcMotorSimple.Direction.FORWARD);
                sir.setDirection(DcMotorSimple.Direction.REVERSE);
                oh.setPower(1);
                sir.setPower(1);
            }
            if (gamepad1.right_bumper) {
                oh.setDirection(DcMotorSimple.Direction.REVERSE);
                sir.setDirection(DcMotorSimple.Direction.FORWARD);
                oh.setPower(1);
                sir.setPower(1);
            }
            if (!gamepad1.right_bumper && !gamepad1.left_bumper) {
                oh.setPower(0);
                sir.setPower(0);
            }
            if (gamepad1.right_trigger > 0.2) {
                JimmysLimb.setPower(gamepad1.right_trigger);
            }

            if (gamepad1.left_trigger > 0.2) {
                JimmysLimb.setPower(-0.25);
            }
            if (gamepad1.left_trigger < 0.2 && gamepad1.right_trigger < 0.2) {
                JimmysLimb.setPower(0.15);
            }
            telemetry.addData("speed: ", speed);
            telemetry.update();
        }
    }
}
