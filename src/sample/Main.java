package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;


public class Main extends Application {
    private ColorPack[] themes=Themes.getThemes();//Array of "ColorPack" objects.Look at the documentation of the ColorPack class if this does not make any sense.
    private int side=100;//The deafault size of the dimensions of the shapes in the game.
    private Random random=new Random();//Random object.
    private int picker=random.nextInt(8);//Integer used to randomly pick a theme.
    private ColorPack theme=themes[picker];//Current theme being used.
    private int score=0;//Integer used to store score value.
    private int timer=0;//Integer used for animation purposes.
    @Override
    public void start(Stage primaryStage){
        primaryStage.setScene(startScreen(primaryStage));
        primaryStage.setTitle("SQUARES AND CIRCLES");
        primaryStage.show();
    }
    private void draw(GraphicsContext g,SegmentList list,Player player){
        //Method responsible for rendering graphics based upon provided data.
        g.setFill(theme.getSecondary());
        g.fillRect(0,0,500,100);
        g.setFill(theme.getPrimary());
        g.fillRect(0,100,500,300);
        g.setFont(new Font(48));
        g.fillText("SCORE:"+Integer.toString(score),120,70);
        g.setFill(theme.getTertiary());
        int pos=(player.getPos()+1)*100;
        g.fillOval(0,pos,side,side);
        for(int i=0;i<=4;i++){
            int x=i*100;
            Segment s=list.getData()[i];
            for(int j=0;j<=2;j++){
                int y=(j+1)*100;
                if(s.getSquares()[j]){
                g.fillRect(x,y,side,side);}
            }
        }
    }
    private boolean collision(Player player,SegmentList seg){
           //Method used to detect collisions i.e when player(cirlce) fails to avoid obstacles(squares).
           Segment segment=seg.getData()[0];
           int pos=player.getPos();
           if(pos==0){
               if(segment.getSquares()[0]){return true;}
           }
           else if(pos==1){
               if(segment.getSquares()[1]){return true;}
           }
           else{
               if(segment.getSquares()[2]){return true;}
           }
           return false;
    }
    private Scene gameloop(Stage primaryStage){
        //Method that handles the main game.
        Player player=new Player();
        SegmentList seggy=new SegmentList();
        Group root=new Group();
        Scene scene=new Scene(root,500,500,theme.getSecondary());
        Media song=new Media(getClass().getResource("main.mp3").toExternalForm());
        MediaPlayer mediaPlayer=new MediaPlayer(song);
        mediaPlayer.play();
        EventHandler<KeyEvent> move=new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode().equals(KeyCode.UP)){
                    score=score+2;
                    player.moveUp();
                }
                else if(event.getCode().equals(KeyCode.DOWN)){
                    score=score+2;
                    player.moveDown();
                }
            }
        };
        scene.addEventHandler(KeyEvent.KEY_PRESSED,move);
        Canvas canvas=new Canvas(500,500);
        GraphicsContext g=canvas.getGraphicsContext2D();
        draw(g,seggy,player);
        root.getChildren().add(canvas);
        AnimationTimer timmy=new AnimationTimer(){
            @Override
            public void handle(long current){
                if(timer>36){
                    seggy.update();
                    if(collision(player,seggy)){
                        mediaPlayer.stop();
                        primaryStage.setScene(gameover(primaryStage));
                        stop();
                    }
                    score=score+1;
                    draw(g,seggy,player);
                    timer=0;
                }
                else{
                    timer=timer+1;
                }
            }
        };
        timmy.start();
        return scene;
    }
    private Scene startScreen(Stage stage){
        //Method responsible for the startscreen of the game.
        Group group=new Group();
        Scene scene=new Scene(group,500,500,theme.getSecondary());
        Media song=new Media(getClass().getResource("game.mp3").toExternalForm());
        MediaPlayer mediaPlayer=new MediaPlayer(song);
        mediaPlayer.play();
        Canvas canvas=new Canvas(500,500);
        GraphicsContext g=canvas.getGraphicsContext2D();
        g.setFont(new Font(48));
        g.setFill(theme.getText());
        g.fillText("SQUARES",140,80);
        g.fillText("AND",200,130);
        g.fillText("CIRCLES",150,180);
        group.getChildren().add(canvas);
        Button start=new Button("START");
        start.setLayoutX(150);
        start.setLayoutY(250);
        start.setMinHeight(50);
        start.setMinWidth(200);
        BackgroundFill backgroundFill=new BackgroundFill(theme.getPrimary(),null,null);
        Background background=new Background(backgroundFill);
        start.setBackground(background);
        start.setTextFill(theme.getSecondary());
        start.setFont(new Font(20));
        start.setText("START");
        Button themeb=new Button();
        themeb.setLayoutX(150);
        themeb.setLayoutY(320);
        themeb.setMinHeight(50);
        themeb.setMinWidth(200);
        themeb.setBackground(background);
        themeb.setTextFill(theme.getSecondary());
        themeb.setFont(new Font(20));
        themeb.setText("THEMES");
        Button quit=new Button();
        quit.setLayoutX(150);
        quit.setLayoutY(390);
        quit.setMinHeight(50);
        quit.setMinWidth(200);
        quit.setBackground(background);
        quit.setTextFill(theme.getSecondary());
        quit.setFont(new Font(20));
        quit.setText("QUIT");
        EventHandler<MouseEvent> start_event=new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mediaPlayer.stop();
                stage.setScene(gameloop(stage));
            }
        };
        EventHandler<MouseEvent> quit_event=new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.exit(1);
            }
        };
        EventHandler<MouseEvent> theme_event=new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mediaPlayer.stop();
                stage.setScene(themeMenu(stage));
            }
        };
        start.setOnMouseClicked(start_event);
        themeb.setOnMouseClicked(theme_event);
        quit.setOnMouseClicked(quit_event);
        group.getChildren().addAll(start,themeb,quit);
        return scene;
    }
    private Scene gameover(Stage stage){
        //Method responsible for the "gameover" screen of the game.
        Group group=new Group();
        Scene scene=new Scene(group,500,500,theme.getSecondary());
        Media song=new Media(getClass().getResource("sad.mp3").toExternalForm());
        MediaPlayer mediaPlayer=new MediaPlayer(song);
        mediaPlayer.play();
        Canvas canvas=new Canvas(500,500);
        GraphicsContext g=canvas.getGraphicsContext2D();
        g.setFill(theme.getPrimary());
        g.setFont(new Font(70));
        g.fillText("GAME",145,100);
        g.fillText("OVER",150,180);
        g.setFont(new Font(80));
        g.fillText("SCORE:",90,280);
        g.setFont(new Font(90));
        g.fillText(Integer.toString(score),150,380);
        score=0;
        BackgroundFill backgroundFill=new BackgroundFill(theme.getPrimary(),null,null);
        Background background=new Background(backgroundFill);
        EventHandler<MouseEvent> restart_event=new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mediaPlayer.stop();
                stage.setScene(gameloop(stage));
            }
        };
        EventHandler<MouseEvent> menu_event=new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mediaPlayer.stop();
                stage.setScene(startScreen(stage));
            }
        };
        Button restart=new Button();
        restart.setLayoutX(40);
        restart.setLayoutY(400);
        restart.setMinHeight(80);
        restart.setMinWidth(200);
        restart.setFont(new Font(25));
        restart.setTextFill(theme.getSecondary());
        restart.setBackground(background);
        restart.setText("RESTART");
        restart.setOnMouseClicked(restart_event);
        Button menu=new Button();
        menu.setLayoutX(260);
        menu.setLayoutY(400);
        menu.setMinHeight(80);
        menu.setMinWidth(200);
        menu.setFont(new Font(25));
        menu.setTextFill(theme.getSecondary());
        menu.setBackground(background);
        menu.setText("MENU");
        menu.setOnMouseClicked(menu_event);
        group.getChildren().addAll(canvas,restart,menu);
        return scene;
    }
    private Scene themeMenu(Stage stage){
        //Method responsible for the theme selection menu screen.
        Group group=new Group();
        Scene scene=new Scene(group,500,500,theme.getSecondary());
        //Canvas canvas=new Canvas(500,500);
        Media song=new Media(getClass().getResource("menu.mp3").toExternalForm());
        MediaPlayer mediaPlayer=new MediaPlayer(song);
        mediaPlayer.play();
        BackgroundFill backgroundFill=new BackgroundFill(theme.getPrimary(),null,null);
        Background background=new Background(backgroundFill);
        EventHandler<MouseEvent> ecstasyEvent=new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                theme=themes[0];
                mediaPlayer.stop();
                stage.setScene(themeMenu(stage));
            }
        };
        EventHandler<MouseEvent> winterEvent=new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mediaPlayer.stop();
                theme=themes[1];
                stage.setScene(themeMenu(stage));
            }
        };
        EventHandler<MouseEvent> rioEvent=new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mediaPlayer.stop();
                theme=themes[2];
                stage.setScene(themeMenu(stage));
            }
        };
        EventHandler<MouseEvent> nauticaEvent=new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mediaPlayer.stop();
                theme=themes[3];
                stage.setScene(themeMenu(stage));
            }
        };
        EventHandler<MouseEvent> midnightEvent=new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mediaPlayer.stop();
                theme=themes[4];
                stage.setScene(themeMenu(stage));
            }
        };
        EventHandler<MouseEvent> pantherEvent=new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mediaPlayer.stop();
                theme=themes[5];
                stage.setScene(themeMenu(stage));
            }
        };
        EventHandler<MouseEvent> colaEvent=new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mediaPlayer.stop();
                theme=themes[6];
                stage.setScene(themeMenu(stage));
            }
        };
        EventHandler<MouseEvent> turtleEvent=new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mediaPlayer.stop();
                theme=themes[7];
                stage.setScene(themeMenu(stage));
            }
        };
        EventHandler<MouseEvent> backEvent=new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mediaPlayer.stop();
                stage.setScene(startScreen(stage));
            }
        };
        Button ecstasy=new Button();
        ecstasy.setBackground(background);
        ecstasy.setLayoutX(130);
        ecstasy.setLayoutY(10);
        ecstasy.setMinWidth(250);
        ecstasy.setMinHeight(50);
        ecstasy.setTextFill(theme.getSecondary());
        ecstasy.setText("ECSTASY");
        ecstasy.setOnMouseClicked(ecstasyEvent);
        Button winter=new Button();
        winter.setBackground(background);
        winter.setLayoutX(130);
        winter.setLayoutY(70);
        winter.setMinWidth(250);
        winter.setMinHeight(50);
        winter.setTextFill(theme.getSecondary());
        winter.setText("WINTER");
        winter.setOnMouseClicked(winterEvent);
        Button rio=new Button();
        rio.setBackground(background);
        rio.setLayoutX(130);
        rio.setLayoutY(130);
        rio.setMinWidth(250);
        rio.setMinHeight(50);
        rio.setTextFill(theme.getSecondary());
        rio.setText("RIO");
        rio.setOnMouseClicked(rioEvent);
        Button nautica=new Button();
        nautica.setBackground(background);
        nautica.setLayoutX(130);
        nautica.setLayoutY(190);
        nautica.setMinWidth(250);
        nautica.setMinHeight(50);
        nautica.setTextFill(theme.getSecondary());
        nautica.setText("NAUTICA");
        nautica.setOnMouseClicked(nauticaEvent);
        Button midnight=new Button();
        midnight.setBackground(background);
        midnight.setLayoutX(130);
        midnight.setLayoutY(250);
        midnight.setMinWidth(250);
        midnight.setMinHeight(50);
        midnight.setTextFill(theme.getSecondary());
        midnight.setText("MIDNIGHT");
        midnight.setOnMouseClicked(midnightEvent);
        Button panther=new Button();
        panther.setBackground(background);
        panther.setLayoutX(130);
        panther.setLayoutY(310);
        panther.setMinWidth(250);
        panther.setMinHeight(50);
        panther.setTextFill(theme.getSecondary());
        panther.setText("PANTHER");
        panther.setOnMouseClicked(pantherEvent);
        Button cola=new Button();
        cola.setBackground(background);
        cola.setLayoutX(130);
        cola.setLayoutY(370);
        cola.setMinWidth(250);
        cola.setMinHeight(50);
        cola.setTextFill(theme.getSecondary());
        cola.setText("COLA");
        cola.setOnMouseClicked(colaEvent);
        Button turtle=new Button();
        turtle.setBackground(background);
        turtle.setLayoutX(130);
        turtle.setLayoutY(430);
        turtle.setMinWidth(250);
        turtle.setMinHeight(50);
        turtle.setTextFill(theme.getSecondary());
        turtle.setText("TURTLE");
        turtle.setOnMouseClicked(turtleEvent);
        Button back=new Button();
        back.setBackground(background);
        back.setLayoutX(20);
        back.setLayoutY(10);
        back.setMinWidth(80);
        back.setMinHeight(50);
        back.setTextFill(theme.getSecondary());
        back.setText("BACK");
        back.setOnMouseClicked(backEvent);
        group.getChildren().addAll(ecstasy,winter,rio,nautica,midnight,panther,cola,turtle,back);
        return scene;
    }
    public static void main(String[] args) {
        launch(args);
    }
}
