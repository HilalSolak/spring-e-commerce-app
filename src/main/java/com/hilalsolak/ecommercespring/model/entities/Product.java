package com.hilalsolak.ecommercespring.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;

@Entity
public class Product extends BaseModel{
    private String name;
    private String description;
    private BigDecimal price;
    private int quantity;
    private Integer searchCount;
    @ManyToOne
    private Category category;

    public Product() {
    }


    public Product(String name, String description, BigDecimal price, int quantity, Category category, Integer searchCount) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.searchCount = searchCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getSearchCount() {
        return searchCount;
    }

    public void setSearchCount(Integer searchCount) {
        this.searchCount = searchCount;
    }
}
