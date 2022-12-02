import java.awt.*;
 
public abstract class Car extends Vehicle{
 
    public Car(String modelName, int nrDoors, double currentSpeed, double enginePower, Color color, double x, double y){
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
        double newSpeed = getCurrentSpeed() + speedFactor() * amount;
        setCurrentSpeed(newSpeed);
        if (getCurrentSpeed() < 0){
            setCurrentSpeed(0);
        } else if (getCurrentSpeed() > getEnginePower()){
            newSpeed = getEnginePower();
            setCurrentSpeed(newSpeed);
        }
    }

    private void decrementSpeed(double amount){
        double newSpeed = getCurrentSpeed() - speedFactor() * amount;
        setCurrentSpeed(newSpeed);

        if (getCurrentSpeed() < 0){
            setCurrentSpeed(0);
        } else if (getCurrentSpeed() > getEnginePower()){
            newSpeed = getEnginePower();
            setCurrentSpeed(newSpeed);
        }
    }
}