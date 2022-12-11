import java.awt.*;
import java.util.ArrayList;

public class CarTransporter extends Truck{

    private Contents carTransporterContents;
    private CarTransportFlatbed ctFlatbed;

    public CarTransporter(){
        super("CarTransporter", 2, 0, 125, Color.blue, 0, 0);
        this.carTransporterContents = new Contents(this);
        this.ctFlatbed = new CarTransportFlatbed();
    }

    public double getFlatbedAngle(){
        return ctFlatbed.getPlatformAngle();
    }

    public ArrayList<Car> getList() {
        return carTransporterContents.getList();
    }

    public void flatbedDown(){
        if (this.getCurrentSpeed() == 0 && ctFlatbed.getPlatformAngle() == 0){
            ctFlatbed.lower();
        }
    }

    public void flatbedUp(){
        if (this.getCurrentSpeed() == 0 && ctFlatbed.getPlatformAngle() == 70){
            ctFlatbed.raise();
        }
    }

    public boolean AcceptabletoLoadCar(){
        boolean okToLoad = false;
        if (this.getCurrentSpeed() == 0 && ctFlatbed.getPlatformAngle() == 70){
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

    @Override
    public boolean isGasValid(double amount) {
        if(amount >= 0 && amount <= 1 && ctFlatbed.canMove() == true) {
            return true;
        } else {
            return false;
        }
    }
}
