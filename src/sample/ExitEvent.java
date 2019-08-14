package sample;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ExitEvent implements EventHandler<MouseEvent> {
    //Class that provides an exit from the game.

    public ExitEvent(){

    }
    @Override
    public void handle(MouseEvent mouseEvent){
        System.exit(0);
    }
    @Override
    public String toString(){
        return "Exitevent";
    }

}
