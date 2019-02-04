package sample;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GameScreen extends MusicScreen {
    //Class responsible for rendering the game screen and handling the game mechanics.
    /*Single responsiblity principle not maintained since the functionality of rendering the game screen
      and maintaining the game mechanism are tightly coupled*/
    private Player player;
    private SegmentList list;
    private int score;
    private int side=100;//The deafault size of the dimensions of the shapes in the game.
    private int timer=0;//Timer used for animation purposes.
    public GameScreen(ColorPack theme){
             super(theme,"main.mp3");
             player=new Player();
             list=new SegmentList();
             score=0;
    }
    public Player getCircle(){
        return this.player;
    }
    public SegmentList getList(){
        return this.list;
    }
    public Integer getScore(){
        return this.score;
    }
    public void setCircle(Player player){
        this.player=player;
    }
    public void setList(SegmentList list){
        this.list=list;
    }
    public void setScore(Integer score){
        this.score=score;
    }
    public Scene getScene(Stage primaryStage){
        //Method that handles the main game.
        getScene().addEventHandler(KeyEvent.KEY_PRESSED,ActionEvent.move(this));
        Canvas canvas=new Canvas(500,500);
        GraphicsContext g=canvas.getGraphicsContext2D();
        draw(g,list,player);
        getGroup().getChildren().add(canvas);
        GameScreen gs=this;
        AnimationTimer timmy=new AnimationTimer(){
            @Override
            public void handle(long current){
                if(timer>36){
                    list.update();
                    if(collision()){
                        //mediaPlayer.stop();
                        //primaryStage.setScene(gameover(primaryStage));
                        stop();
                        gs.stop_song();
                        primaryStage.setScene(new EndScreen(getTheme(),score).getScene(primaryStage));
                    }
                    score=score+1;
                    draw(g,list,player);
                    timer=0;
                }
                else{
                    timer=timer+1;
                }
            }
        };
        timmy.start();
        return getScene();
    }
    private void draw(GraphicsContext g,SegmentList list,Player player){
        //Method responsible for rendering graphics based upon provided data.
        g.setFill(getTheme().getSecondary());
        g.fillRect(0,0,500,100);
        g.setFill(getTheme().getPrimary());
        g.fillRect(0,100,500,300);
        g.setFont(new Font(48));
        g.fillText("SCORE:"+Integer.toString(score),120,70);
        g.setFill(getTheme().getTertiary());
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
    public boolean collision(){
        //Method used to detect collisions i.e when player(cirlce) fails to avoid obstacles(squares).
        Segment segment=list.getData()[0];
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
}
