package com.example.tauliaproject.domain;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "buyerEntities")
@XmlAccessorType(XmlAccessType.FIELD)
public class BuyerEntities
{
    @XmlElement(name = "buyerEntity")
    private List<BuyerEntity> buyerEntities = null;

    public List<BuyerEntity> getEmployees() {
        return buyerEntities;
    }

    public void setEmployees(List<BuyerEntity> buyerEntities) {
        this.buyerEntities = buyerEntities;
    }
}
