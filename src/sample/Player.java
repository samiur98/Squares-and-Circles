package sample;

public class Player {
    //Class responsible for the circle(i.e the player) object.
    private int pos;
    public Player(){
        //Deafault constructor which gives the player an initial position of 1.
        this.pos=1;
    }
    public int getPos(){
        //Returns the current position of the circle
        return this.pos;
    }
    public void moveUp(){
        //Decreses the position of the circle by a value of 1 unless the circle has a position value of 0.
        //It should not be possisble for the circle to have a position value less than 0.
        if(this.pos>0){
            this.pos=this.pos-1;
        }
    }
    public void moveDown(){
        //Increases the position of the circle by a value of 1 unless the circle has a position value of 2 or greater.
        //It should not be possible for the circle object to have a position value greater than 2.
        if(this.pos<2){
            this.pos=this.pos+1;
        }
    }
}
