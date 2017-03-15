package com.example.nikki.plunochecker;

/**
 * Created by Nikki on 15/3/17.
 */
public class Fresh {
    private String brand;
    private String ProductName;
    private String sku;
    private String plu;

    public Fresh (String brand, String Productname, String sku, String plu) {
        this.brand = brand;
        this.ProductName = Productname;
        this.sku = sku;
        this.plu = plu;

    }

    public Fresh() {

    }

    public String getBrand () {return brand;}

    public void setBrand(String brand) {this.brand = brand;}

    public String getProductName () {return ProductName;}

    public void setProductName(String ProductName) {this.ProductName = ProductName;}

    public String getSKU() {return sku;}

    public void setSKU (String sku) {this.sku = sku;}

    public String getPLU() {return plu;}

    public void setPLU (String plu) {this.plu = plu;}


    public int setPLU() {
        return 0;
    }

    public int setSKU() {
        return 0;
    }
}