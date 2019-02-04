package sample;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public abstract class BasicScreen implements Screen {
    //Abstract class that provides basis for the screens in the game.
    private ColorPack theme;
    private Group group;
    private Scene scene;
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    public BasicScreen(ColorPack theme){
        this.theme=theme;
        this.group=new Group();
        this.scene=new Scene(group,500,500,getTheme().getSecondary());
        this.canvas=new Canvas(500,500);
        this.graphicsContext=canvas.getGraphicsContext2D();
    }
    public ColorPack getTheme(){
        return this.theme;
    }
    public Group getGroup(){
        return this.group;
    }
    public Scene getScene(){
        return this.scene;
    }
    public Canvas getCanvas(){
        return this.canvas;
    }
    public GraphicsContext getGraphicsContext(){
        return this.graphicsContext;
    }
    public void setTheme(ColorPack theme){
        this.theme=theme;
    }
    public void setGroup(Group group){
        this.group=group;
    }
    public void setScene(Scene scene){
        this.scene=scene;
    }
    public void setCanvas(Canvas canvas){
        this.canvas=canvas;
    }
    public void setGraphicsContext(GraphicsContext graphicsContext){
        this.graphicsContext=graphicsContext;
    }

}
