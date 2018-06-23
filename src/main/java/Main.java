
import java.util.logging.Logger;

public class Main {


    static Logger logger = Logger.getLogger(Main.class.getName());


    public static void main(String[] args) {
        String url1 = "http://api.soundcloud.com/tracks/?q=pixes&client_id=pCNN85KHlpoe5K6ZlysWZBEgLJRcftOd";
        SoundCloudAPI api = new SoundCloudAPI(url1);
        api.runRequests();

        api.removeByID(new Integer(79356931));
        api.removeByURL("https://soundcloud.com/silly-hats-man/where-is-my-mind-the-pixes");
        api.removeByURL("https://soundcloud.com/laura-guerrero/britney-spears-toxic");
        api.sortByTitle();
        api.printResults();

    }




}
