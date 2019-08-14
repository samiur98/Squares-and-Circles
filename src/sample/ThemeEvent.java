package sample;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.Objects;

public class ThemeEvent implements EventHandler<MouseEvent> {
    //Class that provides a means through which a change in theme occurs.

    private String name;
    private BasicScreen current;
    private Stage stage;

    public ThemeEvent(String name, BasicScreen current, Stage stage){
        this.name = name;
        this.current = current;
        this.stage = stage;
    }
    //Getter Functions/ Accessor Methods.
    public String getName(){
        return this.name;
    }
    public BasicScreen getCurrent(){
        return this.current;
    }
    public Stage getStage(){
        return this.stage;
    }

    //Setter Functions/Mutator Methods.
    public void setName(String name){
        this.name = name;
    }
    public void setCurrent(BasicScreen current){
        this.current = current;
    }
    public void setStage(Stage stage){
        this.stage = stage;
    }

    @Override
    public void handle(MouseEvent mouseEvent){
        Themes themes = new Themes();
        if(themes.contains(this.name)){
            this.current.setTheme(themes.search(this.name));
            Group group = new Group();
            Scene scene = new Scene(group, 500, 500, this.current.getTheme().getSecondary());
            Canvas canvas = new Canvas(500, 500);
            GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
            this.current.setGroup(group);
            this.current.setScene(scene);
            this.current.setCanvas(canvas);
            this.current.setGraphicsContext(graphicsContext);
            this.stage.setScene(this.current.getScene(this.stage));
        }
        else{
            System.out.println("Theme with the provided name does not exist.");
        }
    }

    @Override
    public String toString(){
        return "ThemeEvent";
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
        ThemeEvent themeEvent = (ThemeEvent) other;
        return this.name.equals(themeEvent.getName()) && this.current.equals(themeEvent.getCurrent()) &&
               this.stage.equals(themeEvent.getStage());
    }
    @Override
    public int hashCode(){
        return Objects.hash(this.name, this.current, this.stage);
    }
}
