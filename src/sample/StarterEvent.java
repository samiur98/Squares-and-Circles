package sample;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.Objects;

public class StarterEvent implements EventHandler<MouseEvent>{
    //Class that starts a Game.

    private Screen current;
    private Stage stage;

    public StarterEvent(Screen current, Stage stage){
        this.current = current;
        this.stage = stage;
    }
    //Getter Functions/Accessor Methods.
    public Screen getCurrent(){
        return this.current;
    }
    public Stage getStage(){
        return this.stage;
    }

    //Setter Functions/Mutator Methods.
    public void setCurrent(Screen current){
        this.current = current;
    }
    public void setStage(Stage stage){
        this.stage = stage;
    }

    @Override
    public void handle(MouseEvent mouseEvent){
        if(this.current instanceof MusicScreen){
            ((MusicScreen) this.current).stopSong();
        }
        GameScreen gameScreen = new GameScreen(this.current.getTheme());
        MusicScreen musicScreen = (MusicScreen) gameScreen;
        musicScreen.playSong();
        this.stage.setScene(gameScreen.getScene(this.stage));
    }
    @Override
    public String toString(){
        return "StarterEvent";
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
        StarterEvent starterEvent = (StarterEvent) other;
        return this.current.equals(starterEvent.getCurrent()) && this.stage.equals(starterEvent.getStage());
    }
    @Override
    public int hashCode(){
        return Objects.hash(this.current, this.stage);
    }

}
