package com.tva.infrastructure.persistence.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductRequestDTO {
    private UUID id;
    private String name;
    private String description;
    private int quantity;
}
