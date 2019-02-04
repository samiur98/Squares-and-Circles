package sample;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class StartScreen extends MusicScreen {
    //Class resbonsible for rendering the start screen of the game
    private Button start;
    private Button themeb;
    private Button quit;
    private BackgroundFill backgroundFill;
    private Background background;
    public StartScreen(ColorPack theme){
        super(theme,"game.mp3");
        start=new Button("START");
        themeb=new Button("THEMES");
        quit=new Button("QUIT");
        backgroundFill=new BackgroundFill(getTheme().getPrimary(),null,null);
        background=new Background(backgroundFill);

    }
    public Scene getScene(Stage stage){
        //Method that returns the scene of the start screen.
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
        themeb.setLayoutX(150);
        themeb.setLayoutY(320);
        themeb.setMinHeight(50);
        themeb.setMinWidth(200);
        themeb.setBackground(background);
        themeb.setTextFill(getTheme().getSecondary());
        themeb.setFont(new Font(20));
        themeb.setText("THEMES");
        quit.setLayoutX(150);
        quit.setLayoutY(390);
        quit.setMinHeight(50);
        quit.setMinWidth(200);
        quit.setBackground(background);
        quit.setTextFill(getTheme().getSecondary());
        quit.setFont(new Font(20));
        quit.setText("QUIT");
        start.setOnMouseClicked(StarterEvent.action(this,stage));
        themeb.setOnMouseClicked(TransitionEvent.action(this,new ThemeScreen(this.getTheme()),stage));
        quit.setOnMouseClicked(ExitEvent.exit(0));
        getGroup().getChildren().addAll(start,themeb,quit);
        return getScene();
    }
    //Getters
    public Button getStart(){
        return this.start;
    }
    public Button getThemeb(){
        return themeb;
    }
    public Button getQuit(){
        return quit;
    }
    public Background getBackground(){
        return background;
    }
    public BackgroundFill getBackgroundFill(){
        return backgroundFill;
    }
    //Setters
    public void setStart(Button start){
        this.start=start;
    }
    public void setThemeb(Button themeb){
        this.themeb=themeb;
    }
    public void setQuit(Button quit){
        this.quit=quit;
    }
}
