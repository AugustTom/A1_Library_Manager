package tawelib;
import java.util.ArrayList;

/**
 * This class is a Sub class of the Resources Super class
 * <br>
 * It stores information on a DVD resource such as director, runtime
 * <br>
 * language and subtitleLanguage.
 *
 *
 *@author Ronalyn Lilyanne
 *@version 1.0
 *@since 04/12/2018
 */

public class DVD extends Resources {
    protected String director;
    protected int runtime;
    protected String language;
    protected String[] subtitleLanguages;
    //ArrayList<String> subtitleLanguages = new ArrayList<String>();

    //TODO write function for array to string conversion
    
    /**
     * This is a DVD constructor and it is needed to initialize an object of DVD
     * @param id extends from resources class - resource ID
     * @param title extends from resources class - resource title
     * @param year extends from resources class - year the resource was made
     * @param imageID extends from resources class - image of the resources ID
     * @param copies extends from resources class - the amount of copies of that resource
     * @param director - the director of the DVD
     * @param runtime - the runtime of the DVD
     * @param subtitleLanguages - the languages for subtitles available
     * @param language - the language of the DVD
     */

    public DVD (int id, String title, int year, String imageID, ArrayList<Integer> copies,
                String director, int runtime, String[] subtitleLanguages, String language){
        super(id, title, year, imageID, copies);
        this.director = director;
        this.runtime = runtime;
        this.language = language;
        this.subtitleLanguages = subtitleLanguages;
    }
    
    /**
     * get method for director
     * @return director
     */

    public String getDirector() {
        return director;
    }
    
    /**
     * set method for director
     * @param director director of the DVD
     */

    public void setDirector(String director) {
        this.director = director;
    }
    
    /**
     * get method for runtime
     * @return runtime
     */

    public int getRuntime() {
        return runtime;
    }
    
    /**
     * set method for runtime
     * @param runtime runtime of the DVD
     */

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }
    
    /**
     * get method for language
     * @return language
     */

    public String getLanguage() {
        return language;
    }
    
    /**
     * set method for Language
     * @param languages languages of the DVD
     */

    public void setLanguage(String languages) {
        this.language = languages;
    }
    
    /**
     * get method for subtitleLanguage
     * @return subtitleLanguage
     */

    public String getSubtitleLanguages() {
        return String.join(",",this.subtitleLanguages);
    }
    
    /**
     * set method for subtitleLanguages
     * @param subtitleLanguages subtitle languages available
     */

    public void setSubtitleLanguages(String[] subtitleLanguages) {
        this.subtitleLanguages = subtitleLanguages;
    }
}
