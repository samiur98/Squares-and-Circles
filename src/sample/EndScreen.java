package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Objects;

public class EndScreen extends MusicScreen {
    //Class responsible for rendering the end screen, the screen seen after player collides with square.

    private final int score;//Integer representing the score attained by a player after a game session.

    public EndScreen(Theme theme, int score) {
        super(theme, "sad.mp3");
        this.score = score;
    }

    //Getter Functions/Accessor Methods.
    public int getScore() {
        return this.score;
    }
    public Scene getScene(Stage stage) {
        //Method responsible for returning the scene of the end screen.
        Button menu = new Button();
        Button restart = new Button();
        BackgroundFill backgroundFill = new BackgroundFill(getTheme().getPrimary(), null, null);
        Background background = new Background(backgroundFill);
        getGraphicsContext().setFill(getTheme().getPrimary());
        getGraphicsContext().setFont(new Font(70));
        getGraphicsContext().fillText("GAME", 145, 100);
        getGraphicsContext().fillText("OVER", 150, 180);
        getGraphicsContext().setFont(new Font(80));
        getGraphicsContext().fillText("SCORE: ", 90, 280);
        getGraphicsContext().setFont(new Font(90));
        getGraphicsContext().fillText(Integer.toString(score), 150, 380);
        restart.setLayoutX(40);
        restart.setLayoutY(400);
        restart.setMinHeight(80);
        restart.setMinWidth(200);
        restart.setFont(new Font(25));
        restart.setTextFill(getTheme().getSecondary());
        restart.setBackground(background);
        restart.setText("RESTART");
        restart.setOnMouseClicked(new StarterEvent(this, stage));
        menu.setLayoutX(260);
        menu.setLayoutY(400);
        menu.setMinHeight(80);
        menu.setMinWidth(200);
        menu.setFont(new Font(25));
        menu.setTextFill(getTheme().getSecondary());
        menu.setBackground(background);
        menu.setText("MENU");
        menu.setOnMouseClicked(new TransitionEvent(this, new StartScreen(this.getTheme()), stage));
        getGroup().getChildren().addAll(getCanvas(), restart, menu);
        return getScene();
    }

    @Override
    public String toString(){
        return "EndScreen";
    }
    @Override
    public boolean equals(Object other){
        if(!super.equals(other)){
            return false;
        }
        EndScreen endScreen = (EndScreen) other;
        return this.score == endScreen.getScore();
    }
    @Override
    public int hashCode(){
        return Objects.hash(this.score) + (super.hashCode() * 31);
    }
}