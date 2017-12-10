import java.awt.*;

public class Main {

    private static SimulationWindow window;
    private static Lighting lighting;

    //color object because of color picker ;)
    private static Color initialColor = new Color(0, 0, 255);

    public static void main(String[] args){

        //create window and lighting control
        lighting = new Lighting(initialColor);
        window = new SimulationWindow(lighting);

        //start the update process
        update();
    }

    private static void update(){

        try{

            while(window.update()){
                //use for logs in stuff
            }

        } catch (Exception e){
            e.printStackTrace();
            System.out.println(lighting);
        }

    }//update
}
