package com.hilalsolak.ecommercespring.repository;

import com.hilalsolak.ecommercespring.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
    boolean existsByName(String name);
}
