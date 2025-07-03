package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import com.qualcomm.robotcore.hardware.DcMotor;
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

    }

    public void initialize_intake() {
        CRServo intake_servo;
	intake_servo = hwMap.get(CRServo.class, "intake_servo");
	      
	      
	DcMotor motor_slide_expansion;
	motor_slide_expansion = hwMap.get(DcMotor.class, "motor_slide_expansion");
	motor_slide_expansion.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void  {
        ;
    }
}
