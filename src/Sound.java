import java.io.*;
import java.applet.*;
import java.net.*;
public class Sound {
    public URL url;
    public AudioClip ac;
    public int choose;

    public Sound() {
    }

    public void play () {
        File sound = null;

        sound = new File("src/sound/MISSILE_SHOT.wav");

        try {
            url = sound.toURI().toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        ac = Applet.newAudioClip(url);
        ac.play();
    }
}