import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;


public class CarApp {

    private static final int delay = 50;
    private static Timer timer = new Timer(delay, new TimerListener());
    private static CarModel carModel;
    private static DrawPanel drawView;


    public static void main(String[] args) {
        // Instance of this class
        carModel = new CarModel();
        carModel.addCars(new Saab95());
        carModel.addCars(new Volvo240());
        carModel.addCars(new Scania());
        drawView =  new DrawPanel(800, 800-240, carModel);
        CarController cc = new CarController(carModel);
        ProgramWindow window = new ProgramWindow("CarSim 1.1", drawView, cc);

        timer.start();
    }

    private static class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle car : carModel.vehicles) {
                car.move();
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());
                int i = (int) carModel.vehicles.indexOf(car);
                drawView.moveit( x, y, i);

            }
            drawView.repaint();
        }
    }
}
