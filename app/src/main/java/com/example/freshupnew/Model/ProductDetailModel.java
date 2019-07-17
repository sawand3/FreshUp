package com.example.freshupnew.Model;

public class ProductDetailModel {
    int image;
    String productName;
    String productDetail;
    String productPrice;

    public ProductDetailModel(int image, String productName, String productDetail, String productPrice) {
        this.image = image;
        this.productName = productName;
        this.productDetail = productDetail;
        this.productPrice = productPrice;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(String productDetail) {
        this.productDetail = productDetail;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
}
