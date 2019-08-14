package sample;

import java.util.Objects;

public class Player {
    //Class responsible for the circle(i.e the player) object.

    private int position; //Integer used to determine the vertical position of the player in the game.

    public Player(){
        this.position = 1;
    }
    //Getter Functions/Accessor Methods.
    public int getPosistion(){
        return this.position;
    }

    public void moveUp(){
        //Decreases the position of the circle by a value of 1 unless the circle has a position value of 0.
        //It should not be possible for the circle to have a position value less than 0.
        if(this.position > 0){
            this.position = this.position - 1;
        }
    }
    public void moveDown(){
        //Increases the position of the circle by a value of 1 unless the circle has a position value of 2 or greater.
        //It should not be possible for the circle object to have a position value greater than 2.
        if(this.position < 2){
            this.position = this.position + 1;
        }
    }

    @Override
    public String toString(){
        return "Player";
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
        Player player = (Player) other;
        return this.position == player.getPosistion();
    }
    @Override
    public int hashCode(){
        return Objects.hash(this.position);
    }
}
