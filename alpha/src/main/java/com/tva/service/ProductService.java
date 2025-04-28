package com.tva.service;
import com.tva.dto.ProductRequestDTO;
import com.tva.entitiy.Product;
import com.tva.exceptions.InvalidProductException;
import com.tva.repositories.ProductRepository;
import com.tva.mapper.ProductMapper;

import java.util.UUID;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Transactional
    public void createProduct(ProductRequestDTO productDTO) throws InvalidProductException{
        validateProduct(productDTO);
        Product newProduct = productMapper.requestDTOToProduct(productDTO);
        productRepository.save(newProduct);
    }

    public void validateProduct(ProductRequestDTO productDTO) throws InvalidProductException{
        if (productDTO.id == null) {
            
        }
        if(productDTO.name == null || productDTO.name.isEmpty()){
            throw new InvalidProductException("The name can not be empty");
        }

    }


}
