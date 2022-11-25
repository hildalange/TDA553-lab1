import java.awt.*;

public class Saab95 extends Cars{
    public boolean turboOn;
    
    public Saab95(){
        super("Saab95", 2, 0, 125, Color.red, 0, 0);
	    turboOn = false;
        stopEngine();
    }

    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }
    
    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}
