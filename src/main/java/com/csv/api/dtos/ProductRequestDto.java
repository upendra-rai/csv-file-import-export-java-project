package com.csv.api.dtos;

import javax.validation.constraints.NotNull;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductRequestDto {

	@CsvBindByName(column = "Product Name")
	@CsvBindByPosition(position = 0)
	@NotNull(message="productName is required")
	private String productName;

	@CsvBindByName(column = "Product Price")
	@CsvBindByPosition(position = 1)
	@NotNull(message="productPrice is required")
	private Double productPrice;

	@CsvBindByName(column = "Quantity")
	@CsvBindByPosition(position = 2)
	private Integer quantity;

}
