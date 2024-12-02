
package model;

/**
 *
 * @author JOHN SHADARY
 */
public class Appartment {
    
    
    
    private int appartmentId;
    private String appartmentType;
    private double appartmentPrice;
    private String district;
    private String sector;
    private String city;
    private String appartmentStatus;
 
    
    
    // default constructor

    public Appartment() {
    }

    public Appartment(int appartmentId, String appartmentType, double appartmentPrice, String district, String sector, String city, String appartmentStatus) {
        this.appartmentId = appartmentId;
        this.appartmentType = appartmentType;
        this.appartmentPrice = appartmentPrice;
        this.district = district;
        this.sector = sector;
        this.city = city;
        this.appartmentStatus = appartmentStatus;
    }

    public int getAppartmentId() {
        return appartmentId;
    }

    public void setAppartmentId(int appartmentId) {
        this.appartmentId = appartmentId;
    }

    public String getAppartmentType() {
        return appartmentType;
    }

    public void setAppartmentType(String appartmentType) {
        this.appartmentType = appartmentType;
    }

    public double getAppartmentPrice() {
        return appartmentPrice;
    }

    public void setAppartmentPrice(double appartmentPrice) {
        this.appartmentPrice = appartmentPrice;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAppartmentStatus() {
        return appartmentStatus;
    }

    public void setAppartmentStatus(String appartmentStatus) {
        this.appartmentStatus = appartmentStatus;
    }

    

    
    
    
    
}
