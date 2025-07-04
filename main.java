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

    //private DcMotor horizontal_slide_extension = hardwareMap.dcMotor.get("horizontal_slide")

    @Override
    public void runOpMode() throws InterruptedException {
        motor_fl = hardwareMap.dcMotor.get("motor_f_l");
        motor_bl = hardwareMap.dcMotor.get("motor_b_l");
        motor_fr = hardwareMap.dcMotor.get("motor_f_r");
        motor_br = hardwareMap.dcMotor.get("motor_b_r");

	/*while (opModeInInit()) {
            this.funny_start_sequence();
        }*/

        waitForStart();

        // End when stop is pressed
        if (isStopRequested()) {
            return;
        }

        // Separate method implementation
        while (opModeIsActive()) {
            sys.drive(gamepad1, motor_fl, motor_bl, motor_fr, motor_br);
        }
    }
    /*public void drive() {
        // y_val reversed
        double y = -gamepad1.left_stick_y;

        // Multiplier of 1.17 to counteract strafing range
        double x = gamepad1.left_stick_x * 1.17;
        double rx = gamepad1.right_stick_x;

        // Range_limiter containes power within range [-1,1]
        double range_limiter = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        double power_fl = -1 * ((y + x + rx) / range_limiter);
        double power_bl = -1 * ((y - x + rx) / range_limiter);
        double power_fr = (y - x - rx) / range_limiter;
        double power_br = (y + x - rx) / range_limiter;

        // Set Power
        motor_fl.setPower(power_fl);
        motor_bl.setPower(power_bl);
        motor_fr.setPower(power_fr);
        motor_br.setPower(power_br);
    }

    //BETA!!!
    // funny start up sequence cos why not
    public void funny_start_sequence() {
        horizontal_slide_extension.setPower(1);
        Thread.sleep(750000000);
        horizontal_slide_extension.setPower(1);
    }*/
}
