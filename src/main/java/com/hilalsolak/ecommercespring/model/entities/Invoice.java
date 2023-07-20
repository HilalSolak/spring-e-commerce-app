package com.hilalsolak.ecommercespring.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
@Entity
public class Invoice extends BaseModel {
    private String description;
    @OneToOne
    private Sale sale;

    public Invoice() {
    }

    public Invoice(String description, Sale sale) {
        this.description = description;
        this.sale = sale;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }
}
