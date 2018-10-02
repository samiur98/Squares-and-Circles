package sample;

public class SegmentList {
    //Class which contains "Segment" objects as data.
    //Used in the animation in the game.
    private Segment[] data=new Segment[5];//Array of segments
    public SegmentList(){
        //Default Constructor.
        data[0]=new Segment();
        data[0].init();
        data[1]=new Segment();
        data[1].init();
        data[2]=new Segment();
        data[3]=new Segment();
        data[4]=new Segment();
    }
    public void update(){
        //Method responsible for the animation of the game.
        //Assigns each respective "Segment" variable within the data to the value of the next variable.
        //Last variable of the "data" array is assigned to a new Segment class.
        Segment one=data[1];
        Segment two=data[2];
        Segment three=data[3];
        Segment four=data[4];
        Segment five=new Segment();
        data[0]=one;
        data[1]=two;
        data[2]=three;
        data[3]=four;
        data[4]=five;
    }
    public Segment[] getData(){
        //Returns the "data" array.Read previous comments if this does not make any sense.
        return this.data;
    }
    @Override
    public String toString(){
        //toString method of the class.
        return "["+data[0].toString()+","+data[1].toString()+","+data[2].toString()+","+data[3].toString()+","+data[4].toString()+"]";
    }
}
