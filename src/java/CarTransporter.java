import java.awt.*;
import java.util.ArrayList;

public class CarTransporter extends Truck{

    private Contents carTransporterContents;

    public CarTransporter(){
        super("CarTransporter", 2, 0, 125, Color.blue, 0, 0);
        this.carTransporterContents = new Contents(this);
    }

    public ArrayList<Car> getList() {
        return carTransporterContents.getList();
    }


    public void flatbedDown(){
        if (this.getCurrentSpeed() == 0 && this.platformAngle == 0){
            setPlatformAngle(70);
        }
    }

    public void raiseflatbed(){
        if (this.getCurrentSpeed() == 0 && this.platformAngle == 70){
            setPlatformAngle(0);
        }
    }

    public boolean AcceptabletoLoadCar(){
        boolean okToLoad = false;
        if (this.getCurrentSpeed() == 0 && this.platformAngle == 70){
            okToLoad = true;
        } 

        return okToLoad;
    }

    public int getNumberOfCars() {
        return carTransporterContents.getList().size();
    }

    public Car checkDistanceToLoadCar(Car car){
        double distanceOfX = this.getX() - car.getX();
        double distanceOfY = this.getY() - car.getY();

        return this.carTransporterContents.checkDistanceToLoadCar(car, distanceOfX, distanceOfY);
    }
      

    public void loadingCar(Car car) {
        Car carToLoad = checkDistanceToLoadCar(car);

        if (carToLoad == car && AcceptabletoLoadCar() == true){
            if (this.getNumberOfCars() < 2){
        carTransporterContents.loadingCar(carToLoad);
        }
    }}

    public void removingCar(){
        if (carTransporterContents.hasCars()){
            Car removedCar = carTransporterContents.removingCar();
            carTransporterContents.removedCarShouldEndUp(removedCar);
        }
    }
}
