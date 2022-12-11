import java.util.ArrayList;

public class Contents {
    private static int MAX_CARS = 2;
    private ArrayList<Car> listOfLoadedCars = new ArrayList<Car>();
    private IPositionable position;

    public Contents(IPositionable p){
        this.listOfLoadedCars = new ArrayList<Car>();
        this.position = p;
    }

    public boolean hasCars(){
        return !listOfLoadedCars.isEmpty();
    }

    public ArrayList<Car> getList(){
        return this.listOfLoadedCars;
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

    public void moveCarYcoordinate(double y){
        ArrayList<Car> carsInList = getList();
        if (carsInList.size() == 1){
            Car car = carsInList.get(0);
            car.setY(y);
        } else if (carsInList.size() == 2){
            Car firstCar = carsInList.get(0);
            firstCar.setY(y);
            Car secondCar = carsInList.get(1);
            secondCar.setY(y);
        }
    }

    public void moveCarXcoordinate(double x){
    ArrayList<Car> carsInList = getList();
    if (carsInList.size() == 1){
        Car car = carsInList.get(0);
        car.setY(x);
    } else if (carsInList.size() == 2){
        Car firstCar = carsInList.get(0);
        firstCar.setY(x);
        Car secondCar = carsInList.get(1);
        secondCar.setY(x);
    }
    }

} 
