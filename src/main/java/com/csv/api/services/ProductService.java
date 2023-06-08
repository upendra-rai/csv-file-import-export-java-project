package com.csv.api.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.csv.api.dtos.ProductRequestDto;
import com.csv.api.dtos.ProductResponseDto;

public interface ProductService {

	List<ProductResponseDto> getProducts();

	void createProduct(ProductRequestDto productRequestDto);

	ProductResponseDto getProductById(Integer id);

	void updateProduct(Integer id, ProductRequestDto productRequestDto);

	void deleteProduct(Integer id);

	void importProducts(MultipartFile file);


}
