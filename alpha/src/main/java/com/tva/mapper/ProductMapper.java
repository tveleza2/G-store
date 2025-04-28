package com.tva.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.tva.dto.ProductRequestDTO;
import com.tva.dto.ProductResponseDTO;
import com.tva.entitiy.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "productId", target = "id")
    @Mapping(source = "productName", target = "name")
    @Mapping(source = "productDescription", target = "description")
    ProductResponseDTO productToResponseDTO(Product product);
    
    @Mapping(target = "productId", ignore = true)
    @Mapping(target = "productName", source = "name")
    @Mapping(target = "productDescription", source = "description")
    Product requestDTOToProduct(ProductRequestDTO productRequestDTO);
    
}
