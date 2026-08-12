package org.lesson2_3;

public class Product {
    public String name;
    public String productionDate;
    public String manufacturer;
    public String country;
    public int price;
    public boolean reservationStatus;

    public Product(String name, String productionDate, String manufacturer, String country, int price, boolean reservationStatus) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.country = country;
        this.price = price;
        this.reservationStatus = reservationStatus;
    }

}
