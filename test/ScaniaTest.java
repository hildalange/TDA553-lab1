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
        for (int i = 1; i <= 7; i++ ){
            car.raisePlatform();
        }
        car.raisePlatform();
        assertEquals(70, car.getPlatformAngle());   
    }

    @Test
    public void platformAngle_should_increase_by_10(){
        Scania car = new Scania();
        car.raisePlatform();
        assertEquals(10, car.getPlatformAngle());
    }

    @Test
    public void platform_should_not_lower_when_0_degrees(){
        Scania car = new Scania();
        car.lowerPlatform();
        assertEquals(0, car.getPlatformAngle());
    }

    @Test
    public void platformAngel_should_decrease_by_10(){
        Scania car = new Scania();
        for (int i = 1; i <= 4; i++ ){
            car.raisePlatform();
        }
        car.lowerPlatform();
        assertEquals(30, car.getPlatformAngle());
    }

    @Test
    public void platform_should_not_raise_or_low_when_car_is_moving(){
        Scania car = new Scania();
        car.gas(10);
        car.raisePlatform();
        assertEquals(0, car.getPlatformAngle());
    }

    @Test
    public void if_platform_is_raised_car_should_not_move(){
        Scania car = new Scania();
        for (int i = 1; i <= 2; i++ ){
            car.raisePlatform();
        }
        car.gas(10);
        assertEquals(0, car.getCurrentSpeed());
    }

    @Test
    public void current_speed_should_increase_when_calling_gas(){
        Scania car = new Scania();
        car.gas(10);
        assertEquals(10, car.getCurrentSpeed());
    }

    @Test
    public void should_not_be_able_to_brake_when_ramp_is_up(){
        Scania car = new Scania();
        car.raisePlatform();
        car.brake(10);
        assertEquals(0, car.getCurrentSpeed());
    }

    @Test
    public void car_should_turn_left(){
        Scania car = new Scania();
        car.turnLeft();
        car.gas(10);
        car.move();
        assertEquals(-10, car.getX());
    }

    @Test
    public void car_should_turn_right(){
        Scania car = new Scania();
        car.turnRight();
        car.gas(10);
        car.move();
        assertEquals(10, car.getX());
    }
}


