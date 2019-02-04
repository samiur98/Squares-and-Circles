package sample;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ExitEvent {
    //Class that has static methods that handle exiting/quitting/closing the game.
    public static EventHandler<MouseEvent> exit() {
        EventHandler<MouseEvent> quit_event = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.exit(1);
            }
        };
        return quit_event;
    }

    public static EventHandler<MouseEvent> exit(int code) {
            EventHandler<MouseEvent> quit_event = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    System.exit(code);
                }
            };
            return quit_event;
        }

    }
