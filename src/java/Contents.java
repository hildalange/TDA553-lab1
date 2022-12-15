import java.util.ArrayList;
import java.util.List;

public class Contents {
    private static int MAX_CARS = 2;
    private List<Car> listOfLoadedCars = new ArrayList<>();
    private IPositionable position;

    public Contents(IPositionable p){
        this.listOfLoadedCars = new ArrayList<Car>();
        this.position = p;
    }

    public static <T> List<T> defensiveCopy(List<T> listOfLoadedCars) {
        return listOfLoadedCars != null && listOfLoadedCars.size() > 0 ? new ArrayList<>(listOfLoadedCars)
                : new ArrayList<>();
    }

    public boolean hasCars(){
        return !listOfLoadedCars.isEmpty();
    }

    public ArrayList<Car> getList(){
        return (ArrayList<Car>) defensiveCopy(listOfLoadedCars);
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
   
    @Override
    public Car clone() {
        Car clonedCarTransporter = null;
        try {
            clonedCarTransporter = (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
 
        return clonedCarTransporter;
    }
} 
