import java.awt.*;;
 
public class Scania extends Truck{
    private ScaniaPlatform sPlatform;
 
    public Scania() {
        super("Scania", 2, 0, 125, Color.yellow, 0, 0);
        this.sPlatform = new ScaniaPlatform();
    }
 
    public double getPlatformAngle(){
        return sPlatform.getPlatformAngle();
    }

    public void raisePlatform() {
        if (getCurrentSpeed() == 0){
            sPlatform.raise();
        }
    }
 
    public void lowerPlatform() {
        if (getCurrentSpeed() == 0){
            sPlatform.lower();
        }
 
    }

    @Override
    public boolean isGasValid(double amount) {
        if(amount >= 0 && amount <= 1 && sPlatform.canMove() == true) {
            return true;
        } else {
            return false;
        }
    }
}