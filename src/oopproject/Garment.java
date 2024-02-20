
package oopproject;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Garment {
    
    private int garmentID, garmentSize, garmentUnits;
    private String garmentType, garmentName, garmentColour;
    private double  garmentPrice;

    public Garment(int garmentID, int garmentSize, String garmentType, String garmentName, String garmentColour, int garmentUnits, double garmentPrice) {
        this.garmentID = garmentID;
        this.garmentSize = garmentSize;
        this.garmentType = garmentType;
        this.garmentName = garmentName;
        this.garmentColour = garmentColour;
        this.garmentUnits = garmentUnits;
        this.garmentPrice = garmentPrice;
    }

    Garment() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getGarmentID() {
        return garmentID;
    }

    public void setGarmentID(int garmentID) {
        this.garmentID = garmentID;
    }

    public int getGarmentSize() {
        return garmentSize;
    }

    public void setGarmentSize(int garmentSize) {
        this.garmentSize = garmentSize;
    }

    public String getGarmentType() {
        return garmentType;
    }

    public void setGarmentType(String garmentType) {
        this.garmentType = garmentType;
    }

    public String getGarmentName() {
        return garmentName;
    }

    public void setGarmentName(String garmentName) {
        this.garmentName = garmentName;
    }

    public String getGarmentColour() {
        return garmentColour;
    }

    public void setGarmentColour(String garmentColour) {
        this.garmentColour = garmentColour;
    }

    public int getGarmentUnits() {
        return garmentUnits;
    }

    public void setGarmentUnits(int garmentUnits) {
        this.garmentUnits = garmentUnits;
    }

    public double getGarmentPrice() {
        return garmentPrice;
    }

    public void setGarmentPrice(double garmentPrice) {
        this.garmentPrice = garmentPrice;
    }
    
    
    
}
