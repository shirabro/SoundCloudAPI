
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.logging.Level;


public class Results {

     Hashtable<String, SearchResult> resultByTitle;
     Hashtable<String, SearchResult> resultByURL;
     Hashtable<Integer, SearchResult> resultByID;

    ArrayList sortedList;

    public Results(){
        this.resultByTitle = new Hashtable<String, SearchResult>();
        this.resultByURL = new Hashtable<String, SearchResult>();
        this.resultByID = new Hashtable<Integer, SearchResult>();

    }

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

    public void addTitle(String title, SearchResult searchResult){
        this.resultByTitle.put(title, searchResult);
    }
    public void addId(Integer id, SearchResult searchResult){
        this.resultByID.put(id, searchResult);
    }
    public void addUrl(String url, SearchResult searchResult){
        this.resultByURL.put(url, searchResult);
    }




}
