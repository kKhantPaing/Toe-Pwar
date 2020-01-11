package a2017.group19.samaung.samsungproject.BuyAndSale;

/**
 * Created by Lenovo on 10/29/2017.
 */

public class PriceClass {
    private String name;
    private double price;
PriceClass(String name,double price){
    this.name=name;
    this.price=price;
}
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {

        return name;
    }

    public double getPrice() {
        return price;
    }
}
