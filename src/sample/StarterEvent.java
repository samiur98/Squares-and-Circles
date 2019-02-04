package sample;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class StarterEvent {
    //Class with static method that starts the game.
    public static EventHandler<MouseEvent> action(Screen current, Stage stage){
        EventHandler<MouseEvent> trans=new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(current instanceof MusicScreen){((MusicScreen) current).stop_song();}
                GameScreen gameScreen=new GameScreen(current.getTheme());
                MusicScreen musicScreen=(MusicScreen) gameScreen;
                musicScreen.play_song();
                stage.setScene(gameScreen.getScene(stage));
            }
        };
        return trans;
    }
}
