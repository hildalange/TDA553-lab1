import java.awt.*;

public abstract class Truck extends Vehicle {
 
    public Truck(String modelName, int nrDoors, double currentSpeed, double enginePower, Color color, double x, double y){
        super( modelName, nrDoors, currentSpeed, enginePower, color, x, y);
    }

    public abstract void gas();
    public abstract void brake();
    
}
