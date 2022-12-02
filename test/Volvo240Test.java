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
    public void currentSpeed_should_increase_when_calling_gas(){
        Volvo240 car = new Volvo240();
        car.gas(1.0);
        assertEquals(1.25, car.getCurrentSpeed());
    }

    @Test
    public void currentSpeed_should_decrease_when_calling_brake(){
        Volvo240 car = new Volvo240();
        car.gas(1);
        car.brake(0.5);
        assertEquals(0.625, car.getCurrentSpeed());

    }

    @Test
    public void car_should_move(){
        Volvo240 car = new Volvo240();
        car.gas(1);
        car.move();
        assertEquals(-1.25, car.getY());
        
    }
}
