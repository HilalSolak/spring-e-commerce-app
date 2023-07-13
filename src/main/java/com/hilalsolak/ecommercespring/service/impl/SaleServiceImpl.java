package com.hilalsolak.ecommercespring.service.impl;

import com.hilalsolak.ecommercespring.constants.GlobalConstants;
import com.hilalsolak.ecommercespring.dto.requests.InvoiceRequest;
import com.hilalsolak.ecommercespring.dto.requests.SaleRequest;
import com.hilalsolak.ecommercespring.dto.responses.ProductResponse;
import com.hilalsolak.ecommercespring.dto.responses.SaleResponse;
import com.hilalsolak.ecommercespring.exception.EntityNotFoundException;
import com.hilalsolak.ecommercespring.model.Product;
import com.hilalsolak.ecommercespring.model.Sale;
import com.hilalsolak.ecommercespring.repository.SaleRepository;
import com.hilalsolak.ecommercespring.service.InvoiceService;
import com.hilalsolak.ecommercespring.service.PaymentService;
import com.hilalsolak.ecommercespring.service.ProductService;
import com.hilalsolak.ecommercespring.service.SaleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class SaleServiceImpl implements SaleService {

    private final SaleRepository repository;
    private final PaymentService paymentService;
    private final InvoiceService invoiceService;
    private final ProductService productService;

    public SaleServiceImpl(SaleRepository repository, PaymentService paymentService, InvoiceService invoiceService, ProductService productService) {
        this.repository = repository;
        this.paymentService = paymentService;
        this.invoiceService = invoiceService;
        this.productService = productService;
    }

    @Override
    public List<SaleResponse> getAllSales() {
        List<SaleResponse> response = repository.findAll().stream().map(SaleResponse::convert).toList();

        return response;
    }

    @Override
    public SaleResponse getSaleById(UUID id) {
        Sale sale = getSaleByIdInRepository(id);
        SaleResponse response = SaleResponse.convert(sale);

        return response;
    }


    @Override
    public SaleResponse createSale(SaleRequest request) {
        paymentService.paymentProcess(request.paymentRequest(),request.totalPrice());

        Sale sale = new Sale();
        fillSaleFeatures(sale,request);
        SaleResponse response = SaleResponse.convert(repository.save(sale));

        InvoiceRequest invoiceRequest = new InvoiceRequest(response.id(),response.description());
        invoiceService.createInvoice(invoiceRequest);

        return response;
    }



    @Override
    public SaleResponse updateSaleById(UUID id, SaleRequest request) {
        Sale sale = getSaleByIdInRepository(id);
        fillSaleFeatures(sale, request);
        SaleResponse response = SaleResponse.convert(repository.save(sale));
        return response;
    }

    @Override
    public void deleteSaleById(UUID id) {
        Sale sale = getSaleByIdInRepository(id);
        repository.delete(sale);
    }
    private Sale getSaleByIdInRepository(UUID id) {

        return repository.findById(id).orElseThrow(()->new EntityNotFoundException(GlobalConstants.SALE_NOT_FOUND));
    }
    private void fillSaleFeatures(Sale sale, SaleRequest request) {
        sale.setDescription(request.description());
        sale.setTotalPrice(request.totalPrice());

        List<ProductResponse> response = request.products().stream().map(productService::getProductById).toList();

        response.forEach(productResponse->{
            Product product = new Product();
            product.setId(productResponse.id());
            sale.getProducts().add(product);
        });
    }
}
