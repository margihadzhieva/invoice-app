package org.myproject.invoicesystem.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.concurrent.BlockingQueue;

@Entity
@Table(name = "client")
public class Client extends BaseEntity {

    private String name;

    private String adress;

    private String postcode;

    private String nip;

    private String phone;



    public Client() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
