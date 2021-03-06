package com.neuedu.pojo;

public class Product {
    private int productId;
    private String productName;
    private double price;
    private String productDes;
    private String url;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductDes() {
        return productDes;
    }

    public void setProductDes(String productDes) {
        this.productDes = productDes;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", productDes='" + productDes + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public Product(int productId, String productName, double price, String productDes, String url) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.productDes = productDes;
        this.url = url;
    }

    public Product() {
    }
}
