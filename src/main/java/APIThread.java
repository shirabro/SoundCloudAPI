import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.logging.Level;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;


public class APIThread implements Runnable {

    private static final int NUM_OF_RESULT = 10;
    private String url;
    private SearchResult[] searchResults;

    public APIThread(String url) {
        this.url = url;
        this.searchResults = new SearchResult[NUM_OF_RESULT];
    }


    public static JSONArray readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            return new JSONArray(jsonText);
        } finally {
            is.close();
        }
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }


    public void run() {
        JSONObject jsonObject;
        SearchResult sr;
        try {
            JSONArray json = readJsonFromUrl(url);
            SoundCloudAPILoger.log(Level.INFO, String.format("Search Query: %s", url));

            for (int i=0; i< NUM_OF_RESULT; i++){
                jsonObject = (JSONObject)json.get(i);
                String title = jsonObject.getString("title");
                int id = jsonObject.getInt("id");
                String permalink_url = jsonObject.getString("permalink_url");
                JSONObject user = jsonObject.getJSONObject("user");
                sr = new SearchResult(id, title, url , user);
                this.searchResults[i] = sr;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SearchResult[] getResults(){
        return this.searchResults;
    }
}
