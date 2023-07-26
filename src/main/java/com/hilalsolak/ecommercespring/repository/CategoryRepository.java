package com.hilalsolak.ecommercespring.repository;

import com.hilalsolak.ecommercespring.model.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
    boolean existsByName(String name);
    @Query(value = "SELECT * FROM category ORDER BY name ASC", nativeQuery = true)
    List<Category> findAllByNameAsc();
}
