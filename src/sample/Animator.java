package sample;

import javafx.animation.AnimationTimer;
import javafx.stage.Stage;

import java.util.Objects;

public class Animator extends AnimationTimer {
    //Animator class that provides Animation for a GameScreen.

    private int timer = 0; //Integer needed for animation.
    private GameScreen gameScreen; //GameScreen Object that the Animator animates.
    private Stage primaryStage; //Stage of the GameScreen Object.

    public Animator(GameScreen gameScreen, Stage primaryStage){
        this.gameScreen = gameScreen;
        this.primaryStage = primaryStage;
    }
    //Getter Functions/Accessor Methods.
    public GameScreen getGameScreen(){
        return this.gameScreen;
    }
    public Stage getStage(){
        return this.primaryStage;
    }

    //Setter Functions/Mutator Methods.
    public void setGameScreen(GameScreen gameScreen){
        this.gameScreen = gameScreen;
    }
    public void setPrimaryStage(Stage stage){
        this.primaryStage = stage;
    }

    @Override
    public void handle(long current){
        if(this.timer > 25){
            this.gameScreen.getGame().getSegmentList().update();
            if(this.gameScreen.getGame().collision()){
                stop();
                this.gameScreen.stopSong();
                EndScreen endScreen = new EndScreen(this.gameScreen.getTheme(), this.gameScreen.getGame().getScore());
                this.primaryStage.setScene(endScreen.getScene(this.primaryStage));
                endScreen.playSong();
            }
            this.gameScreen.getGame().setScore(this.gameScreen.getGame().getScore() + 1);
            this.gameScreen.draw();
            this.timer = 0;
        }
        else{
            this.timer = this.timer + 1;
        }
    }

    @Override
    public String toString(){
        return "Animator";
    }
    @Override
    public boolean equals(Object other){
        if(this == other){
            return true;
        }
        if(other == null){
            return false;
        }
        if(this.getClass() != other.getClass()){
            return false;
        }
        Animator animator = (Animator) other;
        return this.gameScreen.equals(animator.getGameScreen()) && this.primaryStage.equals(animator.getStage());
    }
    public int hashCode(){
        return Objects.hash(this.gameScreen, this.primaryStage);
    }
}
