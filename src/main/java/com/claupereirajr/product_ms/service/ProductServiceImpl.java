package com.claupereirajr.product_ms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claupereirajr.product_ms.dto.ProductDto;
import com.claupereirajr.product_ms.model.Product;
import com.claupereirajr.product_ms.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Optional<ProductDto> create(ProductDto request) {
        Product product = mapper.map(request, Product.class);
        repository.saveAndFlush(product);
        return Optional.of(mapper.map(product, ProductDto.class));
    }
    @Override
    public List<ProductDto> getAll() {
        List<Product> products = repository.findAll();
        List<ProductDto> responses = new ArrayList<>();

        products.forEach(product -> {
            ProductDto response = mapper.map(product, ProductDto.class);
            responses.add(response); 
        });

        return responses;
    }
    @Override
    public Optional<ProductDto> getById(Long id) {
        Optional<Product> product = repository.findById(id);
        if (product.isPresent()) {
            return Optional.of(mapper.map(product.get(), ProductDto.class));
        }
        return Optional.empty();
    }
    @Override
    public boolean inactive(Long id) {
        Optional<Product> product = repository.findById(id);
        if (product.isPresent()) {
            product.get().setAvaliable(false);
            return true;
        }
        return false;
    }    
}
