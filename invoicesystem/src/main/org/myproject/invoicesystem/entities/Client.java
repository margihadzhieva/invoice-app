package org.myproject.invoicesystem.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.concurrent.BlockingQueue;

@Entity
@Table(name = "client")
public class Client extends BaseEntity {

    private String name;

    private String address;

    private String postcode;

    private String uic;

    private String phone;


    public Client() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getUic() {
        return uic;
    }

    public void setUic(String uic) {
        this.uic = uic;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}