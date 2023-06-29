package com.hilalsolak.ecommercespring.repository;

import com.hilalsolak.ecommercespring.model.Category;
import com.hilalsolak.ecommercespring.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InvoiceRepository extends JpaRepository<Invoice, UUID> {

}
