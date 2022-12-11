public class ScaniaPlatform implements IPlatform {

    protected double platformAngle;

    public ScaniaPlatform(){
        this.platformAngle = 0;
    }
	
    public double getPlatformAngle() {
        return this.platformAngle;
    }

    protected void setPlatformAngle(double platformAngle){
        this.platformAngle = platformAngle;
    }

    @Override
    public void raise() {
        if (this.platformAngle < 70){
            setPlatformAngle(this.platformAngle + 10);
        } else if (platformAngle >= 70){
            setPlatformAngle(70);
        }
    }
    

    @Override
    public void lower() {
        if (this.platformAngle <= 0){
            this.platformAngle = 0;

        } else if (this.platformAngle <= 70){
            this.platformAngle -= 10;
        }
        
    }

    @Override
    public boolean canMove() {
		if (this.platformAngle == 0){
            return true;
        } return false;
		
    }
    
}
