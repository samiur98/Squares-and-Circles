package sample;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Objects;

public class GameScreen extends MusicScreen {
    //Class responsible for rendering the game screen.

    private GameInterface game = new Game();

    public GameScreen(Theme theme){
        super(theme,"main.mp3");
    }
    //Getter Functions/Accessor Methods.
    public GameInterface getGame(){
        return this.game;
    }

    //Setter Functions/Mutator Methods.
   public void setGame(GameInterface game){
        this.game = game;
   }

    public Scene getScene(Stage primaryStage){
        //Method that returns the scene associated with a game session.
        getScene().addEventHandler(KeyEvent.KEY_PRESSED, new ActionEvent(this));
        this.draw();
        getGroup().getChildren().add(getCanvas());
        AnimationTimer animator = new Animator(this, primaryStage);
        animator.start();
        return getScene();
    }
    public void draw(){
        //Method responsible for rendering graphics based upon provided data.
        int side = 100;
        this.getGraphicsContext().setFill(getTheme().getSecondary());
        this.getGraphicsContext().fillRect(0,0,500,100);
        this.getGraphicsContext().setFill(getTheme().getPrimary());
        this.getGraphicsContext().fillRect(0,100,500,300);
        this.getGraphicsContext().setFont(new Font(48));
        this.getGraphicsContext().fillText("SCORE: "+Integer.toString(this.game.getScore()),120,70);
        this.getGraphicsContext().setFill(getTheme().getTertiary());
        int position = (this.game.getPlayer().getPosistion() + 1) * 100;
        this.getGraphicsContext().fillOval(0, position, side, side);
        for(int i = 0;i <= 4;i++){
            int x = i * 100;
            Segment segment = this.game.getSegmentList().getList()[i];
            for(int j = 0;j <= 2;j++){
                int y = (j + 1) * 100;
                if(segment.getSquares()[j]){
                    this.getGraphicsContext().fillRect(x, y, side, side);}
            }
        }
    }

    @Override
    public String toString(){
        return "GameScreen";
    }
    @Override
    public boolean equals(Object other){
        if(!super.equals(other)){
            return false;
        }
        GameScreen gameScreen = (GameScreen) other;
        return this.game.equals(gameScreen.getGame());
    }
    @Override
    public int hashCode(){
        return Objects.hash(this.game);
    }
}
