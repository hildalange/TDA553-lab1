import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;

public class StartStopButtonFactory implements IButtonFactory {
    ArrayList<String> nameOfLabels = new ArrayList<>(Arrays.asList("StartAllCars", "StopAllCars"));
    ArrayList<JButton> labelbuttons = new ArrayList<>();

    @Override
    public JButton getButton(ArrayList list, int i) {
        return labelbuttons.get(i);
    }

    @Override
    public ArrayList createButtons() {
      
        for (int i=0; i < nameOfLabels.size(); i++){
            String name = nameOfLabels.get(i);
            JButton buttonWithName = createTheButton(name);
            labelbuttons.add(buttonWithName);
        }
       
        return labelbuttons;
    }

    @Override
    public int getNumber() {
        int number = nameOfLabels.size();
        return number;
    }

    @Override
    public JButton createTheButton(String name) {
        return new JButton(name);
    }
    
}
