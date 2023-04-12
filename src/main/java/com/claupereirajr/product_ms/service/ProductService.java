package com.claupereirajr.product_ms.service;

import java.util.Optional;
import java.util.List;

import com.claupereirajr.product_ms.dto.ProductDto;

public interface ProductService {
    Optional<ProductDto> create(ProductDto request);
    
    List<ProductDto> getAll();

    Optional<ProductDto> getById(Long id);

    boolean inactive(Long id);
}
