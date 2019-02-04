package sample;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public abstract class MusicScreen extends BasicScreen {
    //Abstract class that provides basis for screens with music.
    String song;
    Media media;
    MediaPlayer player;
    public MusicScreen(ColorPack theme,String song){
        super(theme);
        this.song=song;
        media=new Media(getClass().getResource(song).toExternalForm());
        player=new MediaPlayer(media);
    }
    public String getSong(){return this.song;}
    public Media getMedia(){
        return this.media;
    }
    public MediaPlayer getPlayer(){
        return this.player;
    }
    public void setSong(String song){
        this.song=song;
    }
    public void setMedia(Media media){
        this.media=media;
    }
    public void setPlayer(MediaPlayer player){
        this.player=player;
    }
    public void play_song(){
        player.play();
    }
    public void stop_song(){
        player.stop();
    }
}
