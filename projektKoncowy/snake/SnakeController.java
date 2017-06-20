package projektKoncowy.snake;
/**
 * Created by maknez on 11.05.2017.
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;

public class SnakeController {
    
    private Game game;
    public int speed;
    private static Stage menuStage;
    @FXML
    private Canvas canvas;
    @FXML
    private Text text;
    @FXML
    private MenuItem returnButton;
    @FXML
    private MenuItem restartButton;
    private Timeline timeline;
    @FXML
    private void exitAction(ActionEvent event) {
        System.exit(0);
    }
    @FXML
    private void newActionEasy(ActionEvent event) {
        speed = 250;
        game = new Game();
        repaint();
    }
    @FXML
    private void newActionMedium(ActionEvent event) {
        speed = 100;
        game = new Game();
        repaint();
    }
    @FXML
    private void newActionHard(ActionEvent event) {
        speed = 50;
        game = new Game();
        repaint();
    }
    @FXML
    private void newActionInsane(ActionEvent event) {
        speed = 10;
        game = new Game();
        repaint();
    }

    public void initialize() {
        returnButton.setOnAction(event -> {
            try {
                menuStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Menu.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        restartButton.setOnAction(event -> {
            try {
                menuStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("layout.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public static void setStage(Stage stage) {
        menuStage = stage;
    }

    @FXML
    private void keyHandler(KeyEvent e) {
        if (e.getCode() == KeyCode.RIGHT) {
            game.snake.setDirection(0);
        }
        else if(e.getCode() == KeyCode.UP) {
            game.snake.setDirection(1);
        }
        else if(e.getCode() == KeyCode.LEFT) {
            game.snake.setDirection(2);
        }
        else if(e.getCode() == KeyCode.DOWN) {
            game.snake.setDirection(3);
        }
    }
    @FXML
    public void repaint() {
        Duration duration = Duration.millis(speed);
        timeline = new Timeline(new KeyFrame(duration, (ActionEvent event) -> {
            text.setText("Your score: "+String.valueOf(game.getScore()));
            GraphicsContext context = canvas.getGraphicsContext2D();
            if ( !game.isGameOver() ) {
                context.setFill(Color.BLANCHEDALMOND);
                context.fillRect(0, 0, 600, 600);

                game.snake.getSnake().stream().forEach((part) -> {
                    context.setFill(SnakePart.getColor());
                    context.fillRect(part.getX(), part.getY(), SnakePart.getWidth(), SnakePart.getHeight());
                });
                context.setFill(Food.getColor());
                context.fillRect(game.food.getX(), game.food.getY(), SnakePart.getWidth(), SnakePart.getHeight());
            }
            else {
                context.setFill(Color.BLANCHEDALMOND);
                context.fillRect(0, 0, 600, 600);
                context.setFill(Color.BLACK);
                context.setFont(new Font(24));
                context.setTextAlign(TextAlignment.CENTER);
                context.fillText("Game Over!", 300, 300);
                timeline.stop();
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
}
