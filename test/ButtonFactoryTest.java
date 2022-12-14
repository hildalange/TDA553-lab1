import org.junit.Test;import static org.junit.jupiter.api.Assertions.assertEquals;

public class ButtonFactoryTest {
    
    @Test
    public void createButtons(){
        IButtonFactory factory = new ControllButtonFactory();
        factory.createButtons();
        assertEquals(6,factory.getList().size());
    }

}
