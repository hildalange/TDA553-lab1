import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class RepairShop implements IPositionable{

    private Contents repairShopContents;

    private double x;
    private double y;
    private int maximumCars;
    private String modelName;
    private Color color;

    public RepairShop(double x, double y, String modelName, Color color){
        this.x = x;
        this.y = y;
        this.maximumCars = 2;
        this.modelName = modelName;
        this.color = color;
        this.repairShopContents = new Contents(this);
    }

    public ArrayList<Car> getList() {
        return repairShopContents.getList();
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

    public int getMaximumOfCars() {
        return this.maximumCars;
    }

    public Car checkDistanceToLoadCar(Car car) {
        double distanceOfX = this.x - car.getX();
        double distanceOfY = this.y - car.getY();
        
        return repairShopContents.checkDistanceToLoadCar(car, distanceOfX, distanceOfY);
    }

    public void loadingCar(Car car) {
        Car carToLoad = checkDistanceToLoadCar(car);

        if (carToLoad == car && this.getList().size() < this.maximumCars){
            repairShopContents.loadingCar(carToLoad);
            }
    }

    public void removingCar() {
        if (repairShopContents.hasCars()){
            Car removed_car = repairShopContents.removingCar();
            repairShopContents.removedCarShouldEndUp(removed_car);
        }
    }
    
    public Integer randomNumber(Integer carsInList){
        Random rand = new Random();
        int upperboard = carsInList;
        int randomInt = rand.nextInt(upperboard);
        return randomInt;
    }
}
