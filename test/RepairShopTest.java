import java.awt.Color;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

public class RepairShopTest {
   
    @Test
    public void repairShop_should_have_max_five_cars(){
        RepairShop shop = new RepairShop(0, 0, 5, "Shop", Color.red);
        assertEquals(5, shop.getMaximumOfCars());
    }

    @Test
    public void loadShopWithTwoCars() {
        RepairShop shop = new RepairShop(0, 0, 5, "Shop", Color.red);
        Saab95 carOne = new Saab95();
        Volvo240 carTwo = new Volvo240();
        shop.loadingCar(carOne);
        shop.loadingCar(carTwo);
        assertEquals(2, shop.listOfLoadedCarsInShop.size());
    }
    
    @Test
    public void remove_one_car_from_shop() {
        RepairShop shop = new RepairShop(0, 0, 5, "Shop", Color.red);
        Saab95 carOne = new Saab95();
        Volvo240 carTwo = new Volvo240();
        Saab95 carThree = new Saab95();
        shop.loadingCar(carOne);
        shop.loadingCar(carTwo);
        shop.loadingCar(carThree);
        shop.removingCar();
        assertEquals(2, shop.listOfLoadedCarsInShop.size());
    }

    @Test
    public void car_should_get_the_right_Ycoordinate(){
        RepairShop shop = new RepairShop(0, 0, 5, "Shop", Color.red);
        Saab95 carOne = new Saab95();
        shop.loadingCar(carOne);
        shop.removingCar();
        assertEquals(2, carOne.getY());

    }
}
