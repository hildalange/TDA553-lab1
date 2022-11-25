import java.awt.*;
 
public abstract class Cars extends Vehicle{
 
    public Cars(String modelName, int nrDoors, double currentSpeed, double enginePower, Color color, double x, double y){
        super( modelName, nrDoors, currentSpeed, enginePower, color, x, y);
    }

    public void brake(double amount){
        if (amount >= 0 && amount <= 1){
            decrementSpeed(amount);
        }
    }

    public void gas(double amount){
        if (amount >= 0 && amount <= 1){
            incrementSpeed(amount);
        }
    }

    public abstract double speedFactor();

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
}