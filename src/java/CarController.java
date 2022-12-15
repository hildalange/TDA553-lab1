import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CarController extends JPanel{
    // member fields:
    private static final int delay = 50;
    private static final int x = 800;
    private static final int y = 800;
    JSpinner gasSpinner = new JSpinner();
    Saab95 Saab95 = new Saab95();
    Volvo240 Volvo240 = new Volvo240();
    Scania Scania = new Scania();
    ControllButtonFactory button;
    StartStopButtonFactory labelbutton;
    JPanel gasPanel = new JPanel();
    JLabel gasLabel = new JLabel("Amount of gas");
    int gasAmount = 0;
    JPanel controlPanel = new JPanel();
    private static CarModel model;
    private static DrawPanel drawView;


    public CarController(CarModel model){
        this.model = model;
        button = new ControllButtonFactory();
        labelbutton = new StartStopButtonFactory();
        initComponents();
    }

    private void initComponents(){
                SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);
        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2,4));
        for (int i = 0; i < button.getNumber() ; i++){
            JButton currentButton = button.getButton(button.createButtons(), i);
            controlPanel.add(currentButton, i);
        }
        
        controlPanel.setLayout(new GridLayout(2,4));
        for (int i = 0; i < button.getNumber() ; i++){
            JButton currentButton = button.getButton(button.createButtons(), i);
            controlPanel.add(currentButton, i);
        }

        controlPanel.setPreferredSize(new Dimension((x/2)+4, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.white);

        JButton startButton = labelbutton.getButton(labelbutton.createButtons(), 0);
        JButton stopButton = labelbutton.getButton(labelbutton.createButtons(),1);
        JButton gasButton = button.getButton(button.createButtons(), 0);

        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(x/5-15,200));
        this.add(startButton);

        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(x/5-15,200));
        this.add(stopButton);

        gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gas(gasAmount);
            }
        });
    }

    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : model.vehicles ) {
            car.gas(gas);
        }
    }
    
}
