package tawelib;
import javafx.beans.property.SimpleIntegerProperty;

import javafx.beans.property.SimpleStringProperty;

public class DVD extends Resources {
    protected SimpleStringProperty director;
    protected SimpleIntegerProperty runtime;
    protected SimpleStringProperty languages;
    protected SimpleStringProperty subtitleLanguages;

    public DVD(int id, String title, int year, String thumbnailImageID, int loanDuration, int numberOfCopies,
               int availableCopies, int borrowedCopies, String director, int runtime, String languages,
               String subtitleLanguages) {
        super(id, title, year, thumbnailImageID, loanDuration, numberOfCopies, availableCopies, borrowedCopies);
        this.director = new SimpleStringProperty(director);
        this.runtime = new SimpleIntegerProperty(runtime);
        this.languages = new SimpleStringProperty(languages);
        this.subtitleLanguages = new SimpleStringProperty(subtitleLanguages);
    }

    public String getDirector() {
        return director.get();
    }

    public SimpleStringProperty directorProperty() {
        return director;
    }

    public void setDirector(String director) {
        this.director.set(director);
    }

    public int getRuntime() {
        return runtime.get();
    }

    public SimpleIntegerProperty runtimeProperty() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime.set(runtime);
    }

    public String getLanguages() {
        return languages.get();
    }

    public SimpleStringProperty languagesProperty() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages.set(languages);
    }

    public String getSubtitleLanguages() {
        return subtitleLanguages.get();
    }

    public SimpleStringProperty subtitleLanguagesProperty() {
        return subtitleLanguages;
    }

    public void setSubtitleLanguages(String subtitleLanguages) {
        this.subtitleLanguages.set(subtitleLanguages);
    }
}
