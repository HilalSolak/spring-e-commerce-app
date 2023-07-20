package com.hilalsolak.ecommercespring.repository;

import com.hilalsolak.ecommercespring.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

}
