package com.claupereirajr.product_ms.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductDto {

    @NotBlank
    private String name;

    @Size(min = 50)    
    private String description;

    @Positive
    private double price;
    
    private boolean avaliable;
}
