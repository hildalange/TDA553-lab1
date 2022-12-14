import java.util.ArrayList;
import java.util.Collections;
import java.lang.Cloneable;

public class Contents implements Cloneable {
    private static int MAX_CARS = 2;
    private ArrayList<Car> listOfLoadedCars = new ArrayList<Car>();
    private ArrayList<Car> carsListClone = new ArrayList<Car>(); 
    private IPositionable position;

    public Contents(IPositionable p){
        this.listOfLoadedCars = new ArrayList<Car>();
        this.position = p;
    }

    public boolean hasCars(){
        return !listOfLoadedCars.isEmpty();
    }

    public ArrayList<Car> getList(){
        return carsListClone;
    }

    public void copyList(){
        Collections.copy(listOfLoadedCars, carsListClone);
    }


    public void loadingCar(Car car) {
        if (listOfLoadedCars.size() < MAX_CARS) {
            listOfLoadedCars.add(car);
            car.setX(position.getX());
            car.setY(position.getY());
        }
        
    }

    public Car removingCar(){
        if (!listOfLoadedCars.isEmpty()){
            return listOfLoadedCars.remove(listOfLoadedCars.size()-1);

        }
        return null;
    }

    public void removedCarShouldEndUp(Car car){
        double XCoordinate = car.getX() + 2;
        double YCoordinate = car.getY() + 2;

        car.setX(XCoordinate);
        car.setY(YCoordinate);
    }

    public Car checkDistanceToLoadCar(Car car, double distanceOfX, double distanceOfY){
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


} 
