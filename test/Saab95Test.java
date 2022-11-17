import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Saab95Test {
    @Test
    public void car_should_have_two_doors() {
        Saab95 car = new Saab95();
        assertEquals(2, car.getNrDoors());
    }
 
    @Test
    public void turbo_should_be_false() {
        Saab95 car = new Saab95();
        assertEquals(false, car.turboOn);
    }
 
    @Test
    public void SetTurboOn_should_change_turboOn_to_true() {
        Saab95 car = new Saab95();
        car.setTurboOn();
        assertEquals(true, car.turboOn);
    }
 
    @Test
    public void SetTurboOff_should_change_turboOn_to_false() {
        Saab95 car = new Saab95();
        car.setTurboOff();
        assertEquals(false, car.turboOn);
    }

    @Test
    public void if_turbo_is_on_speedFactor_should_increase() {
        Saab95 car = new Saab95();
        car.setTurboOn();
        Double currentspeed = car.speedFactor();
        assertEquals(1.625, currentspeed);
    }

    @Test
    public void currentSpeed_should_increase_when_calling_gas_with_value_between_zero_and_one(){
        Saab95 car = new Saab95();
        car.setTurboOn();
        car.gas(0.5);
        assertEquals(0.8125, car.currentSpeed);
    }

    @Test
    public void current_speed_should_not_change_when_value_in_method_gas_is_outside_index(){
        Saab95 car = new Saab95();
        car.setTurboOn();
        car.gas(2);
        assertEquals(0, car.currentSpeed);
    }

    @Test
    public void currentSpeed_should_decrease_when_calling_brake_with_value_between_zero_and_one(){
        Saab95 car = new Saab95();
        car.setCurrentSpeed(10.0);
        car.setTurboOn();
        car.brake(0.5);
        assertEquals(9.1875, car.currentSpeed);
    }

    @Test
    public void currentSpeed_should_not_exceed_its_parameters(){
        Saab95 car = new Saab95();
        car.setTurboOn();
        car.setCurrentSpeed(125);
        car.gas(1.0);
        assertEquals(125, car.currentSpeed);
    }
}
