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
}
