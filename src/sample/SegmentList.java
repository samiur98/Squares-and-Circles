package sample;

import java.util.Arrays;

public class SegmentList {
    //Class which contains "Segment" objects as data.
    //Used in the animation of the game and for storing Segment Objects.

    private final Segment[] data = new Segment[5];//Array of segments

    public SegmentList(){
        data[0] = new Segment();
        data[0].init();
        data[1] = new Segment();
        data[1].init();
        data[2] = new Segment();
        data[3] = new Segment();
        data[4] = new Segment();
    }
    public void update(){
        //Method responsible for the animation of the game.
        //Assigns each respective "Segment" variable within the data to the value of the next variable.
        //Last variable of the "data" array is assigned to a new Segment class.
        data[0] = data[1];
        data[1] = data[2];
        data[2] = data[3];
        data[3] = data[4];
        data[4] = new Segment();
    }
    public Segment[] getList(){
        //Returns the data array.
        return this.data;
    }
    @Override
    public String toString(){
        return "[" + data[0].toString() + "," + data[1].toString() + "," + data[2].toString() + "," + data[3].toString()
                + "," + data[4].toString() + "]";
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
        SegmentList segmentList = (SegmentList) other;
        return Arrays.equals(this.data, segmentList.getList());
    }
    @Override
    public int hashCode(){
        return Arrays.hashCode(this.data);
    }
}
