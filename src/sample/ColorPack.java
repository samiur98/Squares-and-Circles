package sample;

import javafx.scene.paint.Color;

public class ColorPack {
    //Class used to produce the many colorful themes of the game.
    //Contains three Color variables that are responsible for the basis of the theme.
    private String name;
    private Color primary;
    private Color secondary;
    private Color tertiary;
    public ColorPack(String name,Color primary,Color secondary,Color tertiary){
        this.name=name;
        this.primary=primary;
        this.secondary=secondary;
        this.tertiary=tertiary;
    }
    public String getName(){return this.name;}
    public Color getPrimary(){return this.primary;}
    public Color getSecondary(){return this.secondary;}
    public Color getTertiary(){return this.tertiary;}
    public void setName(String name){this.name=name;}
    public void setPrimary(Color c){this.primary=c;}
    public void setSecondary(Color c){this.secondary=c;}
    public void setTertiary(Color c){this.tertiary=c;}
}
