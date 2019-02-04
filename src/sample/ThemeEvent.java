package sample;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ThemeEvent {
    //Class that has static method that handles a theme change.
    public static EventHandler<MouseEvent> action(String name, BasicScreen current, Stage stage){
        Themes database=new Themes();
        if(database.contains(name)){
            EventHandler<MouseEvent> theme_event=new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    current.setTheme(database.search(name));
                    Group group=new Group();
                    Scene scene=new Scene(group,500,500,current.getTheme().getSecondary());
                    Canvas canvas=new Canvas(500,500);
                    GraphicsContext graphicsContext=canvas.getGraphicsContext2D();
                    current.setGroup(group);
                    current.setScene(scene);
                    current.setCanvas(canvas);
                    current.setGraphicsContext(graphicsContext);
                    stage.setScene(current.getScene(stage));
                    
                }
            };
            return theme_event;
        }
        else{
            System.out.println("Theme does not exist");//Exits if theme does not exist
            return ExitEvent.exit();
        }
    }
}
