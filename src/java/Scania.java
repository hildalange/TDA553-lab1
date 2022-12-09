import java.awt.*;;

public class Scania extends Vehicle {

    private double platformAngle;
    public int amount;

    public Scania() {
        super("Scania", 2, 0, 125, Color.yellow, 0, 0);
        platformAngle = 0;
    }

    public void raisePlatform() {
        if (getCurrentSpeed() == 0){

            if (platformAngle < 70){
                platformAngle += 10;
            } else if (platformAngle >= 70){
                platformAngle = 70;
            }
        }
    }

    public void lowerPlatform () {
        if (getCurrentSpeed() == 0){

            if (platformAngle <= 0){
                platformAngle = 0;
    
            } else if (platformAngle <= 70){
                platformAngle -= 10;
            }
        }

    }

    @Override
    public void gas(double amount){
        if (platformAngle > 0){
            changeCurrentSpeed(0);
        } else {
            double newSpeed = getCurrentSpeed() + amount;
            changeCurrentSpeed(newSpeed);
        }
    }

    @Override
    public void brake(double amount){
        if (platformAngle > 0){
          changeCurrentSpeed(0);
        } else {
            double newSpeed = getCurrentSpeed() - amount;
            changeCurrentSpeed(newSpeed);
        }
    }

    public double getPlatformAngle(){
        return this.platformAngle;
    }

}
