package com.csv.api.dtos;

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
	private String productName;

	@CsvBindByName(column = "Product Price")
	@CsvBindByPosition(position = 1)
	private Double productPrice;

	@CsvBindByName(column = "Quantity")
	@CsvBindByPosition(position = 2)
	private Integer quantity;

}
