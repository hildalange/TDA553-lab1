import java.awt.*;

public class Cars implements Movable{
    private final int nrDoors;
    private String modelName;
    protected double currentSpeed;
    private double enginePower;
    private Color color;
    public String directions;
    public int x;
    public int y;


    //int x och int y representerar om att bilen skall kunna röra sig i uppåt och nedåt, tex 1 för att åka upp (fram),
    //och tex 0 för att åka ned (bakåt), directions representerar höger elr vänster 
    public Cars(String modelName, int nrDoors, double currentSpeed, double enginePower, Color color, int x, int y, String directions){
        this.modelName = modelName;
        this.nrDoors = nrDoors;
        this.currentSpeed = currentSpeed;
        this.enginePower = enginePower;
        this.color = color;
        this.directions = directions;
        this.x = x;
        this.y = y;
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
        //i Saab och Volvo klassen ska dessa funktioner: move, turnLeft och turnRight override(as)
    }
    public void turnLeft(){
        
    }
    public void turnRight() {
        // TODO Auto-generated method stub
        

    }
}
