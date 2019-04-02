package org.myproject.invoicesystem.entities.Enums;

public enum Vat {
    ZERO (0),
    TEN(10),
    TWENTY(20);


    public final int quantity;

    Vat(int q) {
        this.quantity = q;
    }

    public int getQuantity() { return this.quantity; }
}

