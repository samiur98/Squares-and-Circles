package sample;

import javafx.scene.paint.Color;

import java.util.Objects;

public class Theme {
    //Class used to produce the many colorful themes of the game.
    //Contains three Color variables that are responsible for the basis of the theme.

    private String name; //Name of the theme.
    private Color primary; //One of the Color Objects contained by the Theme Object.
    private Color secondary; //One of the Color Objects contained by the Theme Object.
    private Color tertiary; //One of the Color Objects contained by the Theme Object.

    public Theme(String name, Color primary, Color secondary, Color tertiary){
        this.name = name;
        this.primary = primary;
        this.secondary = secondary;
        this.tertiary = tertiary;
    }

    //Getter Functions/Accessor Methods.
    public String getName(){
        return this.name;
    }
    public Color getPrimary(){
        return this.primary;
    }
    public Color getSecondary(){
        return this.secondary;
    }
    public Color getTertiary(){
        return this.tertiary;
    }

    //Setter Functions/Mutator Methods.
    public void setName(String name){
        this.name = name;
    }
    public void setPrimary(Color color){
        this.primary = color;
    }
    public void setSecondary(Color color){
        this.secondary = color;
    }
    public void setTertiary(Color color){
        this.tertiary = color;
    }

    @Override
    public String toString(){
        return "Theme: " + this.name;
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
        Theme theme = (Theme) other;
        return this.name.equals(theme.getName()) && this.primary.equals(theme.getPrimary()) &&
                this.secondary.equals(theme.getSecondary()) && this.tertiary.equals(theme.getTertiary());
    }
    @Override
    public int hashCode(){
        return Objects.hash(this.name, this.primary, this.secondary, this.tertiary);
    }
}
