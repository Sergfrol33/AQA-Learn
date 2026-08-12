package org.lesson2_3;

public class Product {

    private String name;
    private String productionDate;
    private String manufacturer;
    private String country;
    private int price;
    private boolean reservationStatus;

    public Product(String name, String productionDate, String manufacturer, String country, int price, boolean reservationStatus) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.country = country;
        this.price = price;
        this.reservationStatus = reservationStatus;
    }

    public int getPrice() {
        return price;
    }

    public boolean isReservationStatus() {
        return reservationStatus;
    }

    public String getCountry() {
        return country;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getName() {
        return name;
    }

    public String getProductionDate() {
        return productionDate;
    }
}
