public class CarTransportFlatbed implements IPlatform {

    protected double platformAngle;

    public CarTransportFlatbed(){
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
       setPlatformAngle(0);
		
	}

	@Override
	public void lower() {
		setPlatformAngle(70);
	}

	@Override
	public boolean canMove() {
		if (this.getPlatformAngle() == 0){
            return true;
        } return false;
		
	}
    
}
