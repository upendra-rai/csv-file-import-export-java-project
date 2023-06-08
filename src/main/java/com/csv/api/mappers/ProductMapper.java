package com.csv.api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.csv.api.dtos.ProductRequestDto;
import com.csv.api.dtos.ProductResponseDto;
import com.csv.api.entities.Product;

//https://mapstruct.org/documentation/installation/
@Mapper(componentModel = "spring")
public interface ProductMapper {

	ProductResponseDto mapToDto(Product product);

	Product mapToEntity(ProductRequestDto productRequestDto);

	Product updateToEntity(ProductRequestDto productRequestDto, @MappingTarget Product product);

}
