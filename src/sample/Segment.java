package sample;
import java.util.Arrays;
import java.util.Random;

public class Segment {
    //Class responsible for "Segments" in the game.
    //Segments are an abstract concept used in the game.
    //Segments contain obstacles(The squares)
    //Segments are imagined to be divided into 3 vertical parts each of which may contain an obstacle
    //A boolean array(squares) is responsible for keeping track of the squares in the segment.
    private final boolean[] squares = new boolean[3];//Boolean list previously mentioned.

    public Segment() {
        this.generate();
    }

    //Getter Functions/Accessor Methods.
    public boolean[] getSquares() {
        //Returns the array containing the boolean values that represent the obstacles in a segment.
        return this.squares;
    }

    private void generate() {
        //Helper method used in the constructor.
        //Mainly responsible for assigning obstacles within the segment.
        //Assignment of obstacles is done using the Random class.
        Random random = new Random();
        int number = random.nextInt(7);
        if(number<3){
            squares[number]=true;
        }
    }
    public void init(){
        //Returns a Segment object with no obstacles/squares.
        squares[0]=false;
        squares[1]=false;
        squares[2]=false;
    }
    @Override
    public String toString() {
        String result = "[";
        if (squares[0]) {
            result = result + "true,";
        }
        else {
            result = result + "false,";
        }
        if (squares[1]) {
            result = result + "true,";
        }
        else {
            result = result + "false,";
        }
        if (squares[2]) {
            result = result + "true]";
        }
        else {
            result = result + "false]";
        }
        return result;
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
        Segment segment = (Segment) other;
        return Arrays.equals(this.squares, segment.getSquares());
    }
    @Override
    public int hashCode(){
        return Arrays.hashCode(this.squares);
    }

}

