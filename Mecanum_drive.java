package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class Mecanum_drive extends LinearOpMode {
	@Override
	public void runOpMode() throws InterruptedException {
		// Declare our motors
		// Make sure your ID's match your configuration
		DcMotor motor_fl = hardwareMap.dcMotor.get("motor_f_l");
		DcMotor motor_bl = hardwareMap.dcMotor.get("motor_b_l");
		DcMotor motor_fr = hardwareMap.dcMotor.get("motor_f_r");
		DcMotor motor_br = hardwareMap.dcMotor.get("motor_b_r");

		waitForStart();

		if (isStopRequested()) return;

		while (opModeIsActive()) {
			this.drive();
		}
	}
	public void drive() {
		// y_val reversed
		double y = -gamepad1.left_stick_y;
		// 1.17 to counteract strafing range
		double x = gamepad1.left_stick_x * 1.17;
		double rx = gamepad1.right_stick_x;

		// 
		double range_limiter = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
		double power_fl = -1 * ((y + x + rx) / range_limiter);
		double power_bl = -1 * ((y - x + rx) / range_limiter);
		double power_fr = (y - x - rx) / range_limiter;
		double power_br = (y + x - rx) / range_limiter;

		motor_fl.setPower(power_fl);
		motor_bl.setPower(power_bl);
		motor_fr.setPower(power_fr);
		motor_br.setPower(power_br);
	}
}
