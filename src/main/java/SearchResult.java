import org.json.JSONObject;

public class SearchResult {

    private Integer id;
    private String title;
    private String url;
    private JSONObject user;

    public SearchResult(int id, String title, String url, JSONObject user) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.user = user;
    }

    public String toString(){
        return new StringBuilder()
                .append("{")
                .append(String.format("id: %d, ",id))
                .append(String.format("title: %s, ",title))
                .append(String.format("url: %s, ",url))
                .append(String.format("user: %s ",user.toString()))
                .append("}")
                .toString();
    }

    public String getUrl() {
        return url;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
