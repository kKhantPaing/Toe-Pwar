package a2017.group19.samaung.samsungproject.database;

/**
 * Created by Lenovo on 10/22/2017.
 */

public class ShopClass {
    private String shopName, type, phone, address, email;

    ShopClass() {
    }

    public ShopClass(String shopName, String type, String phone, String address, String email) {
        this.shopName = shopName;
        this.type = type;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getShopName() {
        return shopName;
    }

    public String getType() {
        return type;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }
}
