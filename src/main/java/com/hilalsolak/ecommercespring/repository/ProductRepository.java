package com.hilalsolak.ecommercespring.repository;

import com.hilalsolak.ecommercespring.model.Category;
import com.hilalsolak.ecommercespring.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

}
