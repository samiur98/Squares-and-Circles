package sample;

import javafx.scene.paint.Color;
import java.util.HashMap;

public class Themes {
    //Class responsible for storing and providing the themes used in the game.
    private final HashMap<String, Theme> themes = new HashMap<>(); //HashMap where Theme Objects are stored.

    public Themes(){
        //The following are the default themes.
        themes.put("ecstasy", new Theme("ecstasy",Color.rgb(249,107,79),Color.rgb(255,0,0),Color.rgb(255,102,0)));
        themes.put("winter", new Theme("winter",Color.rgb(240,240,255),Color.rgb(32,26,30),Color.rgb(51,50,88,0.7)));
        themes.put("rio", (new Theme("rio",Color.rgb(40,120,40),Color.rgb(0,40,0),Color.rgb(247,255,0))));
        themes.put("nautica", new Theme("nautica",Color.rgb(0,159,249),Color.rgb(0,50,125),Color.rgb(2,84,168)));
        themes.put("midnight", new Theme("midnight",Color.rgb(240,4,99),Color.rgb(50,6,70),Color.rgb(32,7,21,0.5)));
        themes.put("panther", new Theme("panther",Color.rgb(247,3,50),Color.rgb(255,100,100),Color.rgb(247,3,109)));
        themes.put("cola", new Theme("cola",Color.rgb(255,250,250),Color.rgb(150,0,0),Color.rgb(255,0,0)));
        themes.put("turtle", new Theme("turtle",Color.rgb(0,190,121),Color.rgb(0,50,50),Color.rgb(30,150,70)));
    }
    public HashMap<String,Theme> getThemes(){
        //Method that returns a HashMap containing all the themes.
        return this.themes;
    }
    public void addTheme(Theme theme){
        //Method used to add new themes.
        this.themes.put(theme.getName(), theme);
    }
    public boolean contains(String name) {
        //Method that returns true if a Theme whose name is equal to the argument provided, is in the themes HashMap.
        //Method returns false otherwise.
        return this.themes.containsKey(name);
    }

    public Theme search(String name){
        //Method that returns a Theme whose name is equal to the argument provided.
        return this.themes.get(name);
    }

    @Override
    public String toString(){
        return "Themes";
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
        Themes themes = (Themes) other;
        return this.themes.equals(themes.getThemes());
    }
    @Override
    public int hashCode(){
        return this.themes.hashCode();
    }
}
