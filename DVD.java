import java.util.ArrayList;

public class DVD extends Resources {
    protected String director;
    protected int runtime;
    protected String language;
    protected String[] subtitleLanguages;
    //ArrayList<String> subtitleLanguages = new ArrayList<String>();

    //TODO write function for array to string conversion

    public DVD (int id, String title, int year, String imageID, ArrayList<Integer> copies,
                String director, int runtime, String[] subtitleLanguages, String language){
        super(id, title, year, imageID, copies);
        this.director = director;
        this.runtime = runtime;
        this.language = language;
        this.subtitleLanguages = subtitleLanguages;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String languages) {
        this.language = languages;
    }

    public String getSubtitleLanguages() {
        return String.join(",",this.subtitleLanguages);
    }

    public void setSubtitleLanguages(String[] subtitleLanguages) {
        this.subtitleLanguages = subtitleLanguages;
    }
}