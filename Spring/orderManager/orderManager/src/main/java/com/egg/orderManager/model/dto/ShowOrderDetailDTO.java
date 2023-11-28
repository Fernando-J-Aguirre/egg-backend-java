package com.egg.orderManager.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowOrderDetailDTO {

    private ProductDTO product;
    private Integer quantity;
}
