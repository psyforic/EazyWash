package com.example.eazywash.models;

import com.example.eazywash.R;

public class Order {


    private String OrderType;
    private String OderNumber;
    private String Delivery;
    private double Price;
    private String DateTime;
    private int DeliveryStatus;
    private int OrderStatus;
    private boolean selected;

    public Order() {
    }

    public Order(String oderNumber, String delivery, double price, String dateTime, int deliveryStatus, int orderstatus) {
        OderNumber = oderNumber;
        Delivery = delivery;
        Price = price;
        DateTime = dateTime;
        DeliveryStatus = deliveryStatus;
        OrderStatus = orderstatus;
    }

    public Order(String oderNumber, String delivery, double price, String dateTime, int deliveryStatus) {
        OderNumber = oderNumber;
        Delivery = delivery;
        Price = price;
        DateTime = dateTime;
        DeliveryStatus = deliveryStatus;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    public int getOrderStatus() {
        return OrderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        OrderStatus = orderStatus;
    }

    public int getDeliveryStatus() {
        return DeliveryStatus;
    }

    public void setDeliveryStatus(int deliveryStatus) {
        DeliveryStatus = deliveryStatus;
    }

    public String getOderNumber() {
        return OderNumber;
    }

    public void setOderNumber(String oderNumber) {
        OderNumber = oderNumber;
    }

    public String getDelivery() {
        return Delivery;
    }

    public void setDelivery(String delivery) {
        Delivery = delivery;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public String getOrderType() {
        return OrderType;
    }

    public void setOrderType(String orderType) {
        OrderType = orderType;
    }
}
