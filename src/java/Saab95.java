import java.awt.*;

public class Saab95 extends Cars{

    public boolean turboOn;
    
    public Saab95(){
        super("Saab95", 2, 0, 125, Color.red, x, y);
	    turboOn = false;
        stopEngine();
    }

    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }
    
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

    private void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
        if (currentSpeed < 0){
            currentSpeed = 0;
        } else if (currentSpeed > getEnginePower()){
            currentSpeed = getEnginePower();
        }
    }

    private void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
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
