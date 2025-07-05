public class Mecanum_drive extends LinearOpMode {

    // Motors
    private DcMotor motor_fl;
    private DcMotor motor_bl;
    private DcMotor motor_fr;
    private DcMotor motor_br;
    
    public void runOpMode() {
        
        // Connect motors
        // Ids must match config
        motor_fl = hardwareMap.dcMotor.get("motor_f_l");
        motor_bl = hardwareMap.dcMotor.get("motor_b_l");
        motor_fr = hardwareMap.dcMotor.get("motor_f_r");
        motor_br = hardwareMap.dcMotor.get("motor_b_r");

        waitForStart();

        if (isStopRequested()) {
            return;
        }

        // Separate method implementation
        while (opModeIsActive()) {
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
            motor_f_l.setPower(power_fl);
            motor_b_l.setPower(power_bl);
            motor_f_r.setPower(power_fr);
            motor_b_r.setPower(power_br);
        }
    }
