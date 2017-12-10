import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class SimulationWindow extends JFrame {

    //window properties
    private static final String TITLE = "Arduino Lights";
    private static final int INITIALIZE_WINDOW_WIDTH = 670;
    private static final int INITIALIZE_WINDOW_HEIGHT = 770;

    //window content
    private JLabel redLabel;
    private JLabel greenLabel;
    private JLabel blueLabel;

    private JLabel colorLabel;

    //functionality
    private Lighting lighting;

    SimulationWindow(Lighting lighting){

        this.lighting = lighting;


        //window stuff
        setPreferredSize(new Dimension(INITIALIZE_WINDOW_WIDTH, INITIALIZE_WINDOW_HEIGHT));
        setResizable(false);
        setLayout(new FlowLayout());
        setTitle(TITLE);

        this.add(colorPallet(), SwingConstants.CENTER);

        //ending window stuff
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        pack();
    }

    public boolean update() throws Exception {

        if(!lighting.update())
            return false;

        Color values = lighting.values();

        //bounds checking for safety
        if(values.getRed() > 255 || values.getRed() < 0)
            throw new Exception("RED: " + values.getRed());
        if(values.getGreen() > 255 || values.getGreen() < 0)
            throw new Exception("GREEN: " + values.getGreen());
        if(values.getBlue() > 255 || values.getBlue() < 0)
            throw new Exception("BLUE: " + values.getBlue());

        //setting label colors
        redLabel.setBackground(new Color(values.getRed(), 0, 0));
        greenLabel.setBackground(new Color(0, values.getGreen(), 0));
        blueLabel.setBackground(new Color(0, 0, values.getBlue()));
        colorLabel.setBackground(new Color(values.getRed(), values.getGreen(), values.getBlue()));

        repaint();

        return true;
    }



    /**
     * WINDOW COMPONENTS/SETUP
     * */
    private JPanel colorPallet(){

        JPanel colorPanel = new JPanel();
        colorPanel.setPreferredSize(new Dimension(INITIALIZE_WINDOW_WIDTH, INITIALIZE_WINDOW_HEIGHT));
        colorPanel.setBackground(Color.DARK_GRAY);

        /*Individual Color Container*/
        Container rgbVals = new Container();
        rgbVals.setPreferredSize(new Dimension(INITIALIZE_WINDOW_WIDTH, 180));
        rgbVals.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0, 0, 0, 5);
        rgbVals.add(redLabel = colorBox(), c);

        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(0, 0, 0, 5);
        rgbVals.add(greenLabel = colorBox(), c);

        c.gridx = 2;
        c.gridy = 0;
        c.insets = new Insets(0, 0, 0, 0);
        rgbVals.add(blueLabel = colorBox(), c);


        /*INCLUSIVE Color Label*/
        colorLabel = new JLabel();
        colorLabel.setOpaque(true);
        colorLabel.setPreferredSize(new Dimension(INITIALIZE_WINDOW_WIDTH, 520));
        colorLabel.setBackground(Color.BLACK);


        colorPanel.add(colorLabel);
        colorPanel.add(rgbVals);

        return colorPanel;
    }

    private JLabel colorBox(){
        JLabel label = new JLabel();
        label.setOpaque(true);
        label.setPreferredSize(new Dimension(215, 180));
        label.setBackground(Color.BLACK);
        label.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        return label;
    }

}
