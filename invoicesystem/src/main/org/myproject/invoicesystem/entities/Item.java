package org.myproject.invoicesystem.entities;

import org.myproject.invoicesystem.entities.Enums.Vat;

import javax.persistence.*;

@Entity
public class Item extends BaseEntity{

   private Invoice invoice;

    private String name;

    private String unit;

    private Double quantity;

    private Double netPrice;

    private Double netValue;

    private Double grossValue;

    private Vat Vat;

    public Item() {
    }

    @ManyToOne
    @JoinColumn(name="invoice_id")
    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(Double netPrice) {
        this.netPrice = netPrice;
    }

    public Double getNetValue() {
        return netValue;
    }

    public void setNetValue(Double netValue) {
        this.netValue = netValue;
    }

    public Double getGrossValue() {
        return grossValue;
    }

    public void setGrossValue(Double grossValue) {
        this.grossValue = grossValue;
    }

    @Enumerated
    public Vat getVat() {
        return Vat;
    }

    public void setVat(Vat vat) {
        Vat = vat;
    }
}
