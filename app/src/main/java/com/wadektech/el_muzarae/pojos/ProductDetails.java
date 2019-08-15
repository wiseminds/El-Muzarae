package com.wadektech.el_muzarae.pojos;

public class ProductDetails {
    private int profileImage ;
    private int productImage ;
    private double sellingPrice ;
    private String nameOfProduct ;
    private String nameOfFarmer ;
    private String farmerState ;
    private String farmerCounty ;
    private double productQuantity ;
    private String productDescription ;
    private String farmerPhoneNumber ;

    public ProductDetails() {
    }

    public ProductDetails(int profileImage,int productImage, double sellingPrice, String nameOfProduct, String nameOfFarmer,
                          String farmerState, String farmerCounty, double productQuantity, String productDescription, String farmerPhoneNumber) {
        this.profileImage = profileImage ;
        this.productImage = productImage;
        this.sellingPrice = sellingPrice;
        this.nameOfProduct = nameOfProduct;
        this.nameOfFarmer = nameOfFarmer;
        this.farmerState = farmerState;
        this.farmerCounty = farmerCounty;
        this.productQuantity = productQuantity;
        this.productDescription = productDescription;
        this.farmerPhoneNumber = farmerPhoneNumber ;
    }

    public String getFarmerPhoneNumber() {
        return farmerPhoneNumber;
    }

    public void setFarmerPhoneNumber(String farmerPhoneNumber) {
        this.farmerPhoneNumber = farmerPhoneNumber;
    }

    public int getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(int profileImage) {
        this.profileImage = profileImage;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public String getNameOfFarmer() {
        return nameOfFarmer;
    }

    public void setNameOfFarmer(String nameOfFarmer) {
        this.nameOfFarmer = nameOfFarmer;
    }

    public String getFarmerState() {
        return farmerState;
    }

    public void setFarmerState(String farmerState) {
        this.farmerState = farmerState;
    }

    public String getFarmerCounty() {
        return farmerCounty;
    }

    public void setFarmerCounty(String farmerCounty) {
        this.farmerCounty = farmerCounty;
    }

    public double getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(double productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
}
