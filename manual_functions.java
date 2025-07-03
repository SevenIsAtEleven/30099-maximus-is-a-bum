package org.firstinspires.ftc.teamcode.mechanisms;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
//Plan

//first, we gotta use the initialize function to set up all the motors and connect them
//then we gotta code like the manual functions
//then from main.java, which doesnt exist yet, we gotta do the @teleop thingy
public class robot {
    public void initialize(HardwareMap hwMap) {
        telemetry.addData("Sys", "Starting initialization process");
        telemetry.update();
        
        // Mechanum drive Connection
        telemetry.addData("Sys", "Connecting Mechanum drive");
        telemetry.update();
        
        DcMotor motor_f_l;
	DcMotor motor_f_r;
	DcMotor motor_b_l;
	DcMotor motor_b_r;
	motor_f_l = hwMap.get(DcMotor.class, "motor_f_l");
	motor_f_l.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
	motor_f_r = hwMap.get(DcMotor.class, "motor_f_r");
	motor_f_r.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
	motor_b_l = hwMap.get(DcMotor.class, "motor_b_l");
	motor_b_l.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
	motor_b_r = hwMap.get(DcMotor.class, "motor_b_r");
	motor_b_r.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

	motor_f_l.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
	motor_f_r.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
	motor_b_l.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
	motor_b_r.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        
        telemetry.addData("Sys", "Drive motors connected");
        telemetry.update();
        
        //Intake Connection
        telemetry.addData("Sys", "Connecting intake");
        telemetry.update();
        
        CRServo intake_servo;
        intake_servo = hwMap.get(CRServo.class, "intake_servo");
	intake_servo.setZeroPowerBehaviour(DcMotor.ZeroPowerBehaviour.FLOAT);

        DcMotor motor_slide_expansion;
        motor_slide_expansion = hwMap.get(DcMotor.class, "motor_slide_expansion");
        motor_slide_expansion.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        Servo box_rotation;
        box_rotation = hwMap.get(Servo.class, "box_rotation");
        telemetry.addData("Sys", "Intake connected");
        telemetry.update();

	//Outtake Connection
	Servo claw;
	claw = hwMap.get(Servo.class)
        
    }
    public void Mechanum_drive() {
        
        double x_val = gamepad1.right_stick_x;
        double y_val = gamepad1.right_stick_y * -1;
        double strafe_val = gamepad1.left_stick_x;
        int front_left_speed = Math.floorDiv(y_val + x_val + strafe_val, 1);
        int front_right_speed = Math.floorDiv(y_val - x_val - strafe_val, 1);
        int back_left_speed = Math.floorDiv(y_val - x_val + strafe_val, 1);
        int back_right_speed = Math.floorDiv(y_val + x_val - strafe_val, 1);
        
        motor_f_l.setPower(front_left_speed);
        motor_f_r.setPower(front_right_speed);
        motor_b_l.setPower(back_left_speed);
        motor_b_r.setPower(back_right_speed);

        telemetry.addData("gamepad1", "front left speed");
        telemetry.update();
        telemetry.addData("gamepad1", front_left_speed);
        telemetry.update();
        telemetry.addData("gamepad1", "front right speed");
        telemetry.update();
        telemetry.addData("gamepad1", front_right_speed);
        telemetry.update();
        telemetry.addData("gamepad1", "back left speed");
        telemetry.update();
        telemetry.addData("gamepad1", back_left_speed);
        telemetry.update();
        telemetry.addData("gamepad1", "back right speed");
        telemetry.update();
        telemetry.addData("gamepad1", back_right_speed);
        telemetry.update();

    }
    public void spin_intake() {
	forward = gamepad2.right_trigger;
	reverse = gamepad2.left_trigger;
	spin = forward - reverse;
	intake_servo.setPower(spin);
    }
    public void horizontal_expansion() {
    
    }
    public void intake_box() {

    }
    public void claw (boolean open) {
    
    }
    public void vertical_expansion() {

    }
    public void swing() {

    }
    public void check_inputs() {
        this.Mechanum_drive();
	this.spin_intake();
    }
}
