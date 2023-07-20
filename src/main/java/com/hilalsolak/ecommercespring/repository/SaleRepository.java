package com.hilalsolak.ecommercespring.repository;

import com.hilalsolak.ecommercespring.model.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SaleRepository extends JpaRepository<Sale, UUID> {

}
