// INSTRUCTIONS FOR USE
// 
// IMPORTANT NOTE!!!
// 1. Make sure you are using a controller compatible with FTC SDK.
// 2. Make sure your wheels are Mechanum wheels, or other wheels with the same properties.
//
// Motor configuration
// Front left wheel motor name = motor_f_l
// Front right wheel motor name = motor_f_r
// Back left wheel motor name = motor_b_l
// Back right wheel motor name = motor_b_r
//
// Gamepad Configuration
// Gamepad1 name = gamepad1
// Gamepad2 name = gamepad2
//
// SEE BOTTOM FOR DRIVING INSTRUCTIONS

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;	

@teleop()
public class Mechanum_drive extends OpMode {
	@Override()
	public void init() {
		telemetry.addData("Init", "Code initialized.Proceeding to loop.");
	}
	@Override()
	public void loop() {
		if (gamepad1.right_stick_x != 0 || gamepad1.right_stick_y != 0) {
			telemetry.addData("gamepad1", "y_val");
			telemetry.addData("gamepad1", gamepad1.right_stick_y);
			telemetry.addData("gamepad1", "x_val");
			telemetry.addData("gamepad1", gamepad1.right_stick_x);
			this.drive()
		}
	}
	
	public void drive() {
		double x_val = gamepad1.right_stick_x;
		double y_val = gamepad1.right_stick_y * -1;
		double strafe_val = gamepad1.left_stick_x;
		double front_left_speed = Math.floorDiv(y_val + x_val + strafe_val, 1);
		double front_right_speed = Math.floorDiv(y_val - x_val - strafe_val, 1);
		double back_left_speed = Math.floorDiv(y_val - x_val + strafe_val, 1);
		double back_right_speed = Math.floorDiv(y_val + x_val - strafe_val, 1);
		
		motor_f_l.setPower(front_left_speed)
		motor_f_r.setPower(front_right_speed)
		motor_b_l.setPower(back_left_speed)
		motor_b_r.setPower(back_right_speed)
		
		telemetry.addData("gamepad1", "front left speed");
		telemetry.addData("gamepad1", front_left_speed);
		telemetry.addData("gamepad1", "front right speed");
		telemetry.addData("gamepad1", front_right_speed);
		telemetry.addData("gamepad1", "back left speed");
		telemetry.addData("gamepad1", back_left_speed);
		telemetry.addData("gamepad1", "back right speed");
		telemetry.addData("gamepad1", back_right_speed);
	}
	
	public void initialize_motors() {
		DcMotor motor_f_l;
		DcMotor motor_f_r;
		DcMotor motor_b_l;
		DcMotor motor_b_r;
		motor_f_l = hwMap.get(DcMotor.class, "motor_f_l");
		motor_f_l.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
		telemetry.addData("gamepad1", "Front Left motor initialized");
		motor_f_r = hwMap.get(DcMotor.class, "motor_f_r");
		motor_f_r.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
		telemetry.addData("gamepad1", "Front Right motor initialized");
		motor_b_l = hwMap.get(DcMotor.class, "motor_b_l");
		motor_b_l.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
		telemetry.addData("gamepad1", "Back Left motor initialized");
		motor_b_r = hwMap.get(DcMotor.class, "motor_b_r");
		motor_b_r.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
		telemetry.addData("gamepad1", "Back Right motor initialized");
	}
}

// DRIVING INSTRUCTIONS
//
// One of your controllers will be controlling the driving of the robot. The controller should have been configured as mentioned at the beginning of the page
// Your right joystick will be controlling the normal movement of the robot, while the left joystick will control strafing features
// Pushing the right joystick forward will move the robot forward and vice versa
// Pushing the right joystick right will cause the robot to ROTATE, not turn, but rotate to the right. This rotation is compatible with forward and backward movement, and vice versa for left.
// Pushing the left joystick right will cause the robot to strafe or move horizontally to the right, and vice versa. Strafing has been made compatible with forward, backward, and rotational movement. However, it should usually be used alone and with caution.
