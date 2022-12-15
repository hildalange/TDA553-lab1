import java.awt.*;
import javax.swing.*;
import javax.swing.JPanel;

public class ProgramWindow extends JFrame {
    private static final int x = 800;
    private static final int y = 800;

    public ProgramWindow(String framename, JPanel panelOne, JPanel panelTwo){
        initComponents(framename, panelOne, panelTwo);
    }

    private void initComponents(String titel, JPanel panelOne, JPanel panelTwo){
        setTitle(titel);
        setPreferredSize(new Dimension(x,y));
        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        add(panelOne);
        add(panelTwo);
        pack();

        Dimension dimens = Toolkit.getDefaultToolkit().getScreenSize();

        setLocation(dimens.width/2-this.getSize().width/2, dimens.height/2-this.getSize().height/2);

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    }

}
