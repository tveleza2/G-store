package com.tva.mapper;

import com.tva.dto.ProductRequestDTO;
import com.tva.dto.ProductResponseDTO;
import com.tva.entitiy.Product;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-28T17:15:23-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.42.0.z20250331-1358, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductResponseDTO productToResponseDTO(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductResponseDTO productResponseDTO = new ProductResponseDTO();

        productResponseDTO.id = product.getProductId();
        productResponseDTO.name = product.getProductName();
        productResponseDTO.description = product.getProductDescription();
        productResponseDTO.quantity = product.getQuantity();

        return productResponseDTO;
    }

    @Override
    public Product requestDTOToProduct(ProductRequestDTO productRequestDTO) {
        if ( productRequestDTO == null ) {
            return null;
        }

        Product product = new Product();

        product.setProductName( productRequestDTO.getName() );
        product.setProductDescription( productRequestDTO.getDescription() );
        product.setQuantity( productRequestDTO.getQuantity() );

        return product;
    }
}
