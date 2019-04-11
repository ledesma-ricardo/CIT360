package model;
// Generated Mar 26, 2019 4:38:53 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * SalesDetalil generated by hbm2java
 */
public class SalesDetalil  implements java.io.Serializable {


     private Integer idSale;
     private Client client;
     private Vehicle vehicle;
     private double priceSale;
     private double discount;
     private Date date;

    public SalesDetalil() {
    }

    public SalesDetalil(Client client, Vehicle vehicle, double priceSale, double discount, Date date) {
       this.client = client;
       this.vehicle = vehicle;
       this.priceSale = priceSale;
       this.discount = discount;
       this.date = date;
    }
   
    public Integer getIdSale() {
        return this.idSale;
    }
    
    public void setIdSale(Integer idSale) {
        this.idSale = idSale;
    }
    public Client getClient() {
        return this.client;
    }
    
    public void setClient(Client client) {
        this.client = client;
    }
    public Vehicle getVehicle() {
        return this.vehicle;
    }
    
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public double getPriceSale() {
        return this.priceSale;
    }
    
    public void setPriceSale(double priceSale) {
        this.priceSale = priceSale;
    }
    public double getDiscount() {
        return this.discount;
    }
    
    public void setDiscount(double discount) {
        this.discount = discount;
    }
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }




}

