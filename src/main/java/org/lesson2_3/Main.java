package org.lesson2_3;


public class Main {
    public static void main(String[] args) {
       Product[] products = new Product[5];
        products[0] = new Product(
                "Samsung S25 Ultra",
                "01.02.2025",
                "Samsung Corp.",
                "Korea",
                5599,
                false
        );

        products[1] = new Product(
                "iPhone 16 Pro",
                "15.09.2025",
                "Apple Inc.",
                "USA",
                6299,
                false
        );

        products[2] = new Product(
                "Xiaomi 15",
                "10.01.2025",
                "Xiaomi",
                "China",
                3799,
                true
        );

        products[3] = new Product(
                "Google Pixel 10",
                "20.08.2025",
                "Google",
                "USA",
                4899,
                true
        );

        products[4] = new Product(
                "OnePlus 14",
                "05.03.2025",
                "OnePlus",
                "China",
                4299,
                false
        );
        Park park = new Park();
        park.new Attraction("Карусели", "10:00 - 20:00",200);
        park.getAttractions();
    }
}