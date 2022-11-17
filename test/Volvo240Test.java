import org.junit.Test;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Volvo240Test {
    @Test
    public void car_should_have_engine_power_one_hundred() {
        Volvo240 car = new Volvo240();
        assertEquals(100, car.getEnginePower());
    }
 
    @Test
    public void car_should_have_the_right_speedFactor() {
        Volvo240 car = new Volvo240();
        assertEquals(1.25, car.speedFactor());
    }

    @Test
    public void car_should_have_a_new_colour() {
        Volvo240 car = new Volvo240();
        car.setColor(Color.red);;
        assertEquals(Color.red, car.getColor());
    }

    @Test
    public void car_should_change_coordinates() {
        Volvo240 car = new Volvo240();
        car.setX(7.0);
        assertEquals(7.0, car.getX());
    }
    
    @Test
    public void currentSpeed_should_increase_to_the_least_value(){
        Volvo240 car = new Volvo240();
        car.gas(1.0);
        assertEquals(1.25, car.currentSpeed);
    }

    @Test
    public void currentSpeed_should_decrease_to_the_greatest_value(){
        Volvo240 car = new Volvo240();
        car.setCurrentSpeed(2.0);
        car.brake(1.0);
        assertEquals(0.75, car.currentSpeed);

    }
}
