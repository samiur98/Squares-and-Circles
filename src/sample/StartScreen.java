package sample;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class StartScreen extends MusicScreen {
    //Class responsible for rendering the start screen of the game
    public StartScreen(Theme theme){
        super(theme,"game.mp3");

    }
    public Scene getScene(Stage stage){
        //Method that returns the scene of the start screen.
        Button start = new Button("START");
        Button themeButton = new Button("THEMES");
        Button quit = new Button("QUIT");
        BackgroundFill backgroundFill = new BackgroundFill(getTheme().getPrimary(),null,null);
        Background background = new Background(backgroundFill);
        getGraphicsContext().setFont(new Font(48));
        getGraphicsContext().setFill(getTheme().getPrimary());
        getGraphicsContext().fillText("SQUARES",140,80);
        getGraphicsContext().fillText("AND",200,130);
        getGraphicsContext().fillText("CIRCLES",150,180);
        getGroup().getChildren().add(getCanvas());
        start.setLayoutX(150);
        start.setLayoutY(250);
        start.setMinHeight(50);
        start.setMinWidth(200);
        start.setBackground(background);
        start.setTextFill(getTheme().getSecondary());
        start.setFont(new Font(20));
        start.setText("START");
        themeButton.setLayoutX(150);
        themeButton.setLayoutY(320);
        themeButton.setMinHeight(50);
        themeButton.setMinWidth(200);
        themeButton.setBackground(background);
        themeButton.setTextFill(getTheme().getSecondary());
        themeButton.setFont(new Font(20));
        themeButton.setText("THEMES");
        quit.setLayoutX(150);
        quit.setLayoutY(390);
        quit.setMinHeight(50);
        quit.setMinWidth(200);
        quit.setBackground(background);
        quit.setTextFill(getTheme().getSecondary());
        quit.setFont(new Font(20));
        quit.setText("QUIT");
        start.setOnMouseClicked(new StarterEvent(this, stage));
        themeButton.setOnMouseClicked(new TransitionEvent(this, new ThemeScreen(this.getTheme()), stage));
        quit.setOnMouseClicked(new ExitEvent());
        getGroup().getChildren().addAll(start, themeButton, quit);
        return getScene();
    }

    @Override
    public String toString(){
        return "StartScreen";
    }
}
