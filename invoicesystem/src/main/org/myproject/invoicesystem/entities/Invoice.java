package org.myproject.invoicesystem.entities;

import org.myproject.invoicesystem.entities.PaymentType;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "invoice")
public class Invoice extends BaseEntity {

    private Long invoiceNumber;

    private Company Company;
    private Client Client;
    private LocalDateTime issueDate;
  // private Set<Item> items;
    private PaymentType paymentType;

    public Invoice() {
    }

    public Long getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(Long invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }
    @ManyToOne
    @JoinColumn(name = "company_id")
    public Company getCompany() {
        return Company;
    }

    public void setCompany(Company company) {
        Company = company;
    }

    @ManyToOne
    @JoinColumn(name = "client_id")
    public Client getClient() {
        return Client;
    }

    public void setClient(Client client) {
        Client = client;
    }

    public LocalDateTime getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDateTime issueDate) {
        this.issueDate = issueDate;
    }

//    @OneToMany(mappedBy = "item")
//    public Set<Item> getItems() {
//        return items;
//    }
//
//    public void setItems(Set<Item> items) {
//        this.items = items;
//    }

    @ManyToOne
    @JoinColumn(name = "payment_type_id")
    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }


}
