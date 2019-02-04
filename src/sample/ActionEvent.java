package sample;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ActionEvent {
    //Class that has a static method that handles movement of the player/circle.
    public static EventHandler<KeyEvent> move(GameScreen game){
        EventHandler<KeyEvent> event=new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode().equals(KeyCode.UP)){
                    game.setScore(game.getScore()+2);
                    game.getCircle().moveUp();
                }
                else if(event.getCode().equals(KeyCode.DOWN)){
                    game.setScore(game.getScore()+2);
                    game.getCircle().moveDown();
                }
            }
        };
        return event;
    }
}
