package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.stage.Stage;

public class ThemeScreen extends MusicScreen{
    //Class responsible for rendering the Theme screen of the game.
    private Button ecstasy;//Buttons associated with respective themes.
    private Button winter;
    private Button rio;
    private Button nautica;
    private Button midnight;
    private Button panther;
    private Button cola;
    private Button turtle;
    private Button back;//Button responsible for exiting the theme screen and returning to the start screen.
    private BackgroundFill backgroundFill;
    private Background background;
    public ThemeScreen(ColorPack theme){
        super(theme,"menu.mp3");
        ecstasy=new Button();
        winter=new Button();
        rio=new Button();
        nautica=new Button();
        midnight=new Button();
        panther=new Button();
        cola=new Button();
        turtle=new Button();
        back=new Button();
        backgroundFill=new BackgroundFill(getTheme().getPrimary(),null,null);
        background=new Background(backgroundFill);

    }
    public Scene getScene(Stage stage){
        //Method responsible for returning the scene of the themescreen.
        backgroundFill=new BackgroundFill(getTheme().getPrimary(),null,null);
        background=new Background(backgroundFill);
        ecstasy.setBackground(background);
        ecstasy.setLayoutX(130);
        ecstasy.setLayoutY(10);
        ecstasy.setMinWidth(250);
        ecstasy.setMinHeight(50);
        ecstasy.setTextFill(getTheme().getSecondary());
        ecstasy.setText("ECSTASY");
        ecstasy.setOnMouseClicked(ThemeEvent.action("ecstasy",this,stage));
        winter.setBackground(background);
        winter.setLayoutX(130);
        winter.setLayoutY(70);
        winter.setMinWidth(250);
        winter.setMinHeight(50);
        winter.setTextFill(getTheme().getSecondary());
        winter.setText("WINTER");
        winter.setOnMouseClicked(ThemeEvent.action("winter",this,stage));
        rio.setBackground(background);
        rio.setLayoutX(130);
        rio.setLayoutY(130);
        rio.setMinWidth(250);
        rio.setMinHeight(50);
        rio.setTextFill(getTheme().getSecondary());
        rio.setText("RIO");
        rio.setOnMouseClicked(ThemeEvent.action("rio",this,stage));
        nautica.setBackground(background);
        nautica.setLayoutX(130);
        nautica.setLayoutY(190);
        nautica.setMinWidth(250);
        nautica.setMinHeight(50);
        nautica.setTextFill(getTheme().getSecondary());
        nautica.setText("NAUTICA");
        nautica.setOnMouseClicked(ThemeEvent.action("nautica",this,stage));
        midnight.setBackground(background);
        midnight.setLayoutX(130);
        midnight.setLayoutY(250);
        midnight.setMinWidth(250);
        midnight.setMinHeight(50);
        midnight.setTextFill(getTheme().getSecondary());
        midnight.setText("MIDNIGHT");
        midnight.setOnMouseClicked(ThemeEvent.action("midnight",this,stage));
        panther.setBackground(background);
        panther.setLayoutX(130);
        panther.setLayoutY(310);
        panther.setMinWidth(250);
        panther.setMinHeight(50);
        panther.setTextFill(getTheme().getSecondary());
        panther.setText("PANTHER");
        panther.setOnMouseClicked(ThemeEvent.action("panther",this,stage));
        cola.setBackground(background);
        cola.setLayoutX(130);
        cola.setLayoutY(370);
        cola.setMinWidth(250);
        cola.setMinHeight(50);
        cola.setTextFill(getTheme().getSecondary());
        cola.setText("COLA");
        cola.setOnMouseClicked(ThemeEvent.action("cola",this,stage));
        turtle.setBackground(background);
        turtle.setLayoutX(130);
        turtle.setLayoutY(430);
        turtle.setMinWidth(250);
        turtle.setMinHeight(50);
        turtle.setTextFill(getTheme().getSecondary());
        turtle.setText("TURTLE");
        turtle.setOnMouseClicked(ThemeEvent.action("turtle",this,stage));
        back.setBackground(background);
        back.setLayoutX(20);
        back.setLayoutY(10);
        back.setMinWidth(80);
        back.setMinHeight(50);
        back.setTextFill(getTheme().getSecondary());
        back.setText("BACK");
        back.setOnMouseClicked(TransitionEvent.action(this,new StartScreen(this.getTheme()),stage));
        getGroup().getChildren().addAll(ecstasy,winter,rio,nautica,midnight,panther,cola,turtle,back);
        return getScene();
    }
    //Getters
    public Button getEcstasy(){
        return ecstasy;
    }
    public Button getWinter(){
        return winter;
    }
    public Button getRio(){
        return rio;
    }
    public Button getNautica(){
        return nautica;
    }
    public Button getMidnight(){
        return midnight;
    }
    public Button getPanther(){
        return panther;
    }
    public Button getCola(){
        return cola;
    }
    public Button getTurtle(){
        return turtle;
    }
    public Button getBack(){
        return back;
    }
    public Background getBackground(){
        return background;
    }
    public BackgroundFill getBackgroundFill(){
        return backgroundFill;
    }
    //Setters
    public void setEcstasy(Button button){
        ecstasy=button;
    }
    public void setWinter(Button button){
        winter=button;
    }
    public void setRio(Button button){
        rio=button;
    }
    public void setNautica(Button button){
        nautica=button;
    }
    public void setMidnight(Button button){
        midnight=button;
    }
    public void  setPanther(Button button){
        panther=button;
    }
    public void setCola(Button button){
        cola=button;
    }
    public void  setTurtle(Button button){
        turtle=button;
    }
    public void setBack(Button button){
        back=button;
    }
    public void setBackgroundFill(BackgroundFill backgroundFill){
        this.backgroundFill=backgroundFill;
    }
    public void setBackground(Background background){
        this.background=background;
    }
}
