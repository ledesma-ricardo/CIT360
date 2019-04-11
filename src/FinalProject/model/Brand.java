package model;
// Generated Mar 26, 2019 4:38:53 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Brand generated by RAledesma
 */
public class Brand  implements java.io.Serializable {


     private Integer idbrand;
     private String brand;
     private byte state;
     private Set vehicles = new HashSet(0);

    public Brand() {
    }

	
    public Brand(String brand, byte state) {
        this.brand = brand;
        this.state = state;
    }
    public Brand(String brand, byte state, Set vehicles) {
       this.brand = brand;
       this.state = state;
       this.vehicles = vehicles;
    }
   
    public Integer getIdbrand() {
        return this.idbrand;
    }
    
    public void setIdbrand(Integer idbrand) {
        this.idbrand = idbrand;
    }
    public String getBrand() {
        return this.brand;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public byte getState() {
        return this.state;
    }
    
    public void setState(byte state) {
        this.state = state;
    }
    public Set getVehicles() {
        return this.vehicles;
    }
    
    public void setVehicles(Set vehicles) {
        this.vehicles = vehicles;
    }




}


