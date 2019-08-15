package com.wadektech.el_muzarae.pojos;

import android.os.Parcel;
import android.os.Parcelable;

public class Products implements Parcelable {
    private int productImage ;
    private String productName ;
    private double productPrice ;

    public Products() {
    }

    public Products(int productImage, String productName, double productPrice) {
        this.productImage = productImage;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    protected Products(Parcel in) {
        productImage = in.readInt();
        productName = in.readString();
        productPrice = in.readDouble();
    }

    public static final Creator<Products> CREATOR = new Creator<Products>() {
        @Override
        public Products createFromParcel(Parcel in) {
            return new Products(in);
        }

        @Override
        public Products[] newArray(int size) {
            return new Products[size];
        }
    };

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(productImage);
        parcel.writeString(productName);
        parcel.writeDouble(productPrice);
    }
}
