package tawelib;

import java.util.ArrayList;

/** 
 * This is a subclass of the superclass Resources 
 * <br> 
 * It stores information about a laptop 
 * 
 * 
 * @author Auguste Tomesaviciute
 * @author Ronalyn Lilyanne 
 * @version 1.0 
 * @since 05/12/2018 
 */ 

public class Laptop extends Resources {
    protected String manufacturer;
    protected String model;
    protected String operatingSystem;
    
    /** 
     * This is a laptop constructor that initialises a laptop object 
     * @param id extends from Resouces class - the ID of a laptop 
     * @param title extends from Resouces class - the title of a laptop 
     * @param year extends from Resouces class - the year in which the laptop was released 
     * @param imageID extends from Resouces class - the ID of the image of a laptop 
     * @param copies  extends from Resouces class - the amount of copies of a laptop 
     * @param manufacturer - the manufacturer of a laptop 
     * @param model - the model of a laptop 
     * @param opratingSystem - the operating system of a laptop 
     */ 

    public Laptop (int id, String title, int year, String imageID, ArrayList<Integer> copies,
                   String manufacturer, String model, String operatingSystem){
        super(id, title, year, imageID, copies);
        this.manufacturer = manufacturer;
        this.model = model;
        this.operatingSystem = operatingSystem;
    }
    
    /** 
     * get method for manufacturer 
     * @return manufacturer 
     */ 

    public String getManufacturer() {
        return manufacturer;
    }
    
    /** 
     * set method for manufacturer 
     * @param manufacturer 
     */ 

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    
    /** 
     * get method for model 
     * @return model 
     */ 

    public String getModel() {
        return model;
    }
    
    /** 
     * set method for manufacturer 
     * @param manufacturer 
     */ 

    public void setModel(String model) {
        this.model = model;
    }
    
    /** 
     * get method for operating system 
     * @return opeartingSystem 
     */

    public String getOperatingSystem() {
        return operatingSystem;
    }
    
    /** 
     * set method for manufacturer 
     * @param manufacturer 
     */ 

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }
}
