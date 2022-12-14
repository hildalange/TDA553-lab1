import org.junit.Test;import static org.junit.jupiter.api.Assertions.assertEquals;

public class ButtonFactoryTest {
    
    @Test
    public void createButtons(){
        ButtonFactory factory = new ButtonFactory();
        factory.createTheButtons();
        assertEquals(5, factory.buttons.size());
    }

}
