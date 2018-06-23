
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {


    static Logger logger = Logger.getLogger(Main.class.getName());


    public static void main(String[] args) {
        String url1 = "http://api.soundcloud.com/tracks/?q=pixes&client_id=pCNN85KHlpoe5K6ZlysWZBEgLJRcftOd";
        String url2 = "http://api.soundcloud.com/tracks/?q=britney&client_id=pCNN85KHlpoe5K6ZlysWZBEgLJRcftOd";
        String url3 = "http://api.soundcloud.com/tracks/?q=maroon5&client_id=pCNN85KHlpoe5K6ZlysWZBEgLJRcftOd";

        APIThread th1 = new APIThread(url1);
        APIThread th2 = new APIThread(url2);
        APIThread th3 = new APIThread(url3);

        th1.run();
        th2.run();
        th3.run();

        Results result = new Results();
        result.removeById(new Integer(79356931));
        result.removeByURL("https://soundcloud.com/silly-hats-man/where-is-my-mind-the-pixes");
        result.removeByURL("https://soundcloud.com/laura-guerrero/britney-spears-toxic");
        result.sortByTitle();
        result.printResults();

    }




}
