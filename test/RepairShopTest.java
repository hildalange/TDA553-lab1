import java.awt.Color;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

public class RepairShopTest {
   
    @Test
    public void repairShop_should_have_max_five_cars(){
        RepairShop shop = new RepairShop(0, 0, "Shop", Color.red);
        assertEquals(2, shop.getMaximumOfCars());
    }

    @Test
    public void loadShopWithTwoCars() {
        RepairShop shop = new RepairShop(0, 0, "Shop", Color.red);
        Saab95 carOne = new Saab95();
        Volvo240 carTwo = new Volvo240();
        shop.loadingCar(carOne);
        shop.loadingCar(carTwo);
        assertEquals(2, shop.getList().size());
    }
    
    @Test
    public void remove_one_car_from_shop() {
        RepairShop shop = new RepairShop(0, 0, "Shop", Color.red);
        Saab95 carOne = new Saab95();
        Volvo240 carTwo = new Volvo240();
        shop.loadingCar(carOne);
        shop.loadingCar(carTwo);
        shop.getList();
        shop.removingCar();
        assertEquals(1, shop.getList().size());
    }

    @Test
    public void car_should_get_the_right_Ycoordinate(){
        RepairShop shop = new RepairShop(0, 0, "Shop", Color.red);
        Saab95 carOne = new Saab95();
        shop.loadingCar(carOne);
        shop.removingCar();
        assertEquals(2, carOne.getY());

    }

    @Test
    public void carShop_could_not_load_more_cars_than_maximum(){
        RepairShop shop = new RepairShop(0, 0, "Shop", Color.red);
        Saab95 carOne = new Saab95();
        Volvo240 carTwo = new Volvo240();
        Saab95 carThree = new Saab95();
        shop.loadingCar(carOne);
        shop.loadingCar(carTwo);
        shop.loadingCar(carThree);
        assertEquals(2, shop.getList().size());
        assertEquals(carTwo, shop.getList().get(1));
    }

    @Test
    public void if_carShop_unload_randomCar_a_new_can_be_load() {
        RepairShop shop = new RepairShop(0, 0, "Shop", Color.red);
        Saab95 carOne = new Saab95();
        Volvo240 carTwo = new Volvo240();
        Volvo240 carThree = new Volvo240();
        Saab95 carFour = new Saab95();
        shop.loadingCar(carOne);
        shop.loadingCar(carTwo);
        shop.loadingCar(carThree);
        shop.removingCar();
        shop.loadingCar(carFour);
        assertEquals(true, shop.getList().contains(carFour));
    }
    /* 
    @Test
    public void same(){
        RepairShop shop = new RepairShop(0, 0, 2, "Shop", Color.red);
        CarTransporter transporter = new CarTransporter();
        Volvo240 carThree = new Volvo240();
        Saab95 carFour = new Saab95();
        transporter.flatbedDown();
        shop.loadingCar(carThree);
        transporter.loadingCar(carFour);

        assertEquals(1, shop.getList().size());
        assertEquals(1, transporter.getNumberOfCars());
    }*/
}
