package projektKoncowy.snake;
/**
 * Created by maknez on 17.06.2017.
 */

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class MenuController {

    @FXML
    Button NewGameButton;
    @FXML
    Button LeadersBoardsButton;
    @FXML
    Button ExitButton;

    public static Stage menuStage;

    public static void setStage(Stage stage) {
        menuStage = stage;
    }

    public void initialize() {
        NewGameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    SnakeController.setStage(menuStage);
                    menuStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("layout.fxml"))));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        LeadersBoardsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    LeadersBoardController.setStage(menuStage);
                    menuStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("leadersBoard.fxml"))));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        ExitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                menuStage.close();
            }
        });


    }

}
