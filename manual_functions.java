public class robot {
    public void initialize() {
        telemetry.addData("Sys", "Starting initialization process")

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
        telemetry.addData("Sys", "Drive motor initialization process complete")
        
        telemetry.addData("Sys", "Starting initialization process")
        telemetry.addData("Sys", "Starting initialization process")
    }
    public void Mechanum_drive() {

    }
    public void spin_intake() {

    }
    public void horizontal_expansion() {
    
    }
    public void intake_box() {

    }
    public void claw(open) {

    }
    public void vertical_expansion() {

    }
    public void swing() {

    }
}
