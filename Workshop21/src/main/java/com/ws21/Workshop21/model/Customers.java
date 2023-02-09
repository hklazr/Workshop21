package com.ws21.Workshop21.model;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;
import jakarta.json.JsonObject;


public class Customers {
    
    private Integer id;
    private String firstName;
    private String lastName;
    private String mobilePhone;
    

    public static Customers fromSQL(SqlRowSet srs) {
        Customers cs = new Customers();
        cs.setCustomerId(srs.getInt("id"));
        cs.setFirstName(srs.getString("first_name"));
        cs.setLastName(srs.getString("last_name"));
        cs.setMobilePhone(srs.getString("mobile_phone"));

        return cs;
    }

    public JsonObject toJson() {
        return Json.createObjectBuilder()
                .add("id", getCustomerId())
                .add("firstName", getFirstName())
                .add("lastName", getLastName())
                // mobile phone might be null
                // JsonObject value cannot be java.null
                .add("mobilePhone", (null == getMobilePhone()) ? "Null" : getMobilePhone())
                // .add("mobilePhone", getMobilePhone())
                .build();

                // check if mobile phone is null
                // if not null. return mobile phone
                // if null, return "Null"
                // (condition) ? value_if_true : value_if_false
                // (null == getMobilePhone()) ? "Null" : getMobilePhone();

                // JsonObjectBuilder builder = Json.createObjectBuilder();

                // builder.add("id", getId());
                // builder.add("firstName", getFirstName());
                // builder.add("lastName", getLastName());

                // if (getMobilePhone() != null) {
                //     builder.add("mobilePhone", getMobilePhone());
                // } else {
                //     builder.addNull("mobilePhone");
                // }
                
                // return builder.build();

    }

    @Override
    public String toString() {
        return "Customers [id=" + id + "firstName=" + firstName + ", lastName=" + lastName + ", mobilePhone=" + mobilePhone + "]";

    }



    public Integer getCustomerId() {
        return id;
    }
    public void setCustomerId(Integer id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getMobilePhone() {
        return mobilePhone;
    }
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    
    }

