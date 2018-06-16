import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.util.Random;

public class Music {
    public Music() {
        Random shuffle = new Random();
        Media song1 = new Media("UserInterface/Music/song_1");
        Media song2 = new Media("UserInterface/Music/song_2");
        Media song3 = new Media("UserInterface/Music/song_3");
        Media song4 = new Media("UserInterface/Music/song_4");
        Media song5 = new Media("UserInterface/Music/song_5");

        MediaPlayer songs1 = new MediaPlayer(song1);
        MediaPlayer songs2 = new MediaPlayer(song2);
        MediaPlayer songs3 = new MediaPlayer(song3);
        MediaPlayer songs4 = new MediaPlayer(song4);
        MediaPlayer songs5 = new MediaPlayer(song5);

        songs1.setAutoPlay(true);
        songs1.setVolume(25);

    }
}
