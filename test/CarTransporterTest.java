import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class CarTransporterTest {
    @Test
    public void carTransporter_should_have_two_doors(){
        CarTransporter transporter = new CarTransporter();
        assertEquals(2, transporter.getNrDoors());
    }

    @Test
    public void load_car_with_one_car_when_transporter_is_empty(){
        CarTransporter transporter = new CarTransporter();
        Saab95 car = new Saab95();
        car.setX(1);
        car.setY(1);
        transporter.flatbedUp = false;
        transporter.loadingCar(car);
        assertEquals(car, transporter.listOfLoadedCars.get(0));
    }

    @Test
    public void cant_pick_up_a_car_while_transporter_is_full(){
        CarTransporter transporter = new CarTransporter();
        Saab95 carOne = new Saab95();
        Volvo240 carTwo = new Volvo240();
        Volvo240 carThree = new Volvo240();
        transporter.flatbedUp = false;
        transporter.loadingCar(carOne);
        transporter.loadingCar(carTwo);
        transporter.loadingCar(carThree);
        assertEquals(carTwo, transporter.listOfLoadedCars.get(1));
    }

    @Test
    public void unload_a_car_from_CarTransporter(){
        CarTransporter transporter = new CarTransporter();
        Saab95 carOne = new Saab95();
        transporter.flatbedUp = false;
        transporter.loadingCar(carOne);
        transporter.removingCar();
        assertEquals(0, transporter.listOfLoadedCars.size());
    }

    @Test
    public void unload_the_last_car_from_CarTransporter(){
        CarTransporter transporter = new CarTransporter();
        Saab95 carOne = new Saab95();
        Volvo240 carTwo = new Volvo240();
        transporter.flatbedUp = false;
        transporter.loadingCar(carOne);
        transporter.loadingCar(carTwo);
        transporter.removingCar();
        assertEquals(carOne, transporter.listOfLoadedCars.get(0));
    }

    @Test
    public void carTransporter_should_not_pick_up_a_car_if_its_to_far_away(){
        CarTransporter transporter = new CarTransporter();
        Saab95 carOne = new Saab95();
        transporter.flatbedUp = false;
        carOne.x = 10;
        carOne.y = 10;
        transporter.loadingCar(carOne);
        assertEquals(0, transporter.listOfLoadedCars.size());
    }

    @Test
    public void car_should_get_the_right_Xcoordinate_when_unloaded(){
        CarTransporter transporter = new CarTransporter();
        Saab95 carOne = new Saab95();
        transporter.flatbedUp = false;
        transporter.loadingCar(carOne);
        transporter.removingCar();
        assertEquals(2, carOne.getX());
    }

    @Test
    public void carTransporter_should_not_be_able_to_lower_flatbed_while_moving(){
        CarTransporter transporter = new CarTransporter();
        transporter.currentSpeed = 5;
        transporter.flatbedDown();
        assertEquals(true, transporter.flatbedUp);
    }

    @Test
    public void if_flatbed_is_down_car_should_not_move(){
        CarTransporter transporter = new CarTransporter();
        transporter.flatbedDown();
        transporter.gas();
        assertEquals(0, transporter.currentSpeed);
    }

}
