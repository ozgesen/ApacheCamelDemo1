package com.microservices.camel_microservices_a.routes.a;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "Orders")

@XmlAccessorType(XmlAccessType.FIELD)

public class Orders {

    @XmlElement(name = "Order")
    private List<OrderOutput> orders;

    public List<OrderOutput> getOrders() {

        return orders;

    }

    public void setOrders(List<OrderOutput> orders) {

        this.orders = orders;

    }

}

