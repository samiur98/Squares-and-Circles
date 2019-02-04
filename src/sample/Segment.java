package sample;

import javafx.scene.canvas.Canvas;

import java.util.Random;

public class Segment {
    //Class responsible for "Segments" in the game.
    //Segments are an abstract concept used in the game.
    //Segments contain obstacles(The squares)
    //Segments are imagined to be divided into 3 vertical parts each of which may contain an obstacle
    //A boolean list(squares) is responsible for keeping track of the vertical components of the segment.
    private int indicator;
    private boolean[] squares = new boolean[3];//Boolean list previously mentioned.
    public Segment() {
        generate();
    }

    private void generate() {
        //Helper method used in the constructor.
        //Mainly responsible for assigning obstacles within the segment.
        //Assignment of obstacles is done using the Random class.
        Random random = new Random();
        int number = random.nextInt(7);
        if(number<3){squares[number]=true;}
    }
    public void init(){
        //Removes all obstacles from the segment.
        squares[0]=false;
        squares[1]=false;
        squares[2]=false;
        indicator=0;
    }
        @Override
        public String toString() {
            //toString method of the class(Pretty self explanitory).
            String result = "[";
            if (squares[0]) {
                result = result + "true,";
            } else {
                result = result + "false,";
            }
            if (squares[1]) {
                result = result + "true,";
            } else {
                result = result + "false,";
            }
            if (squares[2]) {
                result = result + "true]";
            } else {
                result = result + "false]";
            }
            return result;
        }
        public boolean[] getSquares() {
        //Returns the "square" of the segment.Read previous comments if this does not make any sense.
        return this.squares;
        }
        public int getIndicator(){
            return this.indicator;
        }
    }

