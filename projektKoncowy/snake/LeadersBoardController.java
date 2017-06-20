package projektKoncowy.snake;
/**
 * Created by maknez on 11.05.2017.
 */

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class LeadersBoardController {

    private static Stage menuStage;
    @FXML
    Button returnButton;

    public static void setStage(Stage stage) {
        menuStage = stage;
    }

    public void initialize() {
        returnButton.setOnAction(event -> {
            try {
                menuStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Menu.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
