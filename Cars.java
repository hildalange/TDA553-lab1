import java.awt.*;
 
public class Cars implements Movable{
    private final int nrDoors;
    private String modelName;
    protected double currentSpeed;
    private double enginePower;
    private Color color;
<<<<<<< Updated upstream

    public Cars(String modelName, int nrDoors, double currentSpeed, double enginePower, Color color){
=======
    private double x;
    private double y;
    private double[]direction = new double[]{x,y};
    private int currentdirection = 0;
    
 
 
    public Cars(String modelName, int nrDoors, double currentSpeed, double enginePower, Color color, double x, double y){
>>>>>>> Stashed changes
        this.modelName = modelName;
        this.nrDoors = nrDoors;
        this.currentSpeed = currentSpeed;
        this.enginePower = enginePower;
        this.color = color;
        this.x = 0;
        this.y = 0;

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
        switch (currentdirection) {
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
                y += currentSpeed;
                direction[1] =this.y;
                break;
            }
            case 3: {
                x -= currentSpeed;
                direction[0]= this.x;
                break;
            }
            default:
            break;
        }
    }
 
    public void turnLeft(){
        currentdirection --;
        if (currentdirection == -1){
            currentdirection = 3;
        }
    }
<<<<<<< Updated upstream
   @Override
    public void turnRight() {
        // TODO Auto-generated method stub
        

=======
 
    public void turnRight() {
        currentdirection ++;
        if (currentdirection % 4 == 0){
            currentdirection = 0;
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
>>>>>>> Stashed changes
    }
 
}