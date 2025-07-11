package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;

@teleop()
public class Intake extends Opmode {
    @override()
    public void init() {
        telemetry.addData("Sys", "Initializing intake");
        this.initialize_intake();
    }
    
    @override()
    public void loop() {
	if (gampead2.right_trigger != 0 || gamepad2.left_trigger != 0) {
	    this.intake();
	}
    }

    public void initialize_intake() {
        CRServo intake_servo;
	intake_servo = hwMap.get(CRServo.class, "intake_servo");
	telemetry.addData("gamepad2", "Intake CRServo initialized");
	
	DcMotor motor_slide_expansion;
	motor_slide_expansion = hwMap.get(DcMotor.class, "motor_slide_expansion");
	motor_slide_expansion.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
	telemetry.addData("gamepad2", "Slide expansion motor initialized");
    }
    public void intake() {
        forward_val = gamepad2.right_trigger;
	reverse_val = gamepad2.left_trigger;
	
	spin_speed = forward_val - reverse_val;
	intake_servo.setPower(spin_speed);

	telemetry.addData("gamepad2", "Intake servo speed");
	telemetry.addData("gamepad2", spin_speed);
    }
    public void intake_box_rotaion() {
        
    }
}
