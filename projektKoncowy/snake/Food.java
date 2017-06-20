package projektKoncowy.snake;
/**
 * Created by maknez on 11.05.2017.
 */

import java.util.Random;
import javafx.scene.paint.Color;

public class Food extends SnakePart {

    private boolean eated;
    private static Color color=new Color(1, 0.4275, 0.0157, 1);

    public Food() {
        super();
        this.eated = false;
        Random rand = new Random();
        int x = rand.nextInt(580) / 20;
        int y = rand.nextInt(580) / 20;
        this.setX(x*SnakePart.getWidth());
        this.setY(y*SnakePart.getHeight());
    }
    
    public static Color getColor() {
        return color;
    }

    public boolean isEated() {
        return eated;
    }

    public void setEated(boolean eated) {
        this.eated = eated;
    }
}
