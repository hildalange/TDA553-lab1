import java.awt.*;

public class Volvo240 extends Cars{

    public final static double trimFactor = 1.25;
    
    
    public Volvo240(){
        super("Volvo240", 4, 0, 100, Color.BLACK);
        stopEngine();
    }
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

    private void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower());
    }

    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }
}
