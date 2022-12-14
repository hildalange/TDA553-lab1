import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;

public class ControllButtonFactory implements IButtonFactory {
    ArrayList<String> namesOfButtons = new ArrayList<>(Arrays.asList("Gas", "Brake", "TurboOn", "TurboOff", "ScaniaLiftBed", "LowerLiftBed"));
    ArrayList<JButton> buttons = new ArrayList<JButton>();

    @Override
    public JButton getButton(ArrayList list, int i) {
        return buttons.get(i);
    }

    @Override
    public ArrayList createButtons() {
        
        for (int i=0; i < namesOfButtons.size(); i++){
            String name = namesOfButtons.get(i);
            JButton buttonWithName = createTheButton(name);
            buttons.add(buttonWithName);
        }
       
        return buttons;
    }

    @Override
    public int getNumber() {
        int number = namesOfButtons.size();
        return number;
    }

    @Override
    public JButton createTheButton(String name) {
        return new JButton(name);
    }

    public ArrayList getList(){
        return buttons;
    }
    
}
