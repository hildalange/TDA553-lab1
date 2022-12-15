import java.util.ArrayList;
import java.util.List;

public class CarModel {
    public List<Vehicle> vehicles = new ArrayList<>();

    public void addCars(Vehicle vehicle){
        vehicles.add(vehicle);
    }
}
