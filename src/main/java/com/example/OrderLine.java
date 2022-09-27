package com.example;

public class OrderLine {
    private int quantity;
    private String productName;
    private String productCode;
    private int productSize;
    private String productVariety;
    private double productPrice;

    @Override
    public String toString() {
        return "OrderLine{" +
                "quantity=" + quantity +
                ", productName='" + productName + '\'' +
                ", productCode='" + productCode + '\'' +
                ", productSize=" + productSize +
                ", productVariety='" + productVariety + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getProductSize() {
        return productSize;
    }

    public void setProductSize(int productSize) {
        this.productSize = productSize;
    }

    public String getProductVariety() {
        return productVariety;
    }

    public void setProductVariety(String productVariety) {
        this.productVariety = productVariety;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
}
