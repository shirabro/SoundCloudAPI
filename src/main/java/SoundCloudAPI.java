import java.util.logging.Level;

public class SoundCloudAPI {

    private String url1;
    private String url2;
    private String url3;
    private APIThread run1;
    private APIThread run2;
    private APIThread run3;
    private Results results;


    public SoundCloudAPI(String url) {
        this.url1 = url;
        this.url2 = "http://api.soundcloud.com/tracks/?q=britney&client_id=pCNN85KHlpoe5K6ZlysWZBEgLJRcftOd";
        this.url3 = "http://api.soundcloud.com/tracks/?q=maroon5&client_id=pCNN85KHlpoe5K6ZlysWZBEgLJRcftOd";
        this.run1 = new APIThread(url1);
        this.run2 = new APIThread(url2);
        this.run3 = new APIThread(url3);
        this.results = new Results();
    }

    public void runRequests() {
        SoundCloudAPILoger.log(Level.INFO, String.format("Search Query: %s", this.url1));
        SoundCloudAPILoger.log(Level.INFO, String.format("Search Query: %s", this.url2));
        SoundCloudAPILoger.log(Level.INFO, String.format("Search Query: %s", this.url3));
        Thread thread1 = new Thread(this.run1);
        Thread thread2 = new Thread(this.run2);
        Thread thread3 = new Thread(this.run3);

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            addToHashMaps(run1.getResults());
            thread2.join();
            addToHashMaps(run2.getResults());
            thread3.join();
            addToHashMaps(run3.getResults());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    private void addToHashMaps(SearchResult[] searchResults){
        for (SearchResult s: searchResults){
            results.addId(s.getId(), s);
            results.addTitle(s.getTitle(), s);
            results.addUrl(s.getUrl(), s);
        }

    }

    public void removeByID(Integer id){
        this.results.removeById(id);
    }

    public void removeByURL(String url){
        this.results.removeByURL(url);

    }
    public void sortByTitle(){
        this.results.sortByTitle();
    }

    public void printResults(){
        this.results.printResults();
    }


}
