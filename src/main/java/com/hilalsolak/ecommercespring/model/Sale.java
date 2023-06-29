package com.hilalsolak.ecommercespring.model;

import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Sale extends BaseModel{
    private String description;
    private BigDecimal totalPrice;
    @OneToMany
    private List<Product> products = new ArrayList<>();
    @OneToOne(mappedBy = "sale")
    private Invoice invoice;

    public Sale() {
    }

    public Sale(String description, BigDecimal totalPrice, List<Product> products, Invoice invoice) {
        this.description = description;
        this.totalPrice = totalPrice;
        this.products = products;
        this.invoice = invoice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
