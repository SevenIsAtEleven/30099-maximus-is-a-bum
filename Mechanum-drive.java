// INSTRUCTIONS FOR USE
// 
// Name motors
// Front left wheel motor name = motor_f_l
// Front right wheel motor name = motor_f_r
// Back left wheel motor name = motor_b_l
// Back right wheel motor name = motor_b_r

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;


@teleop()
public class Drive_Mechanism extends OpMode {
	@Override()
	public void init() {
		telemetry.addData("Init", "Code initialized.Proceeding to loop.");
	}
	@Override()
	public void loop() {
		if (gamepad_drive.right_stick_x != 0 || gamepad_drive.right_stick_y != 0) {
			telemetry.addData("Gamepad_drive", "y_val");
			telemetry.addData("Gamepad_drive", gamepad_drive.right_stick_y);
			telemetry.addData("Gamepad_drive", "x_val");
			telemetry.addData("Gamepad_drive", gamepad_drive.right_stick_x);
			this.set_speed()
		}
	}
	
	public void set_speed() {
		double x_val = gamepad_drive.right_stick_x;
		double y_val = gamepad_drive.right_stick_y * -1;
		double strafe_val = gamepad_drive.left_stick_x;
		double front_left_speed = Math.floorDiv(y_val + x_val + strafe_val, 1);
		double front_right_speed = Math.floorDiv(y_val - x_val - strafe_val, 1);
		double back_left_speed = Math.floorDiv(y_val - x_val + strafe_val, 1);
		double back_right_speed = Math.floorDiv(y_val + x_val - strafe_val, 1);
		
		motor_f_l.setPower(front_left_speed)
		motor_f_r.setPower(front_right_speed)
		motor_b_l.setPower(back_left_speed)
		motor_b_r.setPower(back_right_speed)
		
		telemetry.addData("Gamepad_drive", "y val");
		telemetry.addData("Gamepad_drive", x_val);
		telemetry.addData("Gamepad_drive", "x val");
		telemetry.addData("Gamepad_drive", y_val);
		telemetry.addData("Gamepad_drive", "left speed");
		telemetry.addData("Gamepad_drive", left_speed);
		telemetry.addData("Gamepad_drive", "right speed");
		telemetry.addData("Gamepad_drive", right_speed);
	}
	
	public void initialize_motors() {
		DcMotor motor_f_l;
		DcMotor motor_f_r;
		DcMotor motor_b_l;
		DcMotor motor_b_r;
		motor_f_l = hwMap.get(DcMotor.class, "motor_f_l");
		motor_f_l.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
		telemetry.addData("Gamepad_drive", "Front Left motor initialized");
		motor_f_r = hwMap.get(DcMotor.class, "motor_f_r");
		motor_f_r.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
		telemetry.addData("Gamepad_drive", "Front Right motor initialized");
		motor_b_l = hwMap.get(DcMotor.class, "motor_b_l");
		motor_b_l.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
		telemetry.addData("Gamepad_drive", "Back Left motor initialized");
		motor_b_r = hwMap.get(DcMotor.class, "motor_b_r");
		motor_b_r.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
		telemetry.addData("Gamepad_drive", "Back Right motor initialized");
	}
}
