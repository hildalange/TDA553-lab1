import java.awt.*;

public class Volvo240 extends Cars{

    public final static double trimFactor = 1.25;
    
    
    public Volvo240(){
        super("Volvo240", 4, 0, 100, Color.BLACK, x, y);
        stopEngine();
    }
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

    private void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower());
        if (currentSpeed < 0){
            currentSpeed = 0;
        } else if (currentSpeed > getEnginePower()){
            currentSpeed = getEnginePower();
        }
    }

    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
        if (currentSpeed < 0){
            currentSpeed = 0;
        } else if (currentSpeed > getEnginePower()){
            currentSpeed = getEnginePower();
        }
    }

    public void gas(double amount){
        if (amount >= 0 && amount <= 1){
            incrementSpeed(amount);
        }
    }

    public void brake(double amount){
        if (amount >= 0 && amount <= 1){
            decrementSpeed(amount);
        }
    }
}

