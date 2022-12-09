import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class RepairShop{

    Contents content = new Contents();

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

    public ArrayList<Car> getList() {
        return content.getList();
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
    }

    public int getMaximumOfCars() {
        return this.maximumCars;
    }

    public Car checkDistanceToLoadCar(Car car) {
        double distanceOfX = this.x - car.getX();
        double distanceOfY = this.y - car.getY();
        
        return this.content.checkDistanceToLoadCar(car, distanceOfX, distanceOfY);
    }

    public void loadingCar(Car car) {
        Car carToLoad = checkDistanceToLoadCar(car);

        if (carToLoad == car && this.getList().size() < this.maximumCars){
            this.content.loadingCar(carToLoad);
            }
    }

    public void removingCar() {
        Car removed_car = null;

        if (getList().size() > 0){
            int random_num = randomNumber(getList().size());
            removed_car = getList().remove(random_num);
            this.content.removedCarShouldEndUp(removed_car);
        }
        
    }
    
    public Integer randomNumber(Integer carsInList){
        Random rand = new Random();
        int upperboard = carsInList;
        int randomInt = rand.nextInt(upperboard);
        return randomInt;
    }
    
    

}
