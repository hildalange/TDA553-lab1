import java.awt.*;;

public class Scania extends Truck {

    public double platformAngle;

    public Scania() {
        super("Scania", 2, 0, 125, Color.yellow, 0, 0);
        platformAngle = 0;
    }

    public void raisePlatform() {
        if (currentSpeed == 0){

            if (platformAngle < 70){
                platformAngle += 10;
            } else if (platformAngle >= 70){
                platformAngle = 70;
            }
        }
    }

    public void lowerPlatform () {
        if (currentSpeed == 0){

            if (platformAngle <= 0){
                platformAngle = 0;
    
            } else if (platformAngle <= 70){
                platformAngle -= 10;
            }
        }

    }

    @Override
    public void gas(){
        if (platformAngle > 0){
            currentSpeed = 0;
        } else {
            currentSpeed += 10;
        }
    }

    @Override
    public void brake(){
        if (platformAngle > 0){
            currentSpeed = 0;
        } else {
            currentSpeed -= 10;
        }
    }

}
