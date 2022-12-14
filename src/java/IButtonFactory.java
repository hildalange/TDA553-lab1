import java.util.ArrayList;

import javax.swing.JButton;

public interface IButtonFactory {
    JButton getButton(ArrayList list, int i);
    ArrayList createButtons();
    int getNumber();
    JButton createTheButton(String name);

}
