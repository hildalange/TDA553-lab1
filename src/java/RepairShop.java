import java.awt.*;

public class RepairShop implements Load{

    private double x;
    private double y;
    private int maximumCars;
    private String modelName;
    private Color color;

    public RepairShop(double x, double y, int maximumCars, String modelName, Color color){
        this.x = x;
        this.y = y;
        this.maximumCars = maximumCars;
        this.modelName = modelName;
        this.color = color;
    }

    @Override
    public Cars checkDistanceToLoadCar(Cars car) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void removedCarShouldEndUp(Cars car) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void loadingCar(Cars car) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void removingCar() {
        // TODO Auto-generated method stub
        
    }
    
    

}
