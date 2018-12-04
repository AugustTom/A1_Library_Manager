package tawelib;
import java.util.ArrayList;

public class Laptop extends Resources {
    protected String manufacturer;
    protected String model;
    protected String operatingSystem;

    public Laptop (int id, String title, int year, String imageID, ArrayList<Integer> copies,
                   String manufacturer, String model, String operatingSystem){
        super(id, title, year, imageID, copies);
        this.manufacturer = manufacturer;
        this.model = model;
        this.operatingSystem = operatingSystem;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }
}