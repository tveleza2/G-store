package com.tva.application.service;
import com.tva.domain.entity.Product;
import com.tva.domain.exception.InvalidProductException;
import com.tva.dto.ProductRequestDTO;
import com.tva.dto.ProductResponseDTO;
import com.tva.infrastructure.persistence.mapper.ProductMapper;
import com.tva.infrastructure.persistence.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    @Transactional
    public void createProduct(ProductRequestDTO productDTO) throws InvalidProductException{
        validateProduct(productDTO);
        Product newProduct = productMapper.requestDTOToProduct(productDTO);
        productRepository.save(newProduct);
    }

    @Transactional(readOnly = true)
    public ProductResponseDTO readProduct(UUID id) throws InvalidProductException{
        // validateProduct(productDTO);
        Optional<Product> posibleProduct = productRepository.findById(id);
        if (posibleProduct.isPresent()) {
            return productMapper.productToResponseDTO(posibleProduct.get());
        }
        throw new InvalidProductException("There are no product with the id: "+id.toString());
    }

    @Transactional(readOnly = true)
    public List<ProductResponseDTO> readAllProducts() throws InvalidProductException{
        // validateProduct(productDTO);
        List<Product> productsList = productRepository.findAll();
        if (!productsList.isEmpty()) {
            return productsList.stream()
            .map(productMapper::productToResponseDTO)
            .collect(Collectors.toList());
        }
        throw new InvalidProductException("There are no products registered.");
    }

    @Transactional
    public void updateProduct(ProductRequestDTO productDTO) throws InvalidProductException{
        validateProduct(productDTO);
        Optional<Product> possibleProduct = productRepository.findById(productDTO.getId());
        if (possibleProduct.isPresent()) {
            Product newProduct = productMapper.requestDTOToProduct(productDTO);
            productRepository.save(newProduct);
        }
        throw new InvalidProductException("There are no products registered with the id: "+productDTO.getId());
    }

    @Transactional
    public void deleteProduct(UUID id){
        Optional<Product> possibleProduct = productRepository.findById(id);
        if (possibleProduct.isPresent()) {
            productRepository.deleteById(id);
        }
    }

    @Transactional
    public void toogleActivateProduct(UUID id){
        Optional<Product> possibleProduct = productRepository.findById(id);
        if (possibleProduct.isPresent()) {
            Product updatedProduct = possibleProduct.get();
            updatedProduct.setActive(!updatedProduct.isActive());
            productRepository.save(updatedProduct);
        }
    }

    public void validateProduct(ProductRequestDTO productDTO) throws InvalidProductException{

        if(productDTO.getName() == null || productDTO.getName().isEmpty()){
            throw new InvalidProductException("The name can not be empty");
        }
        if(productDTO.getQuantity()<0){
            throw new InvalidProductException("There can not be less than 0 "+productDTO.getName());
        }

    }


}
