package com.csv.api.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDto {

	private Integer Id;
	
	private String productName;

	private Double productPrice;

	private Integer quantity;

}
