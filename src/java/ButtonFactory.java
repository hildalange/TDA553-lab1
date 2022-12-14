import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JButton;


public class ButtonFactory {
 
    ArrayList<String> namesOfButtons = (ArrayList<String>) Arrays.asList("Gas", "Brake", "TurboOn", "TurboOff", "ScaniaLiftBed", "LowerLiftBed");
    ArrayList<String> nameOfLabels = (ArrayList <String>) Arrays.asList("StartAllCars", "StopAllCars");
    ArrayList<JButton> buttons = new ArrayList<>();
    ArrayList<JButton> labelbuttons = new ArrayList<>();

    JButton CreateButton(String name){
        return new JButton(name);
    }

    public ArrayList createTheButtons(){
       
        for (int i=0; i < namesOfButtons.size(); i++){
            String name = namesOfButtons.get(i);
            JButton buttonWithName = CreateButton(name);
            buttons.add(buttonWithName);
        }
       
        return buttons;
    }

    public JButton getButton(ArrayList list, int i){
        return buttons.get(i);
    }

    public ArrayList createtheLabels(){

        for (int i=0; i < nameOfLabels.size(); i ++){
            String name = nameOfLabels.get(i);
            JButton buttonWithName = CreateButton(name);
            labelbuttons.add(buttonWithName);
        }

        return labelbuttons;
    }

    public JButton getLabelButton(ArrayList list, int i){
        return labelbuttons.get(i);
    }




}
