package sample;

import javafx.scene.paint.Color;

public class ColorPack {
    //Class used to produce the many colorful themes of the game.
    //Contains three Color variables that are responsible for the basis of the theme.
    private Color primary;
    private Color secondary;
    private Color tertiary;
    private Color text;
    public ColorPack(Color primary,Color secondary,Color tertiary){
        this.primary=primary;
        this.secondary=secondary;
        this.tertiary=tertiary;
        this.text=primary;
    }
    public Color getPrimary(){return this.primary;}
    public Color getSecondary(){return this.secondary;}
    public Color getTertiary(){return this.tertiary;}
    public void setText(int n){
        if(n==1){this.text=primary;}
        if(n==2){this.text=secondary;}
        if(n==3){this.text=tertiary;}
    }
    public Color getText(){return this.text;}
}
