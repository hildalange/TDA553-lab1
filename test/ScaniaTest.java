import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class ScaniaTest {
    @Test
    public void scania_should_have_two_doors() {
        Scania car = new Scania();
        assertEquals(2, car.getNrDoors());
    }

    @Test
    public void platform_should_stop_raising_while_70_degrees(){
        Scania car = new Scania();
        car.platformAngle = 70;
        car.raisePlatform();
        assertEquals(70, car.platformAngle);   
    }

    @Test
    public void platformAngle_should_increase_by_10(){
        Scania car = new Scania();
        car.raisePlatform();
        assertEquals(10, car.platformAngle);
    }

    @Test
    public void platform_should_not_lower_when_0_degrees(){
        Scania car = new Scania();
        car.lowerPlatform();
        assertEquals(0, car.platformAngle);
    }

    @Test
    public void platformAngel_should_decrease_by_10(){
        Scania car = new Scania();
        car.platformAngle = 40;
        car.lowerPlatform();
        assertEquals(30, car.platformAngle);
    }

    @Test
    public void platform_should_not_raise_or_low_when_car_is_moving(){
        Scania car = new Scania();
        car.setCurrentSpeed(10);
        car.raisePlatform();
        assertEquals(0, car.platformAngle);
    }

    @Test
    public void if_platform_is_raised_car_should_not_move(){
        Scania car = new Scania();
        car.platformAngle = 20;
        car.gas();
        assertEquals(0, car.currentSpeed);
    }

    @Test
    public void current_speed_should_increase_when_calling_gas(){
        Scania car = new Scania();
        car.gas();
        assertEquals(10, car.currentSpeed);
    }

    @Test
    public void should_not_be_able_to_brake_when_ramp_is_up(){
        Scania car = new Scania();
        car.platformAngle = 10;
        car.brake();
        assertEquals(0, car.currentSpeed);
    }
}


