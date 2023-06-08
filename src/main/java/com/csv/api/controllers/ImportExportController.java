package com.csv.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.csv.api.dtos.ProductRequestDto;
import com.csv.api.dtos.ProductResponseDto;
import com.csv.api.services.ProductService;

@RestController
@RequestMapping("/api/v1/product")
public class ImportExportController {
	
	@Autowired
	private ProductService productService;

	@GetMapping
	public ResponseEntity<List<ProductResponseDto>> getProducts() {
		return ResponseEntity.ok(productService.getProducts());
	}

	@PostMapping("/import")
	public ResponseEntity<Void> importProducts(@RequestParam MultipartFile file) {
//		https://mkyong.com/java/how-to-read-and-parse-csv-file-in-java/
		productService.importProducts(file);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

}
