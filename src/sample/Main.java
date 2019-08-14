package sample;

import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application{
    //Main Class responsible for starting the game.
    private Themes themes = new Themes();
    private Theme theme = themes.search("cola");//Current theme being used.

    @Override
    public void start(Stage primaryStage){
        StartScreen starter = new StartScreen(theme);
        starter.playSong();
        primaryStage.setScene(starter.getScene(primaryStage));
        primaryStage.setTitle("SQUARES AND CIRCLES");
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
