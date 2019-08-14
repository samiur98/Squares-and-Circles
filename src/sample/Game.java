package sample;

import java.util.Objects;

public class Game implements GameInterface{
    //Class responsible for maintaining the objects and methods associated with the functionality of the game.

    private int score = 0;//Score of a game session.
    private final Player player = new Player(); //The player of the game.
    private final SegmentList segmentList = new SegmentList(); //SegmentList used to keep track of obstacles(Squares).

    public Game(){

    }
    //Getter Functions/Accessor Methods.
    public int getScore(){
        return this.score;
    }
    public Player getPlayer(){
        return this.player;
    }
    public SegmentList getSegmentList(){
        return this.segmentList;
    }

    //Setter Functions/Mutator Methods.
    public void setScore(int score){
        this.score = score;
    }

    public boolean collision() {
        //Method used to detect collisions i.e when player(circle) fails to avoid obstacles(squares).
        //Method returns true if there is a collision, false otherwise.
        Segment segment = this.segmentList.getList()[0];
        int position = this.player.getPosistion();
        return segment.getSquares()[position];
    }

    @Override
    public String toString(){
        return "Game";
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
        Game game = (Game) other;
        return this.player.equals(game.getPlayer()) && this.segmentList.equals(game.getSegmentList());
    }
    @Override
    public int hashCode(){
        return Objects.hash(this.player, this.segmentList);
    }
}
