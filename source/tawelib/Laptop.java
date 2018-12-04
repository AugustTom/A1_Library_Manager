package tawelib;

import javafx.beans.property.SimpleStringProperty;

public class Laptop extends Resources {
    protected SimpleStringProperty manufacturer;
    protected SimpleStringProperty model;
    protected SimpleStringProperty operatingSystem;

    public Laptop (int id, String title, int year, String thumbnailImageID, int loanDuration, int numberOfCopies,
                   int availableCopies, int borrowedCopies, String manufacturer, String model, String operatingSystem){
        super(id, title, year, thumbnailImageID, loanDuration, numberOfCopies, availableCopies, borrowedCopies);
        this.manufacturer = new SimpleStringProperty(manufacturer);
        this.model = new SimpleStringProperty(model);
        this.operatingSystem = new SimpleStringProperty(operatingSystem);
    }

    public String getManufacturer() {
        return manufacturer.get();
    }

    public SimpleStringProperty manufacturerProperty() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer.set(manufacturer);
    }

    public String getModel() {
        return model.get();
    }

    public SimpleStringProperty modelProperty() {
        return model;
    }

    public void setModel(String model) {
        this.model.set(model);
    }

    public String getOperatingSystem() {
        return operatingSystem.get();
    }

    public SimpleStringProperty operatingSystemProperty() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem.set(operatingSystem);
    }
}
