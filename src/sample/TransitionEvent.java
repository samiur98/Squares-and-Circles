package sample;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.Objects;

public class TransitionEvent implements EventHandler<MouseEvent>{
    //Class that provides a means for transition between two Screens.
    private Screen current;
    private Screen next;
    private Stage stage;

    public TransitionEvent(Screen current, Screen next, Stage stage){
        this.current = current;
        this.next = next;
        this.stage = stage;
    }
    //Getter Functions/Accessor Methods.
    public Screen getCurrent(){
        return this.current;
    }
    public Screen getNext(){
        return this.next;
    }
    public Stage getStage(){
        return this.stage;
    }

    //Setter Functions/Mutator Methods.
    public void setCurrent(Screen current){
        this.current = current;
    }
    public void setNext(Screen next){
        this.next = next;
    }
    public void setStage(Stage stage){
        this.stage = stage;
    }

    @Override
    public void handle(MouseEvent mouseEvent){
        if(current instanceof MusicScreen){
            ((MusicScreen) current).stopSong();}
        if(next instanceof MusicScreen){((MusicScreen) next).playSong();}
        stage.setScene(next.getScene(stage));

    }
    @Override
    public String toString(){
        return "TransitionEvent";
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
        TransitionEvent transitionEvent = (TransitionEvent) other;
        return this.current.equals(transitionEvent.getCurrent()) && this.next.equals(transitionEvent.getNext()) &&
               this.stage.equals(transitionEvent.getStage());
    }
    @Override
    public int hashCode(){
        return Objects.hash(this.current, this.next, this.stage);
    }

}
