package com.egg.orderManager.model.dto;

import com.egg.orderManager.model.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private String name;
    private Double price;
    private Integer stock;


}
