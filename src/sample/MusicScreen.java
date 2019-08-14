package sample;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.util.Objects;

public abstract class MusicScreen extends BasicScreen {
    //Abstract class that provides basis for screens with music.

    private String song; //The uri of the song/music.
    private Media media;
    private MediaPlayer player;

    public MusicScreen(Theme theme, String song){
        super(theme);
        try {
            this.song = song;
            media = new Media(getClass().getResource(song).toExternalForm());
            player = new MediaPlayer(media);
        }
        catch (NullPointerException e){
            System.out.println("Provided Song does not exist/cannot be found in " + this.toString());
            System.exit(1);
        }
    }
    //Getter Function/Accessor Methods.
    public String getSong(){
        return this.song;
    }
    public Media getMedia(){
        return this.media;
    }
    public MediaPlayer getMusicPlayer(){
        return this.player;
    }

    //Setter Functions/Mutator Methods.
    public void setSong(String song){
        this.song = song;
    }

    public void playSong(){
        //Method that plays the music/song provided.
        this.player.play();
    }
    public void stopSong(){
        //Method that stops the music/song provided.
        this.player.stop();
    }

    @Override
    public abstract String toString();
    @Override
    public boolean equals(Object other){
        if(!super.equals(other)){
            return false;
        }
        MusicScreen musicScreen = (MusicScreen) other;
        return this.song.equals(musicScreen.getSong()) && this.media.equals(musicScreen.getMedia()) && this.player.equals(musicScreen.getMusicPlayer());
    }
    @Override
    public int hashCode(){
        return (super.hashCode() * 31) + Objects.hash(this.song, this.media, this.player);
    }
}
