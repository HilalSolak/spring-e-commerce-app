package com.hilalsolak.ecommercespring.repository;

import com.hilalsolak.ecommercespring.model.entities.Logger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LoggerRepository extends JpaRepository<Logger, UUID> {
}
