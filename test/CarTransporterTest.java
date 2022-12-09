import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class CarTransporterTest {
    @Test
    public void carTransporter_should_have_two_doors(){
        CarTransporter transporter = new CarTransporter();
        assertEquals(2, transporter.getNrDoors());
    }

    @Test
    public void cant_pick_up_a_car_while_transporter_is_full(){
        CarTransporter transporter = new CarTransporter();
        Saab95 carOne = new Saab95();
        Volvo240 carTwo = new Volvo240();
        Volvo240 carThree = new Volvo240();
        transporter.flatbedDown();
        transporter.loadingCar(carOne);
        transporter.loadingCar(carTwo);
        transporter.loadingCar(carThree);
        assertEquals(carTwo, transporter.getList().get(1));
    }

    @Test
    public void unload_the_last_car_from_CarTransporter(){
        CarTransporter transporter = new CarTransporter();
        Saab95 carOne = new Saab95();
        Volvo240 carTwo = new Volvo240();
        transporter.flatbedDown();
        transporter.loadingCar(carOne);
        transporter.loadingCar(carTwo);
        transporter.removingCar();
        assertEquals(carOne, transporter.getList().get(0));
    }

    @Test
    public void carTransporter_should_not_pick_up_a_car_if_its_to_far_away(){
        CarTransporter transporter = new CarTransporter();
        Saab95 carOne = new Saab95();
        transporter.flatbedDown();
        carOne.setX(10);
        carOne.setY(10);
        transporter.loadingCar(carOne);
        assertEquals(0, transporter.getList().size());
    }

    @Test
    public void car_should_get_the_right_Xcoordinate_when_unloaded(){
        CarTransporter transporter = new CarTransporter();
        Saab95 carOne = new Saab95();
        transporter.flatbedDown();
        transporter.loadingCar(carOne);
        transporter.removingCar();
        assertEquals(2, carOne.getX());
    }

    @Test
    public void carTransporter_should_not_be_able_to_lower_flatbed_while_moving(){
        CarTransporter transporter = new CarTransporter();
        transporter.changeCurrentSpeed(5);;
        transporter.flatbedDown();
        assertEquals(true, transporter.getFlatbedUp());
    }

    @Test
    public void if_flatbed_is_down_car_should_not_move(){
        CarTransporter transporter = new CarTransporter();
        transporter.flatbedDown();
        transporter.gas(10);
        assertEquals(0, transporter.getCurrentSpeed());
    }

}
