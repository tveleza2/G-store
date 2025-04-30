package com.tva.infrastructure.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.tva.domain.entity.Product;
import com.tva.infrastructure.persistence.dto.ProductRequestDTO;
import com.tva.infrastructure.persistence.dto.ProductResponseDTO;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "productId", target = "id")
    @Mapping(source = "productName", target = "name")
    @Mapping(source = "productDescription", target = "description")
    ProductResponseDTO productToResponseDTO(Product product);
    
    @Mapping(target = "productId", ignore = true)
    @Mapping(target = "productName", source = "name")
    @Mapping(target = "productDescription", source = "description")
    @Mapping(target="active",ignore = true)
    Product requestDTOToProduct(ProductRequestDTO productRequestDTO);
    
}
