
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.logging.Level;


public class Results {

    static Hashtable<String, SearchResult> resultByTitle = new Hashtable<String, SearchResult>();
    static Hashtable<String, SearchResult> resultByURL = new Hashtable<String, SearchResult>();
    static Hashtable<Integer, SearchResult> resultByID = new Hashtable<Integer, SearchResult>();

    ArrayList sortedList;

    public void sortByTitle(){
        resultByTitle.keySet();
        sortedList = new ArrayList(resultByTitle.keySet());
        Collections.sort(sortedList);
    }

    public void printResults(){
        for (int i = 0; i < sortedList.size(); i++) {
            SoundCloudAPILoger.log(Level.INFO, resultByTitle.get(sortedList.get(i)).toString());
        }
    }

    public void removeById (Integer id){
        SearchResult sr = resultByID.remove(id);
        resultByURL.remove(sr.getUrl());
        resultByTitle.remove(sr.getTitle());
    }

    public void removeByURL (String url){
        SearchResult sr = resultByURL.remove(url);
        resultByID.remove(sr.getId());
        resultByTitle.remove(sr.getTitle());
    }


}
