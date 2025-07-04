package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import org.firstinspires.ftc.teamcode.robot;

@TeleOp
public class main extends LinearOpMode {
    // External class implementation to make code cleaner
    private robot sys = new robot();

    // Connect motors
    // ID should match config
    private DcMotor motor_fl;
    private DcMotor motor_bl;
    private DcMotor motor_fr;
    private DcMotor motor_br;

    //intake config
    private DcMotor h_slide_motor;

    @Override
    public void runOpMode() throws InterruptedException {
        motor_fl = hardwareMap.dcMotor.get("motor_f_l");
        motor_bl = hardwareMap.dcMotor.get("motor_b_l");
        motor_fr = hardwareMap.dcMotor.get("motor_f_r");
        motor_br = hardwareMap.dcMotor.get("motor_b_r");
        
        h_slide_motor = hardwareMap.dcMotor.get("hs_motor")

	/*while (opModeInInit()) {
            sys.funny_start_sequence(h_slide_motor);
        }*/

        waitForStart();

        // End when stop is pressed
        if (isStopRequested()) {
            return;
        }

        // Separate method implementation
        while (opModeIsActive()) {
            sys.drive(gamepad1, motor_fl, motor_bl, motor_fr, motor_br);
            sys.horizontal_slide(gamepad2, h_slide_motor)
        }
    }
}
