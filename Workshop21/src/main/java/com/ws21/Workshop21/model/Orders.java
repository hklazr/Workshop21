package com.ws21.Workshop21.model;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Orders {
    
    private Integer id;
    private Integer customerId;
    private String orderDate;
    private String shippedDate;
    private String shipName;
    private Double shippingFee;


    public static Orders fromSQL(SqlRowSet srs) {
        Orders ord = new Orders();
        // Customers c = new Customers();
        // ord.setC(c);
        ord.setCustomerId(srs.getInt("customer_id"));
        ord.setId(srs.getInt("order_id"));
        ord.setOrderDate(srs.getString("order_date"));
        ord.setShippedDate(srs.getString("shipped_date"));
        ord.setShipName(srs.getString("ship_name"));
        ord.setShippingFee(srs.getDouble("shipping_fee"));
        
        return ord;
        
    }

    public JsonObject toJson() {
        return Json.createObjectBuilder()
                .add("order_id", getId())
                .add("order_date", getOrderDate())
                .add("shipped_date", getShippedDate())
                .add("shipping_fee", getShippingFee())

                .build();
    }


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
    public String getShippedDate() {
        return shippedDate;
    }
    public void setShippedDate(String shippedDate) {
        this.shippedDate = shippedDate;
    }
    public String getShipName() {
        return shipName;
    }
    public void setShipName(String shipName) {
        this.shipName = shipName;
    }
    public Double getShippingFee() {
        return shippingFee;
    }
    public void setShippingFee(Double shippingFee) {
        this.shippingFee = shippingFee;
    }
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Orders [id=" + id + ", customerId=" + customerId + ", orderDate=" + orderDate + ", shippedDate="
                + shippedDate + ", shipName=" + shipName + ", shippingFee=" + shippingFee + "]";
    }

    
}
