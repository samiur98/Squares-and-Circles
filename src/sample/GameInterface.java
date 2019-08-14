package sample;

public interface GameInterface {
    //Interface that must be implemented by any class handling the functionality/mechanics of the game.
    public Player getPlayer();
    public SegmentList getSegmentList();
    public int getScore();
    public void setScore(int score);
    public boolean collision(); //Boolean that must return true if there is a collision, between the player and an obstacle, false otherwise.
}
