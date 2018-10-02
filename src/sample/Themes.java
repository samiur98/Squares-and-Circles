package sample;

import javafx.scene.paint.Color;

public class Themes {
    //Class responsible for storing the themes used in the game
    public Themes(){
    }
    public static ColorPack[] getThemes(){
        ColorPack[] my_themes=new ColorPack[8];
        ColorPack ecstasy=new ColorPack(Color.rgb(249,107,79),Color.rgb(255,0,0),Color.rgb(255,102,0));
        my_themes[0]=ecstasy;
        ColorPack winter=new ColorPack(Color.rgb(240,240,255),Color.rgb(32,26,30),Color.rgb(51,50,88,0.7));
        my_themes[1]=winter;
        ColorPack rio=new ColorPack(Color.rgb(40,120,40),Color.rgb(0,40,0),Color.rgb(247,255,0));
        my_themes[2]=rio;
        ColorPack nautica=new ColorPack(Color.rgb(0,159,249),Color.rgb(0,50,125),Color.rgb(2,84,168));
        my_themes[3]=nautica;
        ColorPack midnight=new ColorPack(Color.rgb(240,4,99),Color.rgb(50,6,70),Color.rgb(32,7,21,0.5));
        my_themes[4]=midnight;
        //Color.rgb(250,75,151)
        ColorPack panther=new ColorPack(Color.rgb(247,3,50),Color.rgb(255,100,100),Color.rgb(247,3,109));
        my_themes[5]=panther;
        ColorPack cola=new ColorPack(Color.rgb(255,250,250),Color.rgb(150,0,0),Color.rgb(255,0,0));
        my_themes[6]=cola;
        ColorPack turtle=new ColorPack(Color.rgb(0,190,121),Color.rgb(0,50,50),Color.rgb(30,150,70));
        my_themes[7]=turtle;
        return my_themes;
    }
}
