import java.awt.*;
import java.util.ArrayList;

public class CarTransporter extends Vehicle{

    Contents content = new Contents();
    
    private boolean flatbedUp;

    public CarTransporter(){
        super("CarTransporter", 2, 0, 125, Color.blue, 0, 0);
        flatbedUp = true;
    }

    public void flatbedDown(){
        if (this.getCurrentSpeed() == 0){
            flatbedUp = false;
        }
    }

    public void raiseflatbed(){
        if (this.getCurrentSpeed() == 0){
            flatbedUp = true;
        }
    }

    public ArrayList<Car> getList() {
        return content.getList();
    }

    public Car checkDistanceToLoadCar(Car car){
        double distanceOfX = this.getX() - car.getX();
        double distanceOfY = this.getY() - car.getY();

        return this.content.checkDistanceToLoadCar(car, distanceOfX, distanceOfY);
    }
      

    public void loadingCar(Car car) {
        Car carToLoad = checkDistanceToLoadCar(car);

        if (carToLoad == car && this.flatbedUp == false){
            if (this.getList().size() < 2){
            content.loadingCar(carToLoad);
        }
    }}

    public void removingCar(){
        Car removed_car = null;

        if (this.flatbedUp == false && getList().size() > 0){
            content.removingCar(removed_car);
        }
    }

    @Override
    public void gas(double amount){
        if (this.flatbedUp == false){
            changeCurrentSpeed(0);
        } else {
            double newSpeed = getCurrentSpeed() + amount;
            changeCurrentSpeed(newSpeed);
        }
    }

    @Override
    public void brake(double amount){
        if (flatbedUp == false){
            changeCurrentSpeed(0);

        } else {
            double newSpeed = getCurrentSpeed() - amount;
            changeCurrentSpeed(newSpeed);
        }
    }

    public boolean getFlatbedUp(){
        return this.flatbedUp;
    }

}
