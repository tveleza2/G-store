package com.tva.infrastructure.web;

import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tva.application.service.ProductService;
import com.tva.dto.ProductRequestDTO;
import com.tva.dto.ProductResponseDTO;

import org.springframework.web.bind.annotation.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final Logger productLog = Logger.getLogger(ProductController.class.getName());

    @GetMapping("/find")
    public ResponseEntity<List<ProductResponseDTO>> findAllProducts(){
        try {
            List<ProductResponseDTO> productDTOList = productService.readAllProducts();
            return ResponseEntity.status(HttpStatus.OK).body(productDTOList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> findProduct(@PathVariable("id") UUID id){
        try {
            ProductResponseDTO productDTO = productService.readProduct(id);
            return ResponseEntity.status(HttpStatus.OK).body(productDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductRequestDTO productRequestDTO){
        try {
            productService.createProduct(productRequestDTO);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            productLog.log(Level.SEVERE, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PatchMapping("/update")
    public ResponseEntity<ProductResponseDTO> updateProduct(@RequestBody ProductRequestDTO productDTO){
        try {
            productService.updateProduct(productDTO);
            return ResponseEntity.status(HttpStatus.OK).build();   
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> deleteProduct(@PathVariable UUID id){
        try {
            productService.deleteProduct(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



}
