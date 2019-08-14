package sample;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Objects;

public class ActionEvent implements EventHandler<KeyEvent> {
    //Class that provides movement for the player.

    private GameScreen gameScreen; //The GameScreen Object that uses the ActionEvent.

    public ActionEvent(GameScreen gameScreen){
        this.gameScreen = gameScreen;
    }
    //Getter Functions/ Accessor Methods.
    public GameScreen getGameScreen(){
        return this.gameScreen;
    }

    //Setter Functions/ Mutator Methods.
    public void setGameScreen(GameScreen gameScreen){
        this.gameScreen = gameScreen;
    }

    @Override
    public void handle(KeyEvent event){
        if(event.getCode().equals(KeyCode.UP)){
            this.gameScreen.getGame().setScore(this.gameScreen.getGame().getScore() + 2);
            this.gameScreen.getGame().getPlayer().moveUp();
        }
        else if(event.getCode().equals(KeyCode.DOWN)){
            this.gameScreen.getGame().setScore(this.gameScreen.getGame().getScore() + 2);
            this.gameScreen.getGame().getPlayer().moveDown();
        }
    }

    @Override
    public String toString(){
        return "ActionEvent";
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
        ActionEvent actionEvent = (ActionEvent) other;
        return this.gameScreen.equals(actionEvent.getGameScreen());
    }
    @Override
    public int hashCode(){
        return Objects.hash(this.gameScreen);
    }

}
