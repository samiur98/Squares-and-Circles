package sample;

import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Themes {
    //Class responsible for storing the themes used in the game
    private ArrayList<ColorPack> themes=new ArrayList();
    public Themes(){
        //Constructor method.
        //The following are the default themes.
        themes.add(new ColorPack("ecstasy",Color.rgb(249,107,79),Color.rgb(255,0,0),Color.rgb(255,102,0)));
        themes.add(new ColorPack("winter",Color.rgb(240,240,255),Color.rgb(32,26,30),Color.rgb(51,50,88,0.7)));
        themes.add((new ColorPack("rio",Color.rgb(40,120,40),Color.rgb(0,40,0),Color.rgb(247,255,0))));
        themes.add(new ColorPack("nautica",Color.rgb(0,159,249),Color.rgb(0,50,125),Color.rgb(2,84,168)));
        themes.add(new ColorPack("midnight",Color.rgb(240,4,99),Color.rgb(50,6,70),Color.rgb(32,7,21,0.5)));
        themes.add(new ColorPack("panther",Color.rgb(247,3,50),Color.rgb(255,100,100),Color.rgb(247,3,109)));
        themes.add(new ColorPack("cola",Color.rgb(255,250,250),Color.rgb(150,0,0),Color.rgb(255,0,0)));
        themes.add(new ColorPack("turtle",Color.rgb(0,190,121),Color.rgb(0,50,50),Color.rgb(30,150,70)));
    }
    public ArrayList<ColorPack> getThemes(){
        //Method that returns an array-list conataining all the themes.
        return this.themes;
    }
    public void addTheme(ColorPack c){
        //Method used to add new themes.
        themes.add(c);
    }
    public boolean contains(String name){
        for (ColorPack c:themes){
            if (c.getName().equals(name)){
                return true;
            }
        }
        return false;
    }
    public ColorPack search(String name){
        if(contains(name)) {
            for (ColorPack c : themes) {
                if (c.getName().equals(name)) {
                    return c;
                }
            }
        }
        else{
            System.out.println("THEME DOES NOT EXIST");
            System.exit(2);
        }
        return themes.get(0);
    }

}
