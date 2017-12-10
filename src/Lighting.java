import java.awt.*;

public class Lighting {

    //ints over bytes to ensure algorithm safety
    private int red;
    private int green;
    private int blue;

    Lighting(Color initialColor){
        this.red = initialColor.getRed();
        this.green = initialColor.getGreen();
        this.blue = initialColor.getBlue();
    }


    /*
    * The "loop" in Arduino
    * Don't care about drifting, so using Thread.sleep is fine.
    * Returns true to continue updating. False stops execution.
    * */
    public boolean update(){




        return true;
    }


    public Color values(){
        return new Color(red, green, blue);
    }

    @Override
    public String toString(){
        return "\nLighting >\n  red: " + red +
                "\n  green: " + green +
                "\n  blue: " + blue + "\n";
    }

}
