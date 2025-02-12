import java.awt.*;
 
public abstract class Car extends Vehicle{
 
    public Car(String modelName, int nrDoors, double currentSpeed, double enginePower, Color color, double x, double y){
        super( modelName, nrDoors, currentSpeed, enginePower, color, x, y);
    }

    @Override
    public boolean isGasValid(double amount){
            
        if (amount >= 0 && amount <= 1){
            return true;
        } else {
            return false;
        }
    }

}