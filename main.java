import manual_functions.robot

@TeleOp()
public class main extends OpMode {
    private robot obj;
    
    @Override
    public void init() {
        obj.initialize()
    }
    @Override
    public void loop() {
        obj.check_inputs;
    }
}
