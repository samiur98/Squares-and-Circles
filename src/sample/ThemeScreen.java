package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.stage.Stage;

public class ThemeScreen extends MusicScreen{
    //Class responsible for rendering the ThemeScreen (The Screen where users can change the theme) of the game.

    public ThemeScreen(Theme theme){
        super(theme,"menu.mp3");
    }

    public Scene getScene(Stage stage){
        //Method responsible for returning the scene of the themeScreen.
        BackgroundFill backgroundFill=new BackgroundFill(getTheme().getPrimary(),null,null);
        Background background=new Background(backgroundFill);

        //Button Declarations.
        Button ecstasy = new Button();
        Button winter = new Button();
        Button rio = new Button();
        Button nautica = new Button();
        Button midnight = new Button();
        Button panther = new Button();
        Button cola = new Button();
        Button turtle = new Button();
        Button back = new Button();

        //Buttons that change theme.
        //Button for the ecstasy theme.
        ecstasy.setBackground(background);
        ecstasy.setLayoutX(130);
        ecstasy.setLayoutY(10);
        ecstasy.setMinWidth(250);
        ecstasy.setMinHeight(50);
        ecstasy.setTextFill(getTheme().getSecondary());
        ecstasy.setText("ECSTASY");
        ecstasy.setOnMouseClicked(new ThemeEvent("ecstasy",this, stage));
        //Button for the winter theme.
        winter.setBackground(background);
        winter.setLayoutX(130);
        winter.setLayoutY(70);
        winter.setMinWidth(250);
        winter.setMinHeight(50);
        winter.setTextFill(getTheme().getSecondary());
        winter.setText("WINTER");
        winter.setOnMouseClicked(new ThemeEvent("winter",this, stage));
        //Button for the rio theme.
        rio.setBackground(background);
        rio.setLayoutX(130);
        rio.setLayoutY(130);
        rio.setMinWidth(250);
        rio.setMinHeight(50);
        rio.setTextFill(getTheme().getSecondary());
        rio.setText("RIO");
        rio.setOnMouseClicked(new ThemeEvent("rio", this, stage));
        //Button for the nautica theme.
        nautica.setBackground(background);
        nautica.setLayoutX(130);
        nautica.setLayoutY(190);
        nautica.setMinWidth(250);
        nautica.setMinHeight(50);
        nautica.setTextFill(getTheme().getSecondary());
        nautica.setText("NAUTICA");
        nautica.setOnMouseClicked(new ThemeEvent("nautica",this, stage));
        //Button for the midnight theme.
        midnight.setBackground(background);
        midnight.setLayoutX(130);
        midnight.setLayoutY(250);
        midnight.setMinWidth(250);
        midnight.setMinHeight(50);
        midnight.setTextFill(getTheme().getSecondary());
        midnight.setText("MIDNIGHT");
        midnight.setOnMouseClicked(new ThemeEvent("midnight",this, stage));
        //Button for the panther theme.
        panther.setBackground(background);
        panther.setLayoutX(130);
        panther.setLayoutY(310);
        panther.setMinWidth(250);
        panther.setMinHeight(50);
        panther.setTextFill(getTheme().getSecondary());
        panther.setText("PANTHER");
        panther.setOnMouseClicked(new ThemeEvent("panther",this, stage));
        //Button for the cola theme.
        cola.setBackground(background);
        cola.setLayoutX(130);
        cola.setLayoutY(370);
        cola.setMinWidth(250);
        cola.setMinHeight(50);
        cola.setTextFill(getTheme().getSecondary());
        cola.setText("COLA");
        cola.setOnMouseClicked(new ThemeEvent("cola",this, stage));
        //Button for the turtle theme.
        turtle.setBackground(background);
        turtle.setLayoutX(130);
        turtle.setLayoutY(430);
        turtle.setMinWidth(250);
        turtle.setMinHeight(50);
        turtle.setTextFill(getTheme().getSecondary());
        turtle.setText("TURTLE");
        turtle.setOnMouseClicked(new ThemeEvent("turtle",this, stage));

        //Button that allows the user to return to the main menu of the game.
        back.setBackground(background);
        back.setLayoutX(20);
        back.setLayoutY(10);
        back.setMinWidth(80);
        back.setMinHeight(50);
        back.setTextFill(getTheme().getSecondary());
        back.setText("BACK");
        back.setOnMouseClicked( new TransitionEvent(this, new StartScreen(this.getTheme()), stage));

        //Finishing.
        getGroup().getChildren().addAll(ecstasy,winter,rio,nautica,midnight,panther,cola,turtle,back);
        return getScene();
    }

    @Override
    public String toString(){
        return "ThemeScreen";
    }
}
