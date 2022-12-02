import java.awt.*;

public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;
    
    
    public Volvo240(){
        super("Volvo240", 4, 0, 100, Color.BLACK, 0, 0);
        stopEngine();
    }
    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}

