package sample;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.util.Objects;

public abstract class BasicScreen implements Screen{
    //Class that provides a blueprint/general properties for Screens in the game.

    private Theme theme;
    private Group group;
    private Scene scene;
    private Canvas canvas;
    private GraphicsContext graphicsContext;

    public BasicScreen(Theme theme){
        this.theme = theme;
        this.group = new Group();
        this.scene = new Scene(group,500,500, getTheme().getSecondary());
        this.canvas = new Canvas(500,500);
        this.graphicsContext = canvas.getGraphicsContext2D();
    }
    //Getter Functions/Accessor Methods.
    public Theme getTheme(){
        return this.theme;
    }
    public Group getGroup(){
        return this.group;
    }
    public Scene getScene(){
        return this.scene;
    };
    public Canvas getCanvas(){
        return this.canvas;
    }
    public GraphicsContext getGraphicsContext(){
        return this.graphicsContext;
    }

    //Setter Function/Mutator Method.
    public void setTheme(Theme theme){
        this.theme = theme;
    }
    public void setGroup(Group group){
        this.group = group;
    }
    public void setScene(Scene scene){
        this.scene = scene;
    }
    public void setCanvas(Canvas canvas){
        this.canvas = canvas;
    }
    public void setGraphicsContext(GraphicsContext graphicsContext){
        this.graphicsContext = graphicsContext;
    }

    @Override
    public abstract String toString();
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
        BasicScreen basicScreen = (BasicScreen) other;
        return this.theme.equals(basicScreen.getTheme()) && this.group.equals(basicScreen.getGroup()) && this.scene.equals(basicScreen.scene) &&
               this.canvas.equals(basicScreen.getCanvas());
    }
    @Override
    public int hashCode(){
        return Objects.hash(this.theme, this.group, this.scene, this.canvas);
    }

}
