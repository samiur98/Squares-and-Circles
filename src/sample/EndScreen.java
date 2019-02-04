package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class EndScreen extends MusicScreen {
    //Class responsible for rendering the end screen ie the screen seen after player collides with square.
    //"The game over" screen.
    private int score;
    private Button menu;
    private Button restart;
    private Background background;
    private BackgroundFill backgroundFill;
    public EndScreen(ColorPack theme,int score){
           super(theme,"sad.mp3");
           this.score=score;
           menu=new Button();
           restart=new Button();
           backgroundFill=new BackgroundFill(getTheme().getPrimary(),null,null);
           background=new Background(backgroundFill);
    }
    //Getters
    public int getScore(){
        return this.score;
    }
    public Button getMenu(){
        return menu;
    }
    public Button getRestart(){
        return restart;
    }
    public BackgroundFill getBackgroundFill(){
        return backgroundFill;
    }
    public Background getBackground(){
        return background;
    }
    //Setters
    public void setScore(Integer score){
        this.score=score;
    }
    public void setMenu(Button button){
        menu=button;
    }
    public void setRestart(Button button){
        restart=button;
    }
    public void setBackground(Background background){
        this.background=background;
    }
    public void setBackgroundFill(BackgroundFill backgroundFill){
        this.backgroundFill=backgroundFill;
    }
    public Scene getScene(Stage stage){
        //Method responsible for returning the scene of the end screen.
        this.play_song();
        getGraphicsContext().setFill(getTheme().getPrimary());
        getGraphicsContext().setFont(new Font(70));
        getGraphicsContext().fillText("GAME",145,100);
        getGraphicsContext().fillText("OVER",150,180);
        getGraphicsContext().setFont(new Font(80));
        getGraphicsContext().fillText("SCORE:",90,280);
        getGraphicsContext().setFont(new Font(90));
        getGraphicsContext().fillText(Integer.toString(score),150,380);
        restart.setLayoutX(40);
        restart.setLayoutY(400);
        restart.setMinHeight(80);
        restart.setMinWidth(200);
        restart.setFont(new Font(25));
        restart.setTextFill(getTheme().getSecondary());
        restart.setBackground(background);
        restart.setText("RESTART");
        restart.setOnMouseClicked(StarterEvent.action(this,stage));
        menu.setLayoutX(260);
        menu.setLayoutY(400);
        menu.setMinHeight(80);
        menu.setMinWidth(200);
        menu.setFont(new Font(25));
        menu.setTextFill(getTheme().getSecondary());
        menu.setBackground(background);
        menu.setText("MENU");
        menu.setOnMouseClicked(TransitionEvent.action(this,new StartScreen(this.getTheme()),stage));
        getGroup().getChildren().addAll(getCanvas(),restart,menu);
        return getScene();
    }
    }
