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
}
