import java.awt.*;

public abstract class Vehicle implements Movable, IPositionable{
    
    private final int nrDoors;
    private String modelName;
    private double currentSpeed;
    private double enginePower;
    private Color color;
    private double x;
    private double y; 
    private double[]direction = new double[]{x,y};
    private int currentdirection = 0;
 
    public Vehicle(String modelName, int nrDoors, double currentSpeed, double enginePower, Color color, double x, double y){
        this.modelName = modelName;
        this.nrDoors = nrDoors;
        this.currentSpeed = currentSpeed;
        this.enginePower = enginePower;
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public int getNrDoors(){
        return this.nrDoors;
    }
 
    public double getEnginePower(){
        return this.enginePower;
    }
    
    public double getCurrentSpeed(){
        return this.currentSpeed;
    }

    private void setCurrentSpeed(double speed){
        if (getCurrentSpeed() < getEnginePower() && getCurrentSpeed() >= 0){
            this.currentSpeed = speed;
        }
    }

    public void changeCurrentSpeed(double speed){
        setCurrentSpeed(speed);
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
    
    
    @Override
    public double getX() {
        return x;
    }
    
    @Override
    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;

    }
 
    public void setY(double y) {
        this.y = y;
    }
 
    @Override
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
    
    @Override
    public void turnLeft(){
        currentdirection --;
        if (currentdirection == -1){
            currentdirection = 3;
        }
    }
    
    @Override
    public void turnRight() {
        currentdirection ++;
        if (currentdirection % 4 == 0){
            currentdirection = 0;
        }
    }

    public String getName() {
        return this.modelName;
    }
/* 
    public boolean isGasValid(double amount){
        
        if (amount >= 0 && amount <= 1){
            return true;
        } else {
            return false;
        }
   }*/

    abstract boolean isGasValid(double amount);

    public void gas(double amount){
    
        if (isGasValid(amount) == true){
           incrementSpeed(amount);
        }
   }

    private void incrementSpeed(double amount){
    double newSpeed = getCurrentSpeed() + speedFactor() * amount;
    changeCurrentSpeed(newSpeed);
    if (getCurrentSpeed() < 0){
        changeCurrentSpeed(0);
    } else if (getCurrentSpeed() > getEnginePower()){
        newSpeed = getEnginePower();
        changeCurrentSpeed(newSpeed);
    }
    }

    private void decrementSpeed(double amount){
        double newSpeed = getCurrentSpeed() - speedFactor() * amount;
        changeCurrentSpeed(newSpeed);

        if (getCurrentSpeed() < 0){
            changeCurrentSpeed(0);
        } else if (getCurrentSpeed() > getEnginePower()){
            newSpeed = getEnginePower();
            changeCurrentSpeed(newSpeed);
        }
    }

    public void brake(double amount){
        if (isGasValid(amount) == true){
            decrementSpeed(amount);
        }
    }

    public abstract double speedFactor();

    
}
