import java.awt.Color;

public abstract class Truck extends Vehicle {

    public Truck(String modelName, int nrDoors, double currentSpeed, double enginePower, Color color, double x, double y) {
        super(modelName, nrDoors, currentSpeed, enginePower, color, x, y);
    }

    abstract boolean isGasValid(double amount);

    @Override
    public double speedFactor(){
        return 1;
    }

    @Override
    public void gas(double amount){
        if (isGasValid(amount) == true)
            super.gas(amount);
        }

    @Override
    public void brake(double amount){
        if (isGasValid(amount) == true){
            super.brake(amount);
        }
    }
}
