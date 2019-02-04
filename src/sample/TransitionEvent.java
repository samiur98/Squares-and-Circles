package sample;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class TransitionEvent {
    //Class that has static method that transtions between screens.
    public static EventHandler<MouseEvent> action(Screen current, Screen next, Stage stage){
        EventHandler<MouseEvent> trans=new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(current instanceof MusicScreen){
                ((MusicScreen) current).stop_song();}
                if(next instanceof MusicScreen){((MusicScreen) next).play_song();}
                stage.setScene(next.getScene(stage));
            }
        };
        return trans;
    }
}
