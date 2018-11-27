/**
 *
 */

import java.util.ArrayList;

public class DVD extends Resources {
    protected String director;
    protected int runtime;
    protected String languages;
    ArrayList<String> subtitleLanguages = new ArrayList<String>();

    public DVD (int id, String title, int year, String thumbnailImageID, int loanDuration, int numberOfCopies,
                 String director, int runtime, String languages){
        super(id, title, year, thumbnailImageID, loanDuration, numberOfCopies);
        this.director = director;
        this.runtime = runtime;
        this.languages = languages;
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

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public ArrayList<String> getSubtitleLanguages() {
        return subtitleLanguages;
    }

    public void setSubtitleLanguages(ArrayList<String> subtitleLanguages) {
        this.subtitleLanguages = subtitleLanguages;
    }
}
