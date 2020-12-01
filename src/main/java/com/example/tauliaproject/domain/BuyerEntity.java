package com.example.tauliaproject.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "buyerEntity")
@XmlAccessorType(XmlAccessType.FIELD)
public
class BuyerEntity {

    private String buyer;
    private String imageName;
    private String invoiceImage;
    private String invoiceDueDate;
    private String invoiceNumber;
    private String invoiceAmount;
    private String invoiceCurrency;
    private String invoiceStatus;
    private String supplier;

    public BuyerEntity() {
    }

    public BuyerEntity(String buyer, String imageName, String invoiceDueDate, String invoiceNumber, String invoiceAmount, String invoiceCurrency, String invoiceStatus, String supplier) {
        this.buyer = buyer;
        this.imageName = imageName;
        this.invoiceDueDate = invoiceDueDate;
        this.invoiceNumber = invoiceNumber;
        this.invoiceAmount = invoiceAmount;
        this.invoiceCurrency = invoiceCurrency;
        this.invoiceStatus = invoiceStatus;
        this.supplier = supplier;
    }

    public BuyerEntity(String buyer, String imageName, String invoiceImage, String invoiceDueDate, String invoiceNumber, String invoiceAmount, String invoiceCurrency, String invoiceStatus, String supplier) {
        this.buyer = buyer;
        this.imageName = imageName;
        this.invoiceImage = invoiceImage;
        this.invoiceDueDate = invoiceDueDate;
        this.invoiceNumber = invoiceNumber;
        this.invoiceAmount = invoiceAmount;
        this.invoiceCurrency = invoiceCurrency;
        this.invoiceStatus = invoiceStatus;
        this.supplier = supplier;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getInvoiceImage() {
        return invoiceImage;
    }

    public void setInvoiceImage(String invoiceImage) {
        this.invoiceImage = invoiceImage;
    }

    public String getInvoiceDueDate() {
        return invoiceDueDate;
    }

    public void setInvoiceDueDate(String invoiceDueDate) {
        this.invoiceDueDate = invoiceDueDate;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(String invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public String getInvoiceCurrency() {
        return invoiceCurrency;
    }

    public void setInvoiceCurrency(String invoiceCurrency) {
        this.invoiceCurrency = invoiceCurrency;
    }

    public String getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(String invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String toString() {
        return buyer + ',' + imageName + ',' + invoiceImage + ',' + invoiceDueDate + ',' + invoiceNumber + ',' + invoiceAmount + ',' + invoiceCurrency + ',' + invoiceStatus + ',' + supplier;
    }
}
