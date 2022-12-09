import java.util.ArrayList;

public class Contents {

    private ArrayList<Car> listOfLoadedCars = new ArrayList<Car>();

    public ArrayList<Car> getList(){
        return listOfLoadedCars;
    }

    public void loadingCar(Car car) {
        listOfLoadedCars.add(car);
    }

    public void removingCar(Car car){
        Car removed_car = null;

        if (listOfLoadedCars.size() == 2){
            removed_car = listOfLoadedCars.remove(1);
            removedCarShouldEndUp(removed_car);

        } else {

            removed_car = listOfLoadedCars.remove(0);
            removedCarShouldEndUp(removed_car);
        }   
        
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
