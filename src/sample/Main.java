package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Random;

public class Main extends Application{
    //Main Class responsible for starting the game.
    private ArrayList<ColorPack> themes=new Themes().getThemes();//Array of "ColorPack" objects.Look at the documentation of the ColorPack class if this does not make any sense.
    private Random random=new Random();//Random object.
    private int picker=random.nextInt(8);//Integer used to randomly pick a theme.
    private ColorPack theme=themes.get(picker);//Current theme being used.
    @Override
    public void start(Stage primaryStage){
        StartScreen starter=new StartScreen(theme);
        starter.play_song();
        primaryStage.setScene(starter.getScene(primaryStage));
        primaryStage.setTitle("SQUARES AND CIRCLES");
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
