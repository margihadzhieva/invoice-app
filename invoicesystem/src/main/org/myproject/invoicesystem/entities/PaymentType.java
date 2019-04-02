package org.myproject.invoicesystem.entities;

import org.myproject.invoicesystem.entities.Enums.Payment;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "payment_type")
public class PaymentType extends BaseEntity {


    private Payment payment;

    public PaymentType() {
    }

    @Enumerated(EnumType.STRING)
    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
