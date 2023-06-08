package com.csv.api.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import com.opencsv.bean.CsvToBeanBuilder;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.csv.api.dtos.ProductRequestDto;
import com.csv.api.dtos.ProductResponseDto;
import com.csv.api.entities.Product;
import com.csv.api.mappers.ProductMapper;
import com.csv.api.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductMapper productMapper;

	@Override
	public List<ProductResponseDto> getProducts() {
		return productRepository.findAll().stream().map(productMapper::mapToDto).collect(Collectors.toList());
	}

	@Override
	public void createProduct(ProductRequestDto productRequestDto) {
		productRepository.save(productMapper.mapToEntity(productRequestDto));
	}

	@Override
	public ProductResponseDto getProductById(Integer id) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Product Id Not Found"));
		return productMapper.mapToDto(product);
	}

	@Override
	@Transactional
	public void updateProduct(Integer id, ProductRequestDto productRequestDto) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Product Id Not Found"));
		productMapper.updateToEntity(productRequestDto, product);
	}

	@Override
	public void deleteProduct(Integer id) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Product Id Not Found"));
		productRepository.delete(product);
	}

	@Override
	public void importProducts(MultipartFile file) {
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file.getInputStream()));
			List<ProductRequestDto> products = new CsvToBeanBuilder<ProductRequestDto>(bufferedReader)
					.withType(ProductRequestDto.class).withSkipLines(1).build().parse();
			products.forEach(product -> {
				productRepository.save(productMapper.mapToEntity(product));
			});
		} catch (Exception e) {
			throw new RuntimeException("some Problem While Importing Data");
		}
	}

}
