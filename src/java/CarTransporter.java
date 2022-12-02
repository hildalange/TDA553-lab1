import java.awt.*;
import java.util.ArrayList;

public class CarTransporter extends Truck implements Load{
    
    private boolean flatbedUp;
    public ArrayList<Car> listOfLoadedCars = new ArrayList<Car>();

    public CarTransporter(){
        super("CarTransporter", 2, 0, 125, Color.blue, 0, 0);
        flatbedUp = true;
    }

    public boolean flatbedDown(){
        if (this.getCurrentSpeed() == 0){
            flatbedUp = false;
        }
        return flatbedUp;
    }

    @Override
    public Car checkDistanceToLoadCar(Car car){
        double distanceOfX = this.getX() - car.getX();
        double distanceOfY = this.getY() - car.getY();
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
    public void removedCarShouldEndUp(Car car){
        double XCoordinate = this.getX() + 2;
        double YCoordinate = this.getY() + 2;

        car.setX(XCoordinate);
        car.setY(YCoordinate);
    } 



    @Override
    public void loadingCar(Car car) {
        Car carToLoad = checkDistanceToLoadCar(car);

        if (carToLoad == car && flatbedDown() == false){
            if (listOfLoadedCars.size() < 2){
                listOfLoadedCars.add(car);
            }
        }
    }

    @Override
    public void removingCar(){
        Car removed_car = null;

        if (flatbedDown() == false && listOfLoadedCars.size() > 0){
            if (listOfLoadedCars.size() == 2){
                removed_car = listOfLoadedCars.remove(1);
                removedCarShouldEndUp(removed_car);
            } else {
                removed_car = listOfLoadedCars.remove(0);
                removedCarShouldEndUp(removed_car);
            }   
        }
    }

    @Override
    public void gas(){
        if (flatbedUp == false){
            setCurrentSpeed(0);
        } else {
            double newSpeed = getCurrentSpeed() + 10;
            setCurrentSpeed(newSpeed);
        }
    }

    @Override
    public void brake(){
        if (flatbedUp == false){
            setCurrentSpeed(0);
        } else {
            double newSpeed = getCurrentSpeed() - 10;
            setCurrentSpeed(newSpeed);
        }
    }

    public boolean getFlatbedUp(){
        return this.flatbedUp;
    }

}
