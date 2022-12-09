import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
 
// This panel represent the animated part of the view with the car images.
 
public class DrawPanel extends JPanel{

    CarController cc;
    ArrayList<Vehicle> cars;
    ArrayList<Point> pointsOfVehicles = new ArrayList<>();
    ArrayList<BufferedImage> imageOfCars = new ArrayList<>();

    
    // Just a single image, TODO: Generalize
    BufferedImage image;

 
    // To keep track of a singel cars position
    //Point volvoPoint = new Point();
    //Point saabPoint = new Point();
    //Point scaniaPoint = new Point();
 
    // TODO: Make this genereal for all cars

    void moveit(int x, int y, int indexOfVehicle){
        Point p = pointsOfVehicles.get(indexOfVehicle);
        p.x = x;
        p.y = y + (indexOfVehicle * 100);
    }


 
    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, ArrayList<Vehicle> cars) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.white);

        for (Vehicle car: cars){
            Point p = new Point((int) car.getX(),(int) car.getY());
            pointsOfVehicles.add(p);
            try {

                imageOfCars.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/"+ car.getName() +".jpg")));

            } catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
 
    }
 
    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
 

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for ( BufferedImage pic: imageOfCars ){
            Point p = pointsOfVehicles.get(imageOfCars.indexOf(pic));
            g.drawImage( pic , (int) p.x , (int) p.y, null);
        }

         // see javadoc for more info on the parameters
    }
}