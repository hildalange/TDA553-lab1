import java.awt.*;

public class Cars implements Movable{
    private final int nrDoors;
    private String modelName;
    private double currentSpeed;
    private double enginePower;
    private Color color;


    public Cars(String modelName, int nrDoors, double currentSpeed, double enginePower, Color color){
        this.modelName = modelName;
        this.nrDoors = nrDoors;
        this.currentSpeed = currentSpeed;
        this.enginePower = enginePower;
        this.color = color;
    }
    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
	    color = clr;
    }

    public void startEngine(){
	    currentSpeed = 0.1;
    }

    public void stopEngine(){
	    currentSpeed = 0;
    }
    public void move(){

    }
    public void turnLeft(){
        
    }
}
