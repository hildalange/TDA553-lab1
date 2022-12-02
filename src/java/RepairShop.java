import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class RepairShop implements Load{

    private double x;
    private double y;
    private int maximumCars;
    private String modelName;
    private Color color;
    public ArrayList<Car> listOfLoadedCarsInShop = new ArrayList<Car>();

    public RepairShop(double x, double y, int maximumCars, String modelName, Color color){
        this.x = x;
        this.y = y;
        this.maximumCars = maximumCars;
        this.modelName = modelName;
        this.color = color;
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

    @Override
    public Car checkDistanceToLoadCar(Car car) {
        double distanceOfX = this.x - car.getX();
        double distanceOfY = this.y - car.getY();
        Car pickMeUp = null;

        if (distanceOfX < 0){
            distanceOfX = -1 * distanceOfX;
        }
        if (distanceOfY < 0){
            distanceOfY = -1 * distanceOfY;
        }

        if (distanceOfY <= 3 && distanceOfX <= 3 && distanceOfX >= 0 && distanceOfY >= 0){
            pickMeUp = car;
        }
        
        return pickMeUp;
    }

    @Override
    public void removedCarShouldEndUp(Car car) {
        double XCoordinate = this.getX() + 2;
        double YCoordinate = this.getY() + 2;

        car.setX(XCoordinate);
        car.setY(YCoordinate);
    }

    @Override
    public void loadingCar(Car car) {
        Car carToLoad = checkDistanceToLoadCar(car);

        if (carToLoad == car && listOfLoadedCarsInShop.size() < this.maximumCars){
            listOfLoadedCarsInShop.add(carToLoad);
            }
    }

    @Override
    public void removingCar() {
        Car removed_car = null;

        if (listOfLoadedCarsInShop.size() > 0){
            int random_num = randomNumber(listOfLoadedCarsInShop.size());
            removed_car = listOfLoadedCarsInShop.remove(random_num);
            removedCarShouldEndUp(removed_car);
        }
        
    }
    
    public Integer randomNumber(Integer carsInList){
        Random rand = new Random();
        int upperboard = carsInList;
        int randomInt = rand.nextInt(upperboard);
        return randomInt;
    }
    
    

}
