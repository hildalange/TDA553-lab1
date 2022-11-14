import java.awt.*;

public class Cars implements Movable{
    private final int nrDoors;
    private String modelName;
    protected double currentSpeed;
    private double enginePower;
    private Color color;
    private double x;
    private double y;
    private double[]direction = new double[]{x,y};
    private int currentDirection = 0;

    /*public enum Direction {
        NORTH,
        EAST,
        SOUTH,
        WEST;
    }
    private Direction currentDirection;*/
    

    public Cars(String modelName, int nrDoors, double currentSpeed, double enginePower, Color color, double x, double y){
        this.modelName = modelName;
        this.nrDoors = nrDoors;
        this.currentSpeed = currentSpeed;
        this.enginePower = enginePower;
        this.color = color;
        this.x = 0;
        this.y = 0;
        //this.currentDirection = Direction.NORTH;
    }

    public int getNrDoors(){
        return this.nrDoors;
    }

    public double getEnginePower(){
        return this.enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public void setCurrentSpeed(double speed){
        currentSpeed = speed;
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

/* switch (this.currentDirection) {
            case NORTH: {
                y += currentSpeed;
            }
            case EAST: {
                x += currentSpeed;
            }
            case SOUTH: {
                y -= currentSpeed;
            }
            case WEST: 
            default: {
                x -= currentSpeed;
            }
*/     
        switch (currentDirection){
            case 0: {
                this.y -= currentSpeed;
                direction[1] = this.y;
                break;
            }
            case 1: {
                this.x += currentSpeed;
                direction[0] = this.x;
                break;
            }
            case 2: {
                this.y += currentSpeed;
                direction[1] = this.y;
                break;
            }
            case 3: {
                this.x -= currentSpeed;
                direction[0] = this.x;
                break;
            }
            default: {
                break;
            }
        }
    }
    
    public void turnLeft(){
        currentDirection --;
        if (currentDirection == -1){
            currentDirection = 3;
        }
    }

    public void turnRight() {
        currentDirection ++;
        if (currentDirection % 4 == 0){
            currentDirection = 0;
        }
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
    
}
