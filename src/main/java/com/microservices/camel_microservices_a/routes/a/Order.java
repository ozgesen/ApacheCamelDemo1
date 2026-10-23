package com.microservices.camel_microservices_a.routes.a;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

import java.math.BigDecimal;

@CsvRecord(separator = ";", skipFirstLine = false)
public class Order {

    @DataField(pos = 1, defaultValue = "-")
    private String firstName;
    @DataField(pos = 2, defaultValue = "-")
    private String lastName;
    @DataField(pos = 3, defaultValue = "-")
    private String email;
    @DataField(pos = 4, defaultValue = "-")
    private String item;
    @DataField(pos = 5, defaultValue = "-")
    private String orderId;
    @DataField(pos = 6, defaultValue = "0.0", precision = 2, rounding = "HALF_UP")
    private BigDecimal price;

    public String toString() {
        return "Order{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", item='" + item + '\'' +
                ", orderId='" + orderId + '\'' +
                ", price=" + price +
                '}';
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

