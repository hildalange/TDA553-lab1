import java.awt.*;
import java.util.ArrayList;

public class CarTransporter extends Truck implements Load{
 
    public double carsLoaded;
    public boolean flatbedUp;
    public ArrayList<Cars> listOfLoadedCars = new ArrayList<Cars>();

    public CarTransporter(){
        super("CarTransporter", 2, 0, 125, Color.blue, 0, 0);
        carsLoaded = 0;
        flatbedUp = true;
    }

    public boolean flatbedDown(){
        if (currentSpeed == 0){
            flatbedUp = false;
        }
        return flatbedUp;
    }

    @Override
    public Cars checkDistanceToLoadCar(Cars car){
        double distanceOfX = this.x - car.getX();
        double distanceOfY = this.y - car.getY();
        Cars pickMeUp = null;

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
    public void removedCarShouldEndUp(Cars car){
        car.x = this.x + 2;
        car.y = this.y + 2;
    } 

    @Override
    public void loadingCar(Cars car) {
        Cars carToLoad = checkDistanceToLoadCar(car);

        if (carToLoad == car && flatbedDown() == false){
            if (listOfLoadedCars.size() < 2){
                listOfLoadedCars.add(car);
            }
        }
    }

    @Override
    public void removingCar(){
        Cars removed_car = null;

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
            currentSpeed = 0;
        } else {
            currentSpeed += 10;
        }
    }

    @Override
    public void brake(){
        if (flatbedUp == false){
            currentSpeed = 0;
        } else {
            currentSpeed -= 10;
        }
    }

}
